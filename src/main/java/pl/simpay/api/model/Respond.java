package pl.simpay.api.model;

import lombok.Data;

@Data
public class Respond {
    private String status;
    private int test;
    private int from;
    private int number;
    private double value;
}
