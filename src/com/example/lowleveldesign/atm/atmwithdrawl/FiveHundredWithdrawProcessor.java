package com.example.lowleveldesign.atm.atmwithdrawl;

import com.example.lowleveldesign.atm.atmobject.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int withdrawalAmountRequest) {
        int required = withdrawalAmountRequest / 500;
        int balance = withdrawalAmountRequest % 500;

        if (required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        } else if (required > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + atm.getNoOfFiveHundredNotes() * 500;
        }

        if (balance > 0) {
            super.withdraw(atm, balance);
        }
    }
}
