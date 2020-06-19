package pl.simpay.api.model;

import lombok.Data;

@Data
public class DbStatusRespond {
    private int id;
    private double valuenet;
    private double valuenet_gross;
    private double valuenet_partner;
    private String control;
    private String number_from;
    private String sign;
    private String status;
}
