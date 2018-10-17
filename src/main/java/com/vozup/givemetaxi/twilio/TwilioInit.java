package com.vozup.givemetaxi.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

//For Twilio

@Named("twilio")
public class TwilioInit {
    @Inject
    TwilioConfig twilioConfig;

    @PostConstruct
    public void init() {
        Twilio.init(twilioConfig.getSid(), twilioConfig.getToken());
    }

    //Validation +3809999999
    public void sendSms(String toNumber, String textMessage) {
        Message message = Message
                .creator(new PhoneNumber(toNumber), // to
                        new PhoneNumber("+12512572679"), // from
                        textMessage)
                .create();

        System.out.println(message.getSid());
    }
}
