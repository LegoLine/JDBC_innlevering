package no.kristiania.prg200.database.core;

import java.util.Date;
import java.util.Objects;

public class Days {

    private static String days;
    Date date;
    private static Long id;

    public Days(){
        this.days = days;
        this.date = date;
        this.id = id;
    }

    public static String getDays() {
        return days;
    }


    public void setDays(String days) {
        this.days = days;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public static void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Days)){
            return false;
        }
        Days otherDays =(Days) o;
        return Objects.equals(days, otherDays.days)
                && Objects.equals(date, otherDays.date)
                && Objects.equals(id, otherDays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, date, id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{days=" + days
                + ",date=" + date
                + ",id="   + id  + "}";
    }
}
