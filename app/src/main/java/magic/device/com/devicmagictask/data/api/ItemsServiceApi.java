package magic.device.com.devicmagictask.data.api;

import java.util.List;

import magic.device.com.devicmagictask.data.model.Download;
import magic.device.com.devicmagictask.data.model.Downloads;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface ItemsServiceApi {

    @GET("/")
    void getItems(Callback<Downloads> itemsCallback);

    @GET("/downloads/{itemId}")
    void getItemById(@Path("itemId") String itemId, Callback<Download> itemCallback);

}
