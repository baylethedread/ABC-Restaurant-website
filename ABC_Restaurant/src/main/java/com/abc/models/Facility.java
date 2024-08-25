package com.abc.models;

public class Facility {
    private int facilityId;
    private String facilityName;
    private String description;

    public Facility(int facilityId, String facilityName, String description) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.description = description;
    }

    // Getters and Setters
    public int getFacilityId() { return facilityId; }
    public void setFacilityId(int facilityId) { this.facilityId = facilityId; }
    public String getFacilityName() { return facilityName; }
    public void setFacilityName(String facilityName) { this.facilityName = facilityName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
