package es.pjd.data.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Event {
    private Date date;
    private String title;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}
