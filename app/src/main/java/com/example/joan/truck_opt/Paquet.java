package com.example.joan.truck_opt;

import java.util.ArrayList;

/**
 * Created by joan on 9/09/17.
 */

public class Paquet {
    private int id;
    private String from;
    private String to;
    private ArrayList<String> notis;

    Paquet (int id, String from, String to, ArrayList<String> notis){
        this.id = id;
        this.from = from;
        this.to = to;
        this.notis = new ArrayList<String>(notis);
    }

    public int getId () { return id;}

    public String getFrom() {return from;}

    public String getTo() {return to;}

    public ArrayList<String> getnotis() { return notis;}

}
