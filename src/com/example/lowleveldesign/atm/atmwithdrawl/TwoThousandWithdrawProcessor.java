package com.example.lowleveldesign.atm.atmwithdrawl;

import com.example.lowleveldesign.atm.atmobject.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int withdrawalAmountRequest) {
        int required = withdrawalAmountRequest / 2000;
        int balance = withdrawalAmountRequest % 2000;

        if (required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        } else if (required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + atm.getNoOfTwoThousandNotes() * 2000;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
