package pl.simpay.api.model.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({
        "respond",
        "error"
})
public class ServiceList {
    @JsonProperty("respond")
    private Services services;
    private List<Object> error;
}
