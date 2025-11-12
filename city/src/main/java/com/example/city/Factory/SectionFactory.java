package com.example.city.Factory;

import com.example.city.Model.Floor;
import com.example.city.Model.Section;

public class SectionFactory {

    public static Section createSection(Floor floor, String label) {
        Section section = new Section();
        section.setFloor(floor);
        section.setLabel(label);
        return section;
    }
}

