package record.practice.common;

import java.util.Random;

/**
 * @author mqw
 * @create 2020-08-06-17:54
 */
public class ArrayBuilder {

    public static int[] build(int size){
        Random random = new Random();
        int[] ints = new int[size];
        for (int i1 = 0; i1 < size; i1++) {
            int i = random.nextInt(10000);
            ints[i1] = i;
        }
        System.out.println("原数组：");
        Printer.print(ints);
        return ints;
    }

}