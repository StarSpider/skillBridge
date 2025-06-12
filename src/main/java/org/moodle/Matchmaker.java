package org.moodle;

import org.moodle.models.Request;
import java.io.FileWriter;
import java.io.IOException;

public class Matchmaker {
    public static void storeSession(Request req) {
        try (FileWriter fw = new FileWriter("sessions.log", true)) {
            fw.write("UserID: " + req.userid + "\n");
            fw.write("Topic: " + req.topic + "\n");
            fw.write("Description: " + req.description + "\n");
            fw.write("----------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}