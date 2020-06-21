package pl.simpay.api.payments.sms;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Response;
import pl.simpay.api.exceptions.ServicesNotFoundException;
import pl.simpay.api.exceptions.TransactionNotFoundException;
import pl.simpay.api.model.Parameters;
import pl.simpay.api.model.Respond;
import pl.simpay.api.model.services.Params;
import pl.simpay.api.model.services.Services;
import pl.simpay.api.utils.HttpService;

import static pl.simpay.api.utils.ApiConstants.*;

@AllArgsConstructor
public class Sms {

    private final HttpService service;

    @SneakyThrows
    public Respond verifyCode(Parameters parameters) {
        Response response = service.sendPost(SMS_API_URL, parameters);
        int code = response.code();

        response.close();
        if (code == HTTP_OK_CODE) {
            Respond respond = gson.fromJson(response.body().string(), Respond.class);
            if (respond.getStatus().equalsIgnoreCase(RESPONSE_STATUS_OK)) {
                return respond;
            }
        }
        throw new TransactionNotFoundException(TRANSACTION_NOT_FOUND_MESSAGE);
    }

    @SneakyThrows
    public Services getServiceList(Params params) {
        Response response = service.sendPost(SERVICE_LIST_URL, params);
        int code = response.code();

        response.close();
        if (code == HTTP_OK_CODE) {
            Services services = gson.fromJson(response.body().string(), Services.class);
            if (services.getStatus().equalsIgnoreCase(RESPONSE_STATUS_OK)) {
                return services;
            }
        }
        throw new ServicesNotFoundException();
    }
}
