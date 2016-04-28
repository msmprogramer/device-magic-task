package magic.device.com.devicmagictask.mvp.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import magic.device.com.devicmagictask.data.api.ItemsServiceApi;
import magic.device.com.devicmagictask.data.model.Downloads;
import magic.device.com.devicmagictask.data.rest.ItemsRestClient;
import magic.device.com.devicmagictask.mvp.view.ItemsContract;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.google.common.base.Preconditions.checkNotNull;

public class ItemsPresenter implements ItemsContract.UserActionsListener{

    private static final String TAG = "ItemsPresenter";

    private ItemsContract.View itemsView;

    private ItemsServiceApi itemsServiceApi;

    public ItemsPresenter(@NonNull ItemsContract.View itemsView) {
        this.itemsView = checkNotNull(itemsView);
        itemsServiceApi = new ItemsRestClient().getService();
    }

    @Override
    public void loadItems() {
        itemsServiceApi.getItems(new Callback<Downloads>() {
            @Override
            public void success(Downloads downloads, Response response) {
                Log.d(TAG, "success: "+downloads.getItems().size());

                if (itemsView == null) {
                    return;
                }

                itemsView.showItems(downloads.getItems());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "failure: "+error.getMessage());
                itemsView.showFailureMessage();
            }
        });

    }

    @Override
    public void stopPresenter() {
        itemsView = null;
    }
}
