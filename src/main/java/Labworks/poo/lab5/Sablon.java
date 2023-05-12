package Labworks.poo.lab5;

public class Sablon<T extends Comparable<T>> {
    void sort(T[] array, int size) {
        for (int step = 1; step < size; step++) {
            T key = array[step];
            int j = step - 1;

            while (j >= 0 && key.compareTo(array[j]) > 0) {
                array[j + 1] = array[j];
                --j;
            }

            array[j + 1] = key;
        }
    }
}
