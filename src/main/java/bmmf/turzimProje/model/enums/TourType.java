package bmmf.turzimProje.model.enums;

import lombok.Getter;
import lombok.Setter;

public enum  TourType {
    GEZİ("Gezi Turu"),
    TEKNE("Tekne Turu"),
    PARASUT("Parasut Turu"),
    JEEPSAFARI("JEEP SAFARI");


    TourType(String name) {
        this.name = name;
    }

    @Getter @Setter
    String name;
}
