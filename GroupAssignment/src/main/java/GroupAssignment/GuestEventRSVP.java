/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupAssignment;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author c8mun
 */
public class GuestEventRSVP {
    
    private StringProperty username;
    public StringProperty event_location;
    public StringProperty event_title;
    public ObjectProperty<LocalDate> event_date;
    public IntegerProperty event_time;
    public IntegerProperty rsvpID;
    private SimpleStringProperty decision;
    private StringProperty dietary_notes;
    private ObjectProperty<LocalDate> rsvp_date;

    public GuestEventRSVP () {
        
    }
    
    public GuestEventRSVP(int rsvpID, String username, String event_location, String event_title,
    LocalDate event_date, int event_time, String decision, String dietary_notes, LocalDate rsvp_date) {
        this.rsvpID = new SimpleIntegerProperty(rsvpID);
        this.event_location = new SimpleStringProperty(event_location);
        this.event_title = new SimpleStringProperty(event_title);
        this.event_date = new SimpleObjectProperty(event_date);
        this.event_time = new SimpleIntegerProperty(event_time);
        this.decision = new SimpleStringProperty(decision);
        this.dietary_notes = new SimpleStringProperty(dietary_notes);
        this.rsvp_date = new SimpleObjectProperty(rsvp_date);
        this.username = new SimpleStringProperty(username);

    }
    //setters

    public void setusername(String username) {
        this.username = new SimpleStringProperty(username);
    }

    public void setevent_location(String event_location) {
        this.event_location = new SimpleStringProperty(event_location);
    }

    public void setevent_title(String event_title) {
        this.event_title = new SimpleStringProperty(event_title);
    }

    public void setevent_date(LocalDate event_date) {
        this.event_date = new SimpleObjectProperty(event_date);
    }

    public void setevent_time(int event_time) {
        this.event_time = new SimpleIntegerProperty(event_time);
    }

    public void setdecision(String decision) {
        this.decision = new SimpleStringProperty(decision);
    }

    public void setdietary_notes(String dietary_notes) {
        this.dietary_notes = new SimpleStringProperty(dietary_notes);
    }

    public void setrsvp_date(LocalDate rsvp_date) {
        this.rsvp_date = new SimpleObjectProperty(rsvp_date);
    }
    
    public void setrsvpID(int rsvpID) {
        this.rsvpID = new SimpleIntegerProperty(rsvpID);
    }
    
    //getters
    
    public String getusername() {
        return username.get();
    }

    public String getevent_location() {
        return event_location.get();
    }

    public String getevent_title() {
        return event_title.get();
    }

    public LocalDate getevent_date() {
        return event_date.get();
    }

    public int getevent_time() {
        return event_time.get();
    }

    public String getdecision() {
       return this.decision.get();
    }

    public String getdietary_notes() {
        return dietary_notes.get();
    }

    public LocalDate getrsvp_date() {
        return rsvp_date.get();
    }
    
    public int getrsvpID() {
         return this.rsvpID.get();
    }
    
    //property methods

    public StringProperty usernameProperty() {
        return this.username;
    }
        
    public ObjectProperty<LocalDate> event_dateProperty() {
        return event_date;
    }
    
    public StringProperty event_locationProperty() {
        return event_location;
    }
    
    public StringProperty event_titleProperty() {
        return event_title;
    }
    
    public IntegerProperty event_timeProperty() {
        return event_time;
    }
    public StringProperty decisionProperty() {
        return this.decision; 
    }
    public StringProperty dietary_notesProperty() {
        return this.dietary_notes;
    }
    
    public ObjectProperty<LocalDate> rsvp_dateProperty() {
        return rsvp_date;
    }  
    
    public IntegerProperty rsvpIDProperty() {
        return rsvpID;
    }
    
}
