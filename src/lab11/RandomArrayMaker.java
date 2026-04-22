package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RandomArrayMaker {
    public static ArrayList<Integer> makeRandomArrayList(int size, int maxNumber) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            arrayList.add((int)(Math.random() * maxNumber));
        }
        return arrayList;
    }

    public static ArrayList<Integer> makeRandomSortedArrayList(int size, int maxNumber) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            arrayList.add((int)(Math.random() * maxNumber));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int[] makeRandomArray(int size, int maxNumber) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * maxNumber);
        }
        return array;
    }

    public static int[][] makeRandom2DArray(int size, int maxNumber) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (int) (Math.random() * maxNumber);
            }
        }
        return array;
    }

    public static int[] makeRandomSortedArray(int size, int maxNumber) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * maxNumber);
        }
        Arrays.sort(array);
        return array;
    }
}
