package com.pfb;

import java.sql.Connection;
import java.util.Map;

import com.pfb.db.Db;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/api/health", ctx -> {
            try (Connection con = Db.getConnection()) {
                ctx.json(Map.of("db", "ok"));
            }
        });

        app.start(8080);
    }
}
