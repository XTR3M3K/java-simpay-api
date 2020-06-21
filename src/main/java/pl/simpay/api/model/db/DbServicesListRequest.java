package pl.simpay.api.model.db;

import lombok.Data;

@Data
public class DbServicesListRequest {
    private String api;
    private String secret;
}
