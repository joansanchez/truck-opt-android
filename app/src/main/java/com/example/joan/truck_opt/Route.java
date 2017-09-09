package com.example.joan.truck_opt;

import java.util.List;

/**
 * Created by Biel on 9/9/2017.
 */

public class Route {
    private String from;
    private String to;
    private Double profit;
    private List<String> waypoints;

    public Route(String from, String to, Double profit, List<String> waypoints) {
        this.from = from;
        this.to = to;
        this.profit = profit;
        this.waypoints = waypoints;
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

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public List<String> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", profit=" + profit +
                ", waypoints=" + waypoints +
                '}';
    }
}
