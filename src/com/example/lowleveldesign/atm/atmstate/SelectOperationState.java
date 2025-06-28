package com.example.lowleveldesign.atm.atmstate;

import com.example.lowleveldesign.atm.atmobject.ATM;
import com.example.lowleveldesign.atm.atmobject.Card;
import com.example.lowleveldesign.atm.atmobject.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState() {
        showOperationsMenu();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new BalanceCheckState());
                break;
            default:
                System.out.println("Invalid Transaction type");
                exit(atm);
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

    private void showOperationsMenu() {
        System.out.println("Please select an operation");
        TransactionType.showAllTransactionTypes();
    }

}
