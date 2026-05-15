package com.lemon_legacy.factories;

import com.lemon_legacy.models.Area;

public class AreaFactory {

    public static Area createLemonFields() {
        return new Area(
                "Lemon Fields",
                "A calm field filled with strange lemon trees and weak monsters.",
                1
        );
    }

    public static Area createSourCave() {
        return new Area(
                "Sour Cave",
                "A dark cave filled with acidic pools and stronger creatures.",
                3
        );
    }
}