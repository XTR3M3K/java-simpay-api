package pl.simpay.api.model.db;

import lombok.Data;
import pl.simpay.api.model.Operator;

@Data
public class DbGenerateRequest {
    private int serviceId = -1;
    private String control;
    private String complete;
    private String failure;
    private String amount;
    private String amount_gross;
    private String amount_required;
    private Operator provider;
    private String sign;
}
