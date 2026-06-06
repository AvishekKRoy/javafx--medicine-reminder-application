package com.medicineapp.model;

public class Medicine {
    private String name;
    private String dosage;
    private String date;
    private String time;
    private String status;

    public Medicine(String name, String dosage, String date, String time, String status) {
        this.name = name;
        this.dosage = dosage;
         this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getDate(){return date;}
    public String getTime() { return time; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) {
        this.status = status;
    }
}