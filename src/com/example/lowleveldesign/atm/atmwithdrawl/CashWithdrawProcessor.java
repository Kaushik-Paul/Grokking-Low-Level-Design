package com.example.lowleveldesign.atm.atmwithdrawl;

import com.example.lowleveldesign.atm.atmobject.ATM;

public abstract class CashWithdrawProcessor {
    private CashWithdrawProcessor nextCashWithdrawalProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int withdrawalAmountRequest) {
        if (this.nextCashWithdrawalProcessor != null) {
            this.nextCashWithdrawalProcessor.withdraw(atm, withdrawalAmountRequest);
        }
    }

}
