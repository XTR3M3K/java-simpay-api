package pl.simpay.api.model;

import lombok.Data;

@Data
public class ApiResponse {
    private String status;
    private String link;
    private String name;
}
