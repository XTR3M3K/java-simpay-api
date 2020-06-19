package pl.simpay.api.model;

import lombok.Data;

@Data
public class Transaction {
    private int serviceId;
    private int provider;
    private String control;
    private String amountGross;
    private String complete;
    private String failure;
    private String sign;
}
