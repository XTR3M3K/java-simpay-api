package pl.simpay.api.model;

import lombok.Setter;

public enum Operator {
    ORANGE(1),
    PLAY(2),
    T_MOBILE(3),
    PLUS_GSM(4);

    @Setter
    private int value;

    Operator(int value) {
        this.value = value;
    }
}
