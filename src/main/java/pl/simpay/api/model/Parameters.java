package pl.simpay.api.model;

import lombok.Data;

@Data
public class Parameters {
    private String key;
    private String secret;
    private String service_id;
    private String number;
    private String code;
}
