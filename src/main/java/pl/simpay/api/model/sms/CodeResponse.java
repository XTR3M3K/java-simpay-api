package pl.simpay.api.model.sms;

import lombok.Data;

import java.util.List;

@Data
public class CodeResponse {
    private Respond respond;
    private List<Object> error;
}
