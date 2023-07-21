package com.ohgiraffers.section01;

import java.util.Comparator;

public class AscName implements Comparator<AlcoholDTO> {
    @Override
    public int compare(AlcoholDTO o1, AlcoholDTO o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
