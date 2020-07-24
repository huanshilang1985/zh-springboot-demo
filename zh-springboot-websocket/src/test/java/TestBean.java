/**
 * @author he.zhang
 * @date 2020/3/12 18:03
 */
public class TestBean {

    static {
        System.out.println("static 1");
    }

    public TestBean(){
        System.out.println("TestBean1");
    }

    public static void main(String[] args) {
        TestBean testBean = new TestBean();

    }

}
