package com.sachet;
import java.util.*;
public class Location{
    private int locationId;
    private String description;
    private Map<String,Integer> exits = new HashMap<>();
    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits = new HashMap<>();
        exits.put("Q",0);
    }
    public int getLocationId() {
        return locationId;
    }
    public String getDescription() {
        return description;
    }
    public Map<String, Integer> getExits() {
        return exits;
    }
    public void addExits(String direction, int destination){
        exits.put(direction,destination);
    }
}
