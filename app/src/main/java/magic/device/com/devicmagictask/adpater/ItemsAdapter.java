package magic.device.com.devicmagictask.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import magic.device.com.devicmagictask.R;
import magic.device.com.devicmagictask.data.model.Item;
import magic.device.com.devicmagictask.mvp.presenter.ItemsDetailsPresenter;
import magic.device.com.devicmagictask.mvp.view.ItemsDetailsContract;

import static com.google.common.base.Preconditions.checkNotNull;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private static final String TAG = "DevicesAdapter";

    private Context context;

    private List<String> items;

    private SparseBooleanArray loadedItems = new SparseBooleanArray();


    public ItemsAdapter(List<String> items) {
        setList(items);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View ItemView = inflater.inflate(R.layout.item_row, parent, false);
        ItemViewHolder holder = new ItemViewHolder(ItemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int position) {
        String itemPhrase = items.get(position);

        if (!loadedItems.get(position)) {
            itemViewHolder.loadPhrase(itemPhrase);
            loadedItems.put(position, true);
        } else {
            itemViewHolder.textViewItemPhrase.
                    setText(context.getString(R.string.txt_loading));
        }
    }

    public String getItem(int position) {
        return items.get(position);
    }

    public void replaceData(List<String> items) {
        setList(items);
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        items.add(item.getValue());
        notifyDataSetChanged();
    }

    private void setList(@NonNull List<String> items) {
        this.items = checkNotNull(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements ItemsDetailsContract.View {


        public TextView textViewItemPhrase;

        private ItemsDetailsPresenter itemsDetailsPresenter;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewItemPhrase = (TextView) itemView.findViewById(R.id.itemPhrase_textView);

            itemsDetailsPresenter = new ItemsDetailsPresenter(this);
        }

        public void loadPhrase(String itemId) {
            itemsDetailsPresenter.loadItemById(itemId);
        }

        @Override
        public void showItem(Item item) {
            textViewItemPhrase.setText(item.getValue());
        }

        @Override
        public void showFailureMessage() {
            textViewItemPhrase.
                    setText(context.getString(R.string.error_failed_load_item_message));
        }
    }

}
