package eidi2.sose25.weber.felix.sheet01;

import java.util.ArrayList;

public class Addition {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        arrayList.forEach(integer -> {
            System.out.println(integer);
        });

        int[] array = new int[10];
    }

}
