package record.practice.base;

import lombok.Data;
import lombok.ToString;

/**
 * @author mengqingwen <mengqingwen@kuaishou.com>
 * Created on 2020-12-26
 */
@Data
@ToString
public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode(int x) { val = x; }


}
