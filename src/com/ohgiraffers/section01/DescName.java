package com.ohgiraffers.section01;

import java.util.Comparator;

public class DescName implements Comparator<AlcoholDTO> {
    @Override
    public int compare(AlcoholDTO o1, AlcoholDTO o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
