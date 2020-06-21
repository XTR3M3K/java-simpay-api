package pl.simpay.api.model.services;

import lombok.Data;

import java.util.List;

@Data
public class Service {
    private int id;
    private String suffix;
    private List<String> numbers;
}
