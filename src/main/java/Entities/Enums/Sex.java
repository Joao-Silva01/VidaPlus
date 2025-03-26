package Entities.Enums;

public enum Sex {
    FEMININE(1),
    MASCULINE(2),
    OTHERS(3);

    final int code;

    Sex(int code){
        this.code = code;
    }
}
