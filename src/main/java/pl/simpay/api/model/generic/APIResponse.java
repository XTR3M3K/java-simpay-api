package pl.simpay.api.model.generic;

import java.util.List;

public class APIResponse<T> {
    private T respond;
    private List<String> error;
}
