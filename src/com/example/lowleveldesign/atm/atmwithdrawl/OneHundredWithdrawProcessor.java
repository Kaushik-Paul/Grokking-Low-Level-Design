package com.example.lowleveldesign.atm.atmwithdrawl;

import com.example.lowleveldesign.atm.atmobject.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int withdrawalAmountRequest) {
        int required = withdrawalAmountRequest / 100;
        int balance = withdrawalAmountRequest % 100;

        if (required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        } else if (required > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + atm.getNoOfOneHundredNotes() * 100;
        }

        if (balance != 0) {
            System.out.println("Something went wrong");
        }
    }
}
