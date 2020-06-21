package pl.simpay.api.payments.sms;

import com.google.gson.reflect.TypeToken;
import pl.simpay.api.model.generic.APIResponse;
import pl.simpay.api.model.generic.IPResponse;
import pl.simpay.api.utils.HttpService;

public class SmsXml {
    private static final HttpService service = new HttpService();
    private static final String GET_IP_URL = "https://simpay.pl/api/get_ip";
    private static final TypeToken<APIResponse<IPResponse>> IP_RESPONSE = new TypeToken<>() {};



    // https://docs.simpay.pl/#lista-ip-serwerow-simpay
    public boolean getServersIp(String ip) {
        return service.sendGet(GET_IP_URL, IP_RESPONSE.getType());
    }
}
