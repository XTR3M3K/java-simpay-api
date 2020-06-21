package pl.simpay.api.model.sms;

import lombok.Data;

import java.util.List;

@Data
public class Services {
    private String status;
    private List<Service> services;
}
