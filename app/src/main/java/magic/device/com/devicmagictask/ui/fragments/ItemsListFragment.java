package magic.device.com.devicmagictask.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import magic.device.com.devicmagictask.R;
import magic.device.com.devicmagictask.adpater.ItemsAdapter;
import magic.device.com.devicmagictask.data.model.Item;
import magic.device.com.devicmagictask.mvp.presenter.ItemsPresenter;
import magic.device.com.devicmagictask.mvp.view.ItemsContract;

public class ItemsListFragment extends Fragment implements ItemsContract.View {

    private static final String TAG = "ItemsListFragment";

    private ItemsAdapter itemsAdapter;

    private ItemsPresenter itemsPresenter;

    private ProgressBar progressBarLoading;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsAdapter = new ItemsAdapter(new ArrayList<String>());

        itemsPresenter = new ItemsPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        itemsPresenter.loadItems();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        itemsPresenter.stopPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_items_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //init recycle view
        RecyclerView recyclerViewDevices =
                (RecyclerView) view.findViewById(R.id.items_recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDevices.setLayoutManager(layoutManager);
        recyclerViewDevices.setHasFixedSize(true);
        recyclerViewDevices.setAdapter(itemsAdapter);

       progressBarLoading = (ProgressBar) view.findViewById(R.id.loading_progressBar);

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void addItemToList(Item item) {
        itemsAdapter.addItem(item);
    }

    @Override
    public void showFailureMessage() {
        progressBarLoading.setVisibility(View.GONE);
        Snackbar.make(getView(),
                getString(R.string.error_failed_load_items_message),
                Snackbar.LENGTH_SHORT).
                show();
    }

    @Override
    public void hideProgress() {
        progressBarLoading.setVisibility(View.GONE);
    }
}
