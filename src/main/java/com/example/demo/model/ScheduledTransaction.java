package com.example.demo.model;

import javax.persistence.Entity;
import java.text.DateFormat;

@Entity
public class ScheduledTransaction extends AbstractEntity{
    private double Amount;
    private DateFormat NextSend;
    private String Schedule;
    private short Status;

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public DateFormat getNextSend() {
        return NextSend;
    }

    public void setNextSend(DateFormat nextSend) {
        NextSend = nextSend;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public short getStatus() {
        return Status;
    }

    public void setStatus(short status) {
        Status = status;
    }
}
