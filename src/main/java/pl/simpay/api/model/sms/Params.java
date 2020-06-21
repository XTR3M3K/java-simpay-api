package pl.simpay.api.model.sms;

import lombok.Data;

@Data
public class Params {
    private String key;
    private String secret;
    private String service_id;
    private String number;
    private String code;
}
