package com.ohgiraffers.section01;

import java.util.ArrayList;
import java.util.List;

public class AlcoholManager {

    /* 술 목록이 저장 되는 리스트 */
    private List<AlcoholDTO> alcoholList = new ArrayList<>();

    /* 술 추가 */
    public void addList(AlcoholDTO alcohol) {
        alcoholList.add(alcohol);
    }

    /* 술 전체 조회 */
    public List<AlcoholDTO> selectList() {
        return alcoholList;
    }

    /* 제조사명 조회 */
    public List<AlcoholDTO> searchManufacturer(String manufacturer) {

        /* 제조사명을 검색해서 해당 키워드가 포함되는 상품을 리턴하기 위한 리스트 */
        List<AlcoholDTO> searchList = new ArrayList<>();

        for(AlcoholDTO alcohol : alcoholList) {
            if(alcohol.getManufacturer().contains(manufacturer)) {
                searchList.add(alcohol);
            }
        }

        return searchList;
    }

    /* 이름 조회 */

    public List<AlcoholDTO> searchName(String name) {

        /* 이름을 검색해서 해당 키워드가 포함되는 상품을 리턴하기 위한 리스트 */
        List<AlcoholDTO> searchList = new ArrayList<>();

        for(AlcoholDTO alcohol : alcoholList) {
            if(alcohol.getName().contains(name)){
                searchList.add(alcohol);
            }
        }

        return searchList;
    }

    /* 상품 수정 */
    public boolean updateAlcohol(AlcoholDTO updateAlcohol){
        AlcoholDTO old = null;

        for (int i = 0; i < alcoholList.size(); i++) {
            if(alcoholList.get(i).getId() == updateAlcohol.getId()){
                old = alcoholList.set(i, updateAlcohol);
            }
        }  return  old != null;
    }
    public boolean removeAlcohol(int id) {
        AlcoholDTO old = null;

        for (int i = 0; i < alcoholList.size(); i++) {
            if(alcoholList.get(i).getId() == id) {
                old = alcoholList.remove(i);
            }
        } return old != null;
    }
}
