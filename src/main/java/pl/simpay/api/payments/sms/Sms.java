package pl.simpay.api.payments.sms;

import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import pl.simpay.api.model.generic.APIResponse;
import pl.simpay.api.model.generic.ParametrizedRequest;
import pl.simpay.api.model.sms.request.ServiceListRequest;
import pl.simpay.api.model.sms.request.CodeVerifyRequest;
import pl.simpay.api.model.sms.respond.CodeVerifyRespond;
import pl.simpay.api.model.sms.respond.ServicesRespond;
import pl.simpay.api.utils.HttpService;

@AllArgsConstructor
public class Sms {
    private static final String VERIFY_CODE_URL = "https://simpay.pl/api/status";
    private static final String SERVICE_LIST_URL = "https://simpay.pl/api/get_services";
    private static final TypeToken<APIResponse<CodeVerifyRespond>> SERVICE_LIST_RESPONSE = new TypeToken<>() {
    };
    private static final TypeToken<APIResponse<ServicesRespond>> VERIFY_CODE_RESPONSE = new TypeToken<>() {
    };

    private final HttpService service;

    @SneakyThrows public CodeVerifyRespond verifyCode(@NonNull CodeVerifyRequest codeVerifyRequest) {
        return service.sendPost(VERIFY_CODE_URL, new ParametrizedRequest<>(codeVerifyRequest), VERIFY_CODE_RESPONSE.getType());
    }

    @SneakyThrows public ServicesRespond getServiceList(@NonNull ServiceListRequest serviceListRequest) {
        return service.sendPost(SERVICE_LIST_URL, new ParametrizedRequest<>(serviceListRequest), SERVICE_LIST_RESPONSE.getType());
    }
}
