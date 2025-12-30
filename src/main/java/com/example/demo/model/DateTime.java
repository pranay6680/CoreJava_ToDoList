package com.example.demo.model;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTime {
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
    String dateTime = localDateTime.format(dateTimeFormatter);

    public String getDateTime() {
        return dateTime;
    }
}
