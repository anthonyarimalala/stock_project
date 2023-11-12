package main;

import java.sql.Connection;

import main.PgConnection;

public class Main{
    public static void main(String[] args){
        Connection connection = PgConnection.connect();

    }
}