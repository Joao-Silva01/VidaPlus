package com.RobDev.VidaPlus.entities.enums;

public enum Status {
    SCHEDULED(1),
    COMPLETED(2),
    CANCELLED(3);

    final int code;

    Status(int code) {
        this.code = code;
    }
}

