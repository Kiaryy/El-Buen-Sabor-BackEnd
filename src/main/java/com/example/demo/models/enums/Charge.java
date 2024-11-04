package com.example.demo.models.enums;

public enum Charge {
    CAJERO("Lun a Vie 08:00am a 00:30am, Sab y Dom 11:00am a 15:30pm"),
    MANAGER("Lun a Vie 08:00am a 00:30am, Sab y Dom 11:00am a 15:30pm"),
    DELIVERY("Lun a Vie 08:00am a 00:30am, Sab y Dom 11:00am a 15:30pm"), 
    CHEF("Lun a Vie 07:00am a 01:00am, Sab y Dom 1:00am a 14:00pm");

    private final String shift;

    
    Charge(String shift) {
        this.shift = shift;
    }

    
    public String getShift() {
        return this.shift;
    }
}
