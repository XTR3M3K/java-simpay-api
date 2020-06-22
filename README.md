# java-simpay-api

# Sms code verify
```
Sms sms = new Sms();
Sms sms = new Sms("key","secret");

CodeVerifyRequest codeVerifyRequest = new CodeVerifyRequest();
codeVerifyRequest.setCode("code");
codeVerifyRequest.setKey("key"); // can be omitted  by passing value in constructor
codeVerifyRequest.setSecret("secret"); // can be omitted  by passing value in constructor
codeVerifyRequest.setNumber("number");
codeVerifyRequest.setService_id("service_id");

APIResponse<CodeVerifyResponse> response = sms.verifyCode(codeVerifyRequest);
List<String> error = response.getError(); // List of errors, if request was successful list will be empty
CodeVerifyResponse codeVerifyResponse = response.getRespond();
int from = codeVerifyResponse.getFrom(); // Sender number
int number = codeVerifyResponse.getNumber(); // Number where sms were sent
String status = codeVerifyResponse.getStatus(); // Status received from api
int test = codeVerifyResponse.getTest(); // 1 if sms was test else 0
double value = codeVerifyResponse.getValue(); // Code Value
```

# Sms retrieve service list
```
Sms sms = new Sms();
Sms sms = new Sms("key","secret");


ServiceListRequest serviceListRequest = new ServiceListRequest();
serviceListRequest.setKey("key");
serviceListRequest.setSecret("secret");
APIResponse<ServicesResponse> response = sms.getServiceList(serviceListRequest);
List<String> error = response.getError(); // List of errors, if request was successful list will be empty
ServicesResponse serviceList = response.getRespond();
String status = serviceList.getStatus(); // Status received from api
List<Service> services = serviceList.getServices(); // List of services
```

# Sms xml
```
SmsXml smsXml = new SmsXml("apikey");
String code = smsXml.generateCode(); // Generate code
double number = smsXml.getSmsValue("number"); // retrieve information's about sms
String sms = smsXml.generateXml("sms"); // Generate xml from sms message
boolean ip = smsXml.getServersIp("ip"); // Check if passed ip is valid ip of simpay servers
```

# Direct billing - Generate Transaction
```
DirectBilling directBilling = new DirectBilling();
DirectBilling directBilling = new DirectBilling("apiKey", "secret", false, 1);

DbGenerateRequest dbGenerateRequest = new DbGenerateRequest();
dbGenerateRequest.setAmount("amount");
dbGenerateRequest.setAmount_gross("amount_gross");
dbGenerateRequest.setAmount_required("amount_required");
dbGenerateRequest.setComplete("complete");
dbGenerateRequest.setFailure("failure");
dbGenerateRequest.setProvider(Operator.ORANGE); // orange, play, t-mobile, plus-gsm
dbGenerateRequest.setControl("control");
dbGenerateRequest.setServiceId(1);
dbGenerateRequest.setSign("sign");

DbGenerateResponse dbGenerateResponse = directBilling.generateTransaction(dbGenerateRequest);
dbGenerateResponse.getLink(); // Link
dbGenerateResponse.getName(); // Transaction Name
dbGenerateResponse.getStatus(); // Status received from api
```

# Direct billing - get transaction by id
```
DirectBilling directBilling = new DirectBilling();
DirectBilling directBilling = new DirectBilling("apiKey", "secret", false, 1);

DbTransactionRequest dbTransactionRequest = new DbTransactionRequest();
dbTransactionRequest.setId(1);
dbTransactionRequest.setKey("key"); // can be omitted  by passing value in constructor
dbTransactionRequest.setSecret("secret");  // can be omitted  by passing value in constructor

APIResponse<DbTransaction> response = directBilling.getTransaction(dbTransactionRequest);
List<String> error = response.getError(); // List of errors, if request was successful list will be empty
DbTransaction respond = response.getRespond();
respond.getId();
respond.getControl();
respond.getNumber_from();
respond.getStatus();
respond.getValuenet();
respond.getValuenet_gross();
respond.getValuenet_partner();
respond.getSign();
```
