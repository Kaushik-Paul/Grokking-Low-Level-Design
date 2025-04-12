package com.example.lowleveldesign.notifyme.Observer;

import com.example.lowleveldesign.notifyme.Observable.StocksObservable;

public class SmsAlertObserver implements NotificationAlertObserver {
    String phoneNumber;
    StocksObservable observable;

    public SmsAlertObserver(String phoneNumber, StocksObservable observable) {
        this.phoneNumber = phoneNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendSms(this.phoneNumber, "product is back in stock, hurry up");
    }

    private void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to: " + phoneNumber + ", " + message);
        // Perform SMS sending here
    }
}
