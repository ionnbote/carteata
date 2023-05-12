package Labworks.poo.lab5;

import java.util.Arrays;

public class MainSablon {
    public static void main(String[] args) {
        Integer[] data = {0, 5, 1, 4, 3};
        Double[] doubleData = {0.1, 5.3, 1.1, 4.2, 3.3};
        String[] strData = {"aa", "ab", "bb", "ss", "kk"};

        Sablon<String> sablon = new Sablon<>();
        int size = doubleData.length;
        sablon.sort(strData, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(strData));
    }
}
