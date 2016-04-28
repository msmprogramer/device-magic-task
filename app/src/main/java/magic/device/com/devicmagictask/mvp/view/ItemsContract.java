package magic.device.com.devicmagictask.mvp.view;

import android.support.annotation.NonNull;

import java.util.List;

import magic.device.com.devicmagictask.data.model.Item;

public interface ItemsContract {

    interface View {

        void addItemToList(Item item);

        void showFailureMessage();

        void hideProgress();
    }

    interface UserActionsListener {

        void loadItems();

        void loadItemById(String itemId, boolean isLastItem);

        void stopPresenter();
    }
}
