package com.example.joan.truck_opt;

import java.util.List;

/**
 * Created by Biel on 9/9/2017.
 */

public class Delivery {
    private int id;
    private String from;
    private String to;
    private List<String> notifications;

    public Delivery(int id, String from, String to, List<String> notifications) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.notifications = notifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }
}
