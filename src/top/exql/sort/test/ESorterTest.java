package top.exql.sort.test;

import top.exql.sort.sorter.*;

import java.util.Arrays;

public class ESorterTest {


    public static void main(String[] args) {

        testSorter(new EBubbleSorter());
        testSorter(new ECountSorter());
        testSorter(new EInsertSorter());
        testSorter(new EMergeSorter());
        testSorter(new EQuickSorter());
        testSorter(new ESelectSorter());

    }

    private static void testSorter(ESorter sorter) {
        int rank = 100000;
        int[] randomNums = new int[rank];
        for (int i = 0; i<randomNums.length; i++) {
            randomNums[i] = (int)(Math.random() * 100000);
        }

        String[] split = sorter.getClass().toString().split("\\.");
        String className = split[split.length - 1];


        long t1;
        t1 = System.nanoTime();
        sorter.sort(randomNums);
        System.out.printf("%s：%sms\n", className, (System.nanoTime() - t1)/1000000.0);


    }
}
