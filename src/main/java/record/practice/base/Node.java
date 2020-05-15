package record.practice.base;

import lombok.Data;

/**
 *
 * 链表基础结构
 *
 * @author mqw
 * @create 2020-05-15-13:40
 */
@Data
public class Node<T> {

    T data;
    Node next;

}
