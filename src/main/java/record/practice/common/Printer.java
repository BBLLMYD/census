package record.practice.common;

/**
 * @author mqw
 * @create 2020-05-15-17:10
 */
public class Printer {

    public static void print(int[] is){
        if(is==null || is.length==0){
            System.out.println("[]");
        }
        System.out.print("[");
        for (int i = 0; i < is.length; i++) {
            if(i == is.length-1){
                System.out.print(is[i]);
                continue;
            }
            System.out.print(is[i]+",");
        }
        System.out.print("]");
    }

}
