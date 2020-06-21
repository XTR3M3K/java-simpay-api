package pl.simpay.api.payments;

import lombok.Data;
import pl.simpay.api.model.db.DbGenerateRequest;
import pl.simpay.api.model.db.DbGenerateResponse;
import pl.simpay.api.utils.Hashing;

@Data
public class DirectBilling {
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


    }
}
