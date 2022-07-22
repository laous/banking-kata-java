package org.miola.models;

public class Account {
    private int id;
    private int clientId;
    private float balance;

    public Account() {
    }

    public Account(int id, int clientId, float balance) {
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
