package record.practice;

import lombok.Getter;
import record.practice.common.ArrayBuilder;

import java.util.PriorityQueue;

/**
 * @author mqw
 * @create 2020-08-06-17:26
 */
public class QueueKthLargest {

    @Getter
    PriorityQueue<Integer> q;
    int k;

    public QueueKthLargest(int[] array, int k) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int i : array) {
            add(i);
        }
    }

    public void add(int n){
        if(q.size() < k){
            q.offer(n);
        }else if(q.peek() < n){
            q.poll();
            q.offer(n);
        }
    }

    public static void main(String[] args) {
        int[] build = ArrayBuilder.build(20);
        QueueKthLargest kthLargest = new QueueKthLargest(build, 3);
        PriorityQueue<Integer> q = kthLargest.getQ();
        System.out.println(kthLargest.getQ());

    }

}