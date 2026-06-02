package com.medicineapp.model;

public class Medicine {
    private String name;
    private String dosage;
    private String time;
    private String status;

    public Medicine(String name, String dosage, String time, String status) {
        this.name = name;
        this.dosage = dosage;
        this.time = time;
        this.status = status;
    }

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) {
        this.status = status;
    }
}