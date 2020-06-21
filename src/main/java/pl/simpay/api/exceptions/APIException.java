package pl.simpay.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import okhttp3.Response;

@AllArgsConstructor
@Getter
public class APIException extends RuntimeException {
    private Response response;
}
