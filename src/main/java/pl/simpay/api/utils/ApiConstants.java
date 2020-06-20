package pl.simpay.api.utils;

public class ApiConstants {
    public static final String API_KEY = "x";
    public static final String API_SECRET = "x";

    //  Kod jednorazowy
    public static final String SMS_API_URL = "https://simpay.pl/api/status";

    // Direct Billing
    public static final String DB_KEY = "x";
    public static final String DB_API_URL = "https://simpay.pl/db/api";
    public static final String DB_STATUS_API_URL = "https://simpay.pl/api/db_status";
    public static final String DB_SERVICES_LIST_URL = "https://simpay.pl/api/get_services_db";
    public static final String DB_MAX_TRANSACTION_VALUE_URL = "https://simpay.pl/api/db_hosts";
    public static final String DB_SERVICE_COMMISSION_URL = "https://simpay.pl/api/db_hosts_commission";

    public static final String TRANSACTION_NOT_FOUND_MESSAGE = "Transaction Not Found";
    public static final String SIGN = "sign";
    public static final String CONTROL = "control";
    public static final String SERVICE_ID = "serviceId";
    public static final String COMPLETE = "complete";
    public static final String FAILURE = "failure";
    public static final String PROVIDER = "provider";
    public static final String PROVIDER_VALUE = "1";
    public static final String AMOUNT_VALUE = "1.00";
    public static final String FAILURE_DOMAIN_REDIRECT = "https://your.domain.com/failure";
    public static final String SUCCESS_DOMAIN_REDIRECT = "https://your.domain.com/success";
    public static final String NUMBER = "7136";
    public static final String CODE = "213";
    public static final String ACCEPT_HEADER = "Accept";
    public static final String ACCEPT_HEADER_VALUE = "application/json";
    public static final String CONTENT_TYPE_HEADER = "Content-type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String SMS_ID = "sms_id";
    public static final String SMS_SENDER = "sms_from";
    public static final String SMS_RECEIVER_NUMBER = "send_number";
    public static final String SMS_CONTENT = "sms_text";
    public static final String SMS_SENT_TIME = "send_time";
    public static final String PAYMENT_ID = "id";
    public static final String PAYMENT_STATUS = "status";
    public static final String PAYMENT_NET_VALUE = "valuenet";
    public static final String PAYMENT_NET_VALUE_GROSS = "valuenet_gross";
    public static final String PAYMENT_PARTNER_VALUE = "valuepartner";
    public static final String PAYMENT_SENDER_NUMBER = "number_from";
    public static final int FIRST_INDEX = 0;
}
