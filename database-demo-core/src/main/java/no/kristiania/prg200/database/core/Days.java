package no.kristiania.prg200.database.core;

import java.util.Date;
import java.util.Objects;

public class Days {

    private String mon, tues, wed, thurs, fri, sat, sun;
    Date date;
    Long id;

    public Days(){
        this.mon = mon;
        this.tues = tues;
        this.wed = wed;
        this.thurs = thurs;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.date = date;
        this.id = id;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTues() {
        return tues;
    }

    public void setTues(String tues) {
        this.tues = tues;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThurs() {
        return thurs;
    }

    public void setThurs(String thurs) {
        this.thurs = thurs;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Days)){
            return false;
        }
        Days otherDays =(Days) o;
        return Objects.equals(mon, otherDays.mon)
                && Objects.equals(tues, otherDays.tues)
                && Objects.equals(wed, otherDays.wed)
                && Objects.equals(thurs, otherDays.thurs)
                && Objects.equals(fri, otherDays.fri)
                && Objects.equals(sat, otherDays.sat)
                && Objects.equals(sun, otherDays.sun)
                && Objects.equals(date, otherDays.date)
                && Objects.equals(id, otherDays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mon, tues, wed, thurs, fri, sat, sun, date, id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{mon=" + mon + ",tues=" + tues
                + ",wed=" + wed + ",thurs=" + thurs
                + ",fri=" + fri + ",sat=" + sat
                + ",sun=" + sun + ",date=" + date
                + ",id="  + id  + "}";
    }
}
