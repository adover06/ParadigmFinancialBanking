package com.pfb;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Map;

import com.pfb.dao.CustomerDAO;
import com.pfb.db.Db;
import com.pfb.model.Customer;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> config.staticFiles.add("/public", Location.CLASSPATH));
        CustomerDAO customers = new CustomerDAO();

        app.get("/api/health", ctx -> {
            try (Connection con = Db.getConnection()) {
                ctx.json(Map.of("db", "ok"));
            }
        });

        app.get("/api/customers/{id}", ctx -> {
            Customer c = customers.findCustomerById(Integer.parseInt(ctx.pathParam("id")));
            if (c == null) {
                ctx.status(404);
            } else {
                ctx.json(c);
            }
        });

        app.post("/api/customers", ctx -> {
            customers.addCustomer(new Customer(
                Integer.parseInt(ctx.formParam("id")),
                ctx.formParam("name"),
                ctx.formParam("address"),
                ctx.formParam("email"),
                LocalDate.parse(ctx.formParam("dob")),
                ctx.formParam("phone")));
            ctx.status(201);
        });

        app.start(8080);
    }
}
