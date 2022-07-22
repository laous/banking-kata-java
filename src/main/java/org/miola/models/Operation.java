package org.miola.models;

import org.miola.utils.OperationType;

import java.time.LocalDate;
import java.time.ZoneId;

public class Operation {
    private int id;
    private int clientId;
    private int accountId;
    private OperationType type;  // DP | WW
    private float amount;
    private String createdAt;

    public Operation(int id, int clientId, int accountId, OperationType type, float amount, String createdAt) {
        this.id = id;
        this.clientId = clientId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.createdAt = String.valueOf(LocalDate.now());
    }

    public Operation(int clientId, int accountId, OperationType type, float amount) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.createdAt = String.valueOf(LocalDate.now());
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}


