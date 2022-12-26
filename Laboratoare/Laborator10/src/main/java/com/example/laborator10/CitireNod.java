package com.example.laborator10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public interface CitireNod {
    public default String citesteInfo(String txt) {
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));
        String info;
        System.out.print(txt + ":");
        try {
            info= r.readLine().trim();
        } catch(IOException e) {
            info="";
            System.out.println(e);
        }
        return info;
    }
} //