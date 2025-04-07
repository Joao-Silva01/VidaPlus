package com.RobDev.VidaPlus.entities.enums;

public enum Sex {
    FEMALE(1),
    MALE(2),
    OTHERS(3);

    final int code;

    Sex(int code){
        this.code = code;
    }
}
