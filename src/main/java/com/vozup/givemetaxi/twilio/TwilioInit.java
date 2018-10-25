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

//    @PostConstruct
//    public void init() {
//        Twilio.init(twilioConfig.getSid(), twilioConfig.getToken());
//    }

    @PostConstruct
    public void init() {
        Twilio.init("AC53ee0f9347c609d1656667e217cde2ae",
                "7d43bd41589a5399855eef6afde5c57c");
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
