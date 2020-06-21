package pl.simpay.api.model.sms;

import lombok.Data;

import java.util.List;

@Data
public class ServiceListResponse {
    private Services services;
    private List<Object> error;
}
