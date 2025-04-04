package com.RobDev.VidaPlus.Entities.Enums;

public enum Situation {
    HOSPITALIZED(1),
    TRANSFERRED(2),
    MEDICAL_DISCHARGE(3);

    final int code;

    Situation(int code) {
        this.code = code;
    }
}
