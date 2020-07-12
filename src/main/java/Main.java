import list.List;
import list.single.SingleList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(-1);
        Integer[] tab = new Integer[list.size()];
        tab = list.toArray(tab);
        System.out.println(Arrays.toString(tab));
    }
}
