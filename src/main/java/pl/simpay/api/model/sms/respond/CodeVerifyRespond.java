package pl.simpay.api.model.sms.respond;

import lombok.Data;

@Data
public class CodeVerifyRespond {
    private String status;
    private int test;
    private int from;
    private int number;
    private double value;
}
