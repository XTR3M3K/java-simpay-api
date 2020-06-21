package pl.simpay.api.model.db;

import lombok.Data;

@Data
public class DbTransactionRequest {
    private String key;
    private String secret;
    private int id;
}
