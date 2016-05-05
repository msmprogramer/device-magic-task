package magic.device.com.devicmagictask.data.rest;

import java.util.concurrent.Executors;

import magic.device.com.devicmagictask.data.api.ItemsServiceApi;
import magic.device.com.devicmagictask.utils.Constants;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.converter.SimpleXMLConverter;

public class ItemsRestClient {

    private ItemsServiceApi itemsServiceApi;


    public ItemsRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BACKEND_API_URL)
                .setConverter(new SimpleXMLConverter())
                .setExecutors(Executors.newFixedThreadPool(3), new MainThreadExecutor())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        itemsServiceApi = restAdapter.create(ItemsServiceApi.class);
    }

    public ItemsServiceApi getService() {
        return itemsServiceApi;
    }
}
