package com.RobDev.VidaPlus.Entities.Enums;

public enum UserRole {
    PATIENT(1),
    PROFESSIONAL(2),
    ADMINISTRATOR(3);

    final int code;

    UserRole(int code) {
        this.code = code;
    }
}
