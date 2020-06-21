package pl.simpay.api.payments;

import lombok.Data;
import pl.simpay.api.model.db.DbGenerateRequest;
import pl.simpay.api.model.db.DbGenerateResponse;
import pl.simpay.api.utils.Hashing;
import pl.simpay.api.utils.HttpService;

@Data
public class DirectBilling {
    private static final HttpService service = new HttpService();
    private static final String API_URL = "https://simpay.pl/db/api";
    private static final String STATUS_API_URL = "https://simpay.pl/api/db_status";
    private static final String SERVICES_LIST_URL = "https://simpay.pl/api/get_services_db";
    private static final String MAX_TRANSACTION_VALUE_URL = "https://simpay.pl/api/db_hosts";
    private static final String SERVICE_COMMISSION_URL = "https://simpay.pl/api/db_hosts_commission";

    private String apiKey;
    private boolean debugMode;
    private int serviceId;

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

    public DbGenerateResponse generateTransaction(DbGenerateRequest request) {
        if (request.getServiceId() == -1) request.setServiceId(serviceId);

        String amount = "";

        if (request.getAmount() != null) amount = request.getAmount();
        if (request.getAmount_gross() != null) amount = request.getAmount_gross();
        if (request.getAmount_required() != null) amount = request.getAmount_required();

        request.setSign(Hashing.sha256hex(this.serviceId + "" + amount + "" + request.getControl() + "" + this.apiKey));

        return service.sendPost(API_URL, request, DbGenerateResponse.class);
    }
}
