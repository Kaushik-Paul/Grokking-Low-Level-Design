package com.example.lowleveldesign.notifyme;

import com.example.lowleveldesign.notifyme.Observable.IphoneStockObservable;
import com.example.lowleveldesign.notifyme.Observable.StocksObservable;
import com.example.lowleveldesign.notifyme.Observer.EmailAlertObservable;
import com.example.lowleveldesign.notifyme.Observer.NotificationAlertObserver;
import com.example.lowleveldesign.notifyme.Observer.SmsAlertObserver;

public class Store {

    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IphoneStockObservable();

        NotificationAlertObserver observer1 = new EmailAlertObservable("lZU0E@example.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new SmsAlertObserver("1234567890", iphoneStockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObservable("OaE0O@example.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);

        iphoneStockObservable.setStockCount(10);

        iphoneStockObservable.setStockCount(-20);

        System.out.println("===================================================");

        iphoneStockObservable.setStockCount(2);
    }
}
