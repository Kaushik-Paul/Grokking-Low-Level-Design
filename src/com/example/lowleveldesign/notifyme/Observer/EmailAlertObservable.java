package com.example.lowleveldesign.notifyme.Observer;

import com.example.lowleveldesign.notifyme.Observable.StocksObservable;

public class EmailAlertObservable implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;

    public EmailAlertObservable(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(this.emailId, "product is back in stock, hurry up");
    }

    private void sendEmail(String emailId, String message) {
        System.out.println("Sending email to: " + emailId + ", " + message);
        // Perform email sending here

    }
}
