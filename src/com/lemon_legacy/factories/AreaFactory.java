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
}