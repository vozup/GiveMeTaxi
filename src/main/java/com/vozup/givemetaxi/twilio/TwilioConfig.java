package com.vozup.givemetaxi.twilio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("twilio.properties")
public class TwilioConfig {
    @Value("${twilio.sid:default}")
    private String twilioUser;

    @Value("${twilio.token:default}")
    private String twilioPassword;

    public String getTwilioUser() {
        return twilioUser;
    }

    public void setTwilioUser(String twilioUser) {
        this.twilioUser = twilioUser;
    }

    public String getTwilioPassword() {
        return twilioPassword;
    }

    public void setTwilioPassword(String twilioPassword) {
        this.twilioPassword = twilioPassword;
    }
}
