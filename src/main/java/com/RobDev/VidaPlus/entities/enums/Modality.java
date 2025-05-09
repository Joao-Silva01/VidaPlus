package com.RobDev.VidaPlus.entities.enums;

public enum Modality {
    IN_PERSON(1),
    ONLINE(2);

    final int code;

    Modality(int code) {
        this.code = code;
    }
}
