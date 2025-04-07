package com.RobDev.VidaPlus.entities.enums;

public enum Situation {
    HOSPITALIZED(1),
    TRANSFERRED(2),
    MEDICAL_DISCHARGE(3);

    final int code;

    Situation(int code) {
        this.code = code;
    }
}
