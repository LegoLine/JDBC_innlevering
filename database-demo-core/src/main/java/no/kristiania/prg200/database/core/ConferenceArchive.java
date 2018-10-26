package no.kristiania.prg200.database.core;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Collects the conference talks, days and timeslots.
 */



public class ConferenceArchive {


    private ArrayList<Days> collectedConferences;

    private Scanner scanner;

    public ConferenceArchive(){
        collectedConferences = new ArrayList<Days>();

        scanner = new Scanner(System.in);
    }

    public boolean createStandardConference(){
        Days d = new Days(1L, "Mandag", "02.11.2018");
        Talks t = new Talks();
        Timeslots ts = new Timeslots ();
        collectedConferences.add(d);
        return true;
    }


}
