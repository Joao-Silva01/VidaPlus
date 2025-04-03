package com.RobDev.VidaPlus.Entities.Enums;

public enum Exam {
    LABORATORY(1),
    IMAGE(2),
    CARDIOLOGICAL(3),
    ENDOSCOPIC(4),
    GENETIC(5);

    final int code;

    Exam(int code) {
        this.code = code;
    }
}
