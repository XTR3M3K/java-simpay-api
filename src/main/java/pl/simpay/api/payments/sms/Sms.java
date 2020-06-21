package pl.simpay.api.payments.sms;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Response;
import pl.simpay.api.exceptions.ServicesNotFoundException;
import pl.simpay.api.exceptions.TransactionNotFoundException;
import pl.simpay.api.model.sms.CodeResponse;
import pl.simpay.api.model.sms.Respond;
import pl.simpay.api.model.sms.ServiceListResponse;
import pl.simpay.api.model.sms.Services;
import pl.simpay.api.utils.HttpService;

import static pl.simpay.api.utils.ApiConstants.*;

@AllArgsConstructor
public class Sms {
    private static final String SMS_API_URL = "https://simpay.pl/api/status";
    private static final String SERVICE_LIST_URL = "https://simpay.pl/api/get_services";

    private final HttpService service;

    @SneakyThrows
    public Respond verifyCode(pl.simpay.api.model.sms.Params params) {
        Response response = service.sendPost(SMS_API_URL, params);

        response.close();
        CodeResponse codeResponse = gson.fromJson(response.body().string(), CodeResponse.class);
        if (codeResponse.getRespond().getStatus().equalsIgnoreCase(RESPONSE_STATUS_OK)) {
            return codeResponse.getRespond();
        }
        throw new TransactionNotFoundException(TRANSACTION_NOT_FOUND_MESSAGE);
    }

    @SneakyThrows
    public Services getServiceList(pl.simpay.api.model.services.Params params) {
        Response response = service.sendPost(SERVICE_LIST_URL, params);

        response.close();
        ServiceListResponse serviceListResponse = gson.fromJson(response.body().string(), ServiceListResponse.class);
        if (serviceListResponse.getServices().getStatus().equalsIgnoreCase(RESPONSE_STATUS_OK)) {
            return serviceListResponse.getServices();
        }
        throw new ServicesNotFoundException();
    }
}
