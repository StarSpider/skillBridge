package org.moodle;

import com.google.gson.Gson;
import org.moodle.models.Request;
import org.moodle.models.SessionRequest;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    public static void start() {
        port(8080);
        Gson gson = new Gson();

        post("/api/sessions", (req, res) -> {
            res.type("application/json");

            try {
                // Parse JSON body to SessionRequest object
                SessionRequest sessionRequest = gson.fromJson(req.body(), SessionRequest.class);

                // TODO: Add your business logic here to process sessionRequest
                System.out.println("Received session request for student ID: " + sessionRequest.getStudentId());

                // Prepare success response
                Map<String, String> response = new HashMap<>();
                response.put("status", "success");
                response.put("message", "Session request received");

                return gson.toJson(response);

            } catch (Exception e) {
                res.status(400);
                Map<String, String> error = new HashMap<>();
                error.put("status", "error");
                error.put("message", "Invalid JSON or request format");
                return gson.toJson(error);
            }
        });
    }
}