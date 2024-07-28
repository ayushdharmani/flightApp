package org.flight;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    public SmsService(@Value("${twilio.account.sid}") String accountSid,
                      @Value("${twilio.auth.token}") String authToken) {
        Twilio.init(accountSid, authToken);
    }

    public void sendStatusUpdateSms(String to, String flightId, String status) {
        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(fromPhoneNumber),
                "The status of flight " + flightId + " has been updated to " + status + "."
        ).create();
    }
}
