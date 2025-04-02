package com.RobDev.VidaPlus.Entities.Enums;

public enum HealthProfession {
    DOCTOR(1),
    NURSER(2),
    DENTIST(3),
    PHYSIOTHERAPIST(4),
    PHARMACEUTICAL(5),
    CARDIOLOGIST(6);

    final int code;

    HealthProfession(int code) {
        this.code = code;
    }
}
