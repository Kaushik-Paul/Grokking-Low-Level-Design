package com.example.lowleveldesign.atm.atmobject;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes() {
        for (TransactionType txnType : TransactionType.values()) {
            System.out.println(txnType.name());
        }
    }
}
