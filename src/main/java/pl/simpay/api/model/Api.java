package pl.simpay.api.model;

import lombok.Data;

@Data
public class Api {
    private String serviceId;
    private String control;
    private String amount_gross;
    private String complete;
    private String failure;
    private String sign;
}
