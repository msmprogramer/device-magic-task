package magic.device.com.devicmagictask.mvp.presenter;

import android.support.annotation.NonNull;

import magic.device.com.devicmagictask.data.api.ItemsServiceApi;
import magic.device.com.devicmagictask.data.model.Download;
import magic.device.com.devicmagictask.data.rest.ItemsRestClient;
import magic.device.com.devicmagictask.mvp.view.ItemsDetailsContract;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.google.common.base.Preconditions.checkNotNull;

public class ItemsDetailsPresenter implements ItemsDetailsContract.UserActionsListener {

    private ItemsDetailsContract.View itemsDetailsView;

    private ItemsServiceApi itemsServiceApi;

    public ItemsDetailsPresenter(@NonNull ItemsDetailsContract.View itemsDetailsView) {
        this.itemsDetailsView = checkNotNull(itemsDetailsView);
        itemsServiceApi =  ItemsRestClient.getInstance().getService();
    }

    @Override
    public void loadItemById(final String itemId) {
        itemsServiceApi.getItemById(itemId, new Callback<Download>() {
            @Override
            public void success(Download download, Response response) {

                if (download == null) {
                    return;
                }

                itemsDetailsView.showItem(download.getItem());
            }

            @Override
            public void failure(RetrofitError error) {
                itemsDetailsView.showFailureMessage(itemId);
            }
        });
    }
}