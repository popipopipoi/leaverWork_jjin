package com.ohgiraffers.section01;

import java.util.Comparator;

public class DescManufacturer implements Comparator<AlcoholDTO> {
    @Override
    public int compare(AlcoholDTO o1, AlcoholDTO o2) {
        return o2.getManufacturer().compareTo(o1.getManufacturer());
    }
}
