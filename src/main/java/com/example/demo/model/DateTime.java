package com.example.demo.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
    String dateTime = localDateTime.format(dateTimeFormatter);

    public String getDateTime() {
        return dateTime;
    }
}
