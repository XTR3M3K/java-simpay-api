package pl.simpay.api.payments.sms;

import com.google.gson.reflect.TypeToken;
import pl.simpay.api.model.generic.APIResponse;
import pl.simpay.api.model.sms.respond.IpRespond;
import pl.simpay.api.utils.HttpService;

public class SmsXml {
    private static final HttpService service = new HttpService();
    private static final String GET_IP_URL = "https://simpay.pl/api/get_ip";
    private static final TypeToken<APIResponse<IpRespond>> IP_RESPONSE = new TypeToken<>() {};



    private boolean checkIsIpValid(String ip) {
        IpRespond response = service.sendGet(GET_IP_URL, IP_RESPONSE.getType());
        return response.getIps().contains(ip);
    }
}
