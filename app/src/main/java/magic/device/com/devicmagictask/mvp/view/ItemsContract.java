package magic.device.com.devicmagictask.mvp.view;

import android.support.annotation.NonNull;

import java.util.List;

import magic.device.com.devicmagictask.data.model.Item;

public interface ItemsContract {

    interface View {

        void showItems(List<String> items);

        void showFailureMessage();

        void hideProgress();
    }

    interface UserActionsListener {

        void loadItems();

        void stopPresenter();
    }
}
