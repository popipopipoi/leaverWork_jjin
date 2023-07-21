package com.ohgiraffers.section01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AlcoholMenu {

    private AlcoholManager alcoholManager = new AlcoholManager();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {

        mainMenu:
        while (true){
            System.out.println("========= 메뉴 ========");
            System.out.println("1. 제품 추가 ");
            System.out.println("2. 제품 전체 조회 ");
            System.out.println("3. 정렬하여 조회 ");
            System.out.println("4. 제조사명으로 검색 ");
            System.out.println("5. 제품명으로 검색 ");
            System.out.println("6. 제품 정보 수정 ");
            System.out.println("7. 제품 삭제 ");
            System.out.println("0. 프로그램 종료 ");

            System.out.println("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    selsctList();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    searchManufacturer();
                    break;
                case 5:
                    searchName();
                    break;
                case 6:
                    updateAlcohol();
                    break;
                case 7:
                    removeAlcohol();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break mainMenu;
                default:
                    System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void addList() {
        System.out.println("==== 제품 추가 ====");
        System.out.println("제조사 입력 : ");
        String manufacturer = sc.nextLine();
        System.out.println("제품명 입력 : ");
        String name = sc.nextLine();

        alcoholManager.addList(new AlcoholDTO(manufacturer, name));
    }

    public void selsctList() {
        System.out.println("==== 제품 전체 조회 ====");
        List<AlcoholDTO> alcoholList = alcoholManager.selectList();

        if(!alcoholList.isEmpty()) {
            for (AlcoholDTO alcohol : alcoholList) {
                System.out.println(alcohol);
            }
        } else {
            System.out.println("제품이 존재하지 않습니다.");
        }
    }

    public void sortMenu() {
        System.out.println("==== 정렬 메뉴 ====");
        System.out.println("1. 제조사명 오름차순 정렬");
        System.out.println("2. 제품명 오름차순 정렬");
        System.out.println("3. 제조사명 내림차순 정렬");
        System.out.println("4. 제품명 내림차순 정렬");
        System.out.print(" 메뉴 선택 : ");
        int menu = sc.nextInt();

                ascDesc(menu);
    }

    public void ascDesc(int menu) {
        System.out.println("===== 정렬하여 조회 ====");
        List<AlcoholDTO> alcoholList = alcoholManager.selectList();

        if(alcoholList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }

        List<AlcoholDTO> sortList = new ArrayList<>();
        sortList.addAll(alcoholList);

        if(menu == 1) {
            sortList.sort(new Comparator<AlcoholDTO>() {
                @Override
                public int compare(AlcoholDTO o1, AlcoholDTO o2) {
                    return o1.getManufacturer().compareTo(o2.getManufacturer());
                }
            });
        } else if (menu == 2 ) {
            sortList.sort(new AscName());
        } else if (menu == 3) {
            sortList.sort(new DescManufacturer());
        } else  {
            sortList.sort(new DescName());
        }

        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }
    }

    public void searchManufacturer() {
        System.out.println("==== 제조사명으로 검색 ====");
        System.out.print("가수명 입력 : ");
        List<AlcoholDTO> searchList = alcoholManager.searchManufacturer(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void searchName() {
        System.out.println("==== 제품명으로 검색 ====");
        System.out.print("제품명 입력 : ");
        List<AlcoholDTO> searchList = alcoholManager.searchName(sc.nextLine());

        if(!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void updateAlcohol() {
        System.out.println("====제품 정보 수정 ====");
        System.out.println("수정할 제품의 id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 제조사명 : ");
        String updatemanufacturer = sc.nextLine();
        System.out.println("수정할 제품명 : ");
        String updatename = sc.nextLine();

        AlcoholDTO updateAlcohol = new AlcoholDTO(id, updatemanufacturer, updatename);

        if(alcoholManager.updateAlcohol(updateAlcohol)) {
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("수정할 제품을 찾지 못했습니다.");
        }
    }

    public void removeAlcohol() {
        System.out.println("==== 제품 삭제 ====");
        System.out.print("삭제할 제품의 id : ");
        if(alcoholManager.removeAlcohol(sc.nextInt())) {
            System.out.println("성공적으로 삭제 되었습니다. ");
        } else {
            System.out.println("삭제할 곡을 찾지 못했습니다.");
        }
        sc.nextLine();
    }
}
