package magic.device.com.devicmagictask.mvp.view;

import magic.device.com.devicmagictask.data.model.Item;

public interface ItemsDetailsContract {

    interface View {

        void showItem(Item item);

        void showFailureMessage();
    }

    interface UserActionsListener {

        void loadItemById(String itemId);
    }
}