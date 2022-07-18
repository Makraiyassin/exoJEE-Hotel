package com.bxl.javatym.hotel.models;

public enum TypeEnum {
    BASIC,
    MEDIOR,
    SUITE;

    @Override
    public String toString() {
        return "TypeEnum{}".toLowerCase();
    }
}
