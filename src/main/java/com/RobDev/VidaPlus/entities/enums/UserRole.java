package com.RobDev.VidaPlus.entities.enums;

public enum UserRole {
    PATIENT(1),
    PROFESSIONAL(2),
    ADMIN(3),
    MAIN_ADMIN(4);

    final int code;

    UserRole(int code) {
        this.code = code;
    }
}
