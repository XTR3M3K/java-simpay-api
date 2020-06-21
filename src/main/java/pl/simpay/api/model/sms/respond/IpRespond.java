package pl.simpay.api.model.sms.respond;

import lombok.Data;

import java.util.List;

@Data
public class IpRespond {
    private String status;
    private List<String> ips;
}
