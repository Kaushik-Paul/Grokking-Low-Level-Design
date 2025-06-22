package com.example.lowleveldesign.atm.atmstate;

import com.example.lowleveldesign.atm.atmobject.ATM;
import com.example.lowleveldesign.atm.atmobject.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Enter the amount to withdraw");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawAmount) {
        if (atmObject.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            // TODO: Create classes for this logic as well
            card.deductBankBalance(withdrawAmount);
            atmObject.deductATMBalance(withdrawAmount);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }

    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exited from ATM");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
