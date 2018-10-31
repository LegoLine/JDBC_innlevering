package no.kristiania.prg200.database.core;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;

/**
 * I denne klassen kobler vi sammen klassene Days + DaysDao, Talks + TalksDao, Rooms + RoomsDao og Timeslots + TimeslotsDao.
 *
 * TODO: Ordne opp i denne klassen så man tar i bruk de andre klassene.
 */

public class Tracks {
    Long id;
    String tracks;

    Long days_id, rooms_id, talks_id, timeslots_id;
    Days days= new Days ();
    Rooms rooms = new Rooms ();
    Talks talks = new Talks ();
    Timeslots timeslots = new Timeslots ();



    public Tracks() {
        this.tracks = tracks;
        this.id = id;

        days_id = days.getId();
        rooms_id = rooms.getId ();
        talks_id = talks.getId ();
        timeslots_id = timeslots.getId ();
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDays_id(Long days_id) {
        this.days_id = days_id;
    }

    public void setRooms_id(Long rooms_id) {
        this.rooms_id = rooms_id;
    }

    public void setTalks_id(Long talks_id) {
        this.talks_id = talks_id;
    }

    public void setTimeslots_id(Long timeslots_id) {
        this.timeslots_id = timeslots_id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tracks)){
            return false;
        }
        Tracks otherTracks =(Tracks) o;
        return Objects.equals(tracks, otherTracks.tracks)
                && Objects.equals(id, otherTracks.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracks, id);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "{tracks="     + tracks       + ",id="
                                          + id             + ", days_id=" + days_id
                                          + ",rooms_id="   + rooms_id     + ",talks_id=" + talks_id
                                          + "timeslots_id" + timeslots_id +"}";
    }

}