package pl.simpay.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.*;
import pl.simpay.api.exceptions.APIException;

import static pl.simpay.api.utils.ApiConstants.CONTENT_TYPE_VALUE;

@Data
public class HttpService {
    private OkHttpClient init() {
        return new OkHttpClient();
    }

    private Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @SneakyThrows public Response sendPost(String url, Object object) {
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody = RequestBody.create(MediaType.parse(CONTENT_TYPE_VALUE), gson().toJson(object));
        Request request = builder.url(url).post(requestBody).build();
        
        try (Response response = init().newCall(request).execute().networkResponse()) {
            if (response.code() != ApiConstants.HTTP_OK_CODE) {
                throw new APIException(response);
            }

            return response;
        }
    }

    @SneakyThrows public <T> T sendPost(String url, Object object, Class<T> clazz) {
        return gson().fromJson(this.sendPost(url, object).body().string(), clazz);
    }
}
