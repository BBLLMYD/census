package record.practice.base;

/**
 * @auther mqw
 * @date 2020-06-30
 **/
public class Sorts {

    static int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8, 912,231,34};

    public static void main(String[] args) {
//        bubbleSort();
        insertSort();
    }

    public static void bubbleSort(){
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for(int j = 0; j < array.length - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
        print(array);
    }


    public static void insertSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i -1;
            for(; j >= 0 ; j--){
                if(array[j] > temp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
        print(array);
    }


        public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
