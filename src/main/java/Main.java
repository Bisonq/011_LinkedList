import list.List;
import list.single.SingleList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(-1);
        System.out.println(list.remove(-1));
        System.out.println(list);
        System.out.println(list.getMin() + " " + list.getMax());
    }
}
