package magic.device.com.devicmagictask.data.rest;

import magic.device.com.devicmagictask.data.api.ItemsServiceApi;
import magic.device.com.devicmagictask.utils.Constants;
import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

public class ItemsRestClient {

    private ItemsServiceApi itemsServiceApi;


    public ItemsRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BACKEND_API_URL)
                .setConverter(new SimpleXMLConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        itemsServiceApi = restAdapter.create(ItemsServiceApi.class);
    }

    public ItemsServiceApi getService() {
        return itemsServiceApi;
    }
}
