package com.techelevator.model;

public class Transaction {

    private final String command;
    private final Money amount;
    private final Money finalBalance;
    private final String dispenseMessage;

    public Transaction(String command, Money amount, Money finalBalance, String dispenseMessage) {
        this.command = command;
        this.amount = amount;
        this.finalBalance = finalBalance;
        this.dispenseMessage = dispenseMessage;
    }

    public String getCommand() {
        return command;
    }

    public Money getAmount() {
        return amount;
    }

    public Money getFinalBalance() {
        return finalBalance;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }
}
