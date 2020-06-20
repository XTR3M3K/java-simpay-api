package pl.simpay.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.*;

import static pl.simpay.api.utils.ApiConstants.CONTENT_TYPE_VALUE;

@Data
public class HttpService {

    private static OkHttpClient init() {
        return new OkHttpClient();
    }

    private static Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @SneakyThrows
    public Response sendPost(String url, Object object) {
        Request.Builder builder = new Request.Builder();
        RequestBody requestBody = RequestBody.create(MediaType.parse(CONTENT_TYPE_VALUE), gson().toJson(object));
        Request request = builder.url(url).post(requestBody).build();
        return init().newCall(request).execute().networkResponse();
    }
}
