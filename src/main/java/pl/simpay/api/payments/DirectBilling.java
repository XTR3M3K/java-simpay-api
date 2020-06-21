package pl.simpay.api.payments;

import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.NonNull;
import pl.simpay.api.model.db.*;
import pl.simpay.api.model.db.requests.*;
import pl.simpay.api.model.db.responses.DbGenerateResponse;
import pl.simpay.api.model.db.responses.DbServicesListResponse;
import pl.simpay.api.model.generic.APIResponse;
import pl.simpay.api.model.generic.ParametrizedRequest;
import pl.simpay.api.model.generic.IPResponse;
import pl.simpay.api.utils.Hashing;
import pl.simpay.api.utils.HttpService;

import java.util.List;

@Data
public class DirectBilling {
    private static final HttpService service = new HttpService();
    private static final String API_URL = "https://simpay.pl/db/api";
    private static final String TRANSACTION_STATUS_URL = "https://simpay.pl/api/db_status";
    private static final String SERVICES_LIST_URL = "https://simpay.pl/api/get_services_db";
    private static final String TRANSACTION_LIMITS_URL = "https://simpay.pl/api/db_hosts";
    private static final String SERVICE_COMMISSION_URL = "https://simpay.pl/api/db_hosts_commission";
    private static final String GET_IP_URL = "https://simpay.pl/api/get_ip";

    private static final TypeToken<APIResponse<IPResponse>> IP_RESPONSE = new TypeToken<>() {};
    private static final TypeToken<APIResponse<DbTransaction>> DB_TRANSACTION_RESPONSE = new TypeToken<>() {};
    private static final TypeToken<APIResponse<DbServicesListResponse>> DB_SERVICES_LIST_RESPONSE = new TypeToken<>() {};
    private static final TypeToken<APIResponse<List<DbTransactionLimit>>> DB_TRANSACTION_LIMITS_RESPONSE = new TypeToken<>() {};
    private static final TypeToken<APIResponse<List<DbCommission>>> DB_SERVICE_COMMISSION_RESPONSE = new TypeToken<>() {};

    private String apiKey;
    private String secret;
    private boolean debugMode;
    private int serviceId;

    public DirectBilling(String apiKey, String secret, boolean debugMode, int serviceId) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.debugMode = debugMode;
        this.serviceId = serviceId;
    }

    public DirectBilling(String apiKey, boolean debugMode, int serviceId) {
        this.apiKey = apiKey;
        this.debugMode = debugMode;
        this.serviceId = serviceId;
    }

    public DirectBilling(String apiKey, boolean debugMode) {
        this.apiKey = apiKey;
        this.debugMode = debugMode;
    }

    public DirectBilling(String apiKey) {
        this(apiKey, false);
    }

    // https://docs.simpay.pl/#generowanie-transakcji
    public DbGenerateResponse generateTransaction(@NonNull DbGenerateRequest request) {
        if (request.getServiceId() == -1) request.setServiceId(serviceId);

        String amount = "";

        if (request.getAmount() != null) amount = request.getAmount();
        if (request.getAmount_gross() != null) amount = request.getAmount_gross();
        if (request.getAmount_required() != null) amount = request.getAmount_required();

        request.setSign(Hashing.sha256hex(this.serviceId + "" + amount + "" + request.getControl() + "" + this.apiKey));

        return service.sendPost(API_URL, request, DbGenerateResponse.class);
    }

    // https://docs.simpay.pl/#pobieranie-danych-o-transakcji
    public APIResponse<DbTransaction> getTransaction(@NonNull DbTransactionRequest request) {
        if (request.getKey() == null) request.setKey(apiKey);
        if (request.getSecret() == null) request.setSecret(secret);

        return service.sendPost(TRANSACTION_STATUS_URL, new ParametrizedRequest<>(request), DB_TRANSACTION_RESPONSE.getType());
    }

    // https://docs.simpay.pl/#pobieranie-listy-uslug-dcb
    public APIResponse<DbServicesListResponse> getServices(@NonNull DbServicesListRequest request) {
        if (request.getApi() == null) request.setApi(apiKey);
        if (request.getSecret() == null) request.setSecret(secret);

        return service.sendPost(SERVICES_LIST_URL, new ParametrizedRequest<>(request), DB_SERVICES_LIST_RESPONSE.getType());
    }

    // https://docs.simpay.pl/#pobieranie-maksymalnych-kwot-transakcji
    public APIResponse<List<DbTransactionLimit>> getTransactionLimits(@NonNull DbTransactionLimitsRequest request) {
        if (request.getApi() == null) request.setApi(apiKey);
        if (request.getSecret() == null) request.setSecret(secret);

        return service.sendPost(TRANSACTION_LIMITS_URL, new ParametrizedRequest<>(request), DB_TRANSACTION_LIMITS_RESPONSE.getType());
    }

    // https://docs.simpay.pl/#pobieranie-prowizji-dla-uslugi
    public APIResponse<List<DbCommission>> getServiceCommission(@NonNull DbServiceCommissionRequest request) {
        if (request.getApi() == null) request.setApi(apiKey);
        if (request.getSecret() == null) request.setSecret(secret);

        return service.sendPost(SERVICE_COMMISSION_URL, new ParametrizedRequest<>(request), DB_SERVICE_COMMISSION_RESPONSE.getType());
    }

    // https://docs.simpay.pl/#lista-ip-serwerow-simpay
    public boolean getServersIp(String ip) {
        return service.sendGet(GET_IP_URL, IP_RESPONSE.getType());
    }

    // https://docs.simpay.pl/#odbieranie-transakcji
    public String sign(int id, String status, String valuenet, String valuepartner, String control) {
        return Hashing.sha256hex(id + status + valuenet + valuepartner + control + apiKey);
    }
}
