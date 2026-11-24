package com.pfb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Db {
    private static final Dotenv env = Dotenv.load();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(env.get("DB_URL"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }
}
