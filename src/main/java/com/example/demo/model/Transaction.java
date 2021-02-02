package com.example.demo.model;

import javax.persistence.Entity;
import java.text.DateFormat;

@Entity
public class Transaction  extends AbstractEntity{
    private int CategoryId;
    private int UserId;
    private int SchTransactionId;
    private DateFormat Date;
    private double Amount;
    private boolean IsIncome;
    private String Comment;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getSchTransactionId() {
        return SchTransactionId;
    }

    public void setSchTransactionId(int schTransactionId) {
        SchTransactionId = schTransactionId;
    }

    public DateFormat getDate() {
        return Date;
    }

    public void setDate(DateFormat date) {
        Date = date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public boolean isIncome() {
        return IsIncome;
    }

    public void setIncome(boolean income) {
        IsIncome = income;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
