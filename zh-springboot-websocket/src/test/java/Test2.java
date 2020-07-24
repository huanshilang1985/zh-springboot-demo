import java.util.ArrayList;
import java.util.List;

/**
 * @author he.zhang
 * @date 2020/4/22 9:52
 */
public class Test2 {

    public static void main(String[] args) {
        ArrayList<String > a = new ArrayList<>(10);
        System.out.println(a.size());
        List<String> list = new ArrayList<>(10);
        list.add("Aaaa");
        System.out.println(list.size());
    }
}
