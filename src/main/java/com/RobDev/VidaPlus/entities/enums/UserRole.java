package com.RobDev.VidaPlus.entities.enums;

public enum UserRole {
    PATIENT(1),
    PROFESSIONAL(2),
    ADMINISTRATOR(3);

    final int code;

    UserRole(int code) {
        this.code = code;
    }
}
