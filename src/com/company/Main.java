package com.company;

import java.sql.Time;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Fenetre fn = new Fenetre();
        Thread thread = new Thread(fn);
        thread.start();
    }
}
