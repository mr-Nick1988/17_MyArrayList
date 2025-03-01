package telran.list.test;

import org.junit.jupiter.api.Test;
import telran.list.intefaces.IList;
import telran.list.model.MyArrayList;


public class ListTest {
    @Test
    void test() {
        IList<Integer> list = new MyArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(7);
        list.add(4, null);
        System.out.println(list.size());
        System.out.println("=== get ===");
        System.out.println(list.get(2));
        System.out.println(list.get(4));
        try {
            System.out.println(list.get(6));
        } catch (Exception e) {
            System.out.println("6 out of bound");
        }
        System.out.println("=== indexOf ===");
        System.out.println(list.indexOf(7));
        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(null));
        System.out.println("=== contains ===");
        System.out.println(list.contains(1));
        System.out.println(list.contains(7));
        System.out.println(list.contains(null));
        System.out.println("=== lastIndexOf ===");
        System.out.println(list.lastIndexOf(7));

        System.out.println("=== remove ===");
        System.out.println(list.remove(2));
        System.out.println(list.remove(0));
        System.out.println(list.size());
        System.out.println("=== iterator ===");
        for (Integer element : list) {
            System.out.println(element);

        }
        System.out.println("=== Clear ===");
        list.clear();
        System.out.println(list.size());

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("=== set ===");
        System.out.println(list.set(1, 4));
        System.out.println(list.get(1));
        System.out.println(list.size());


    }
}

