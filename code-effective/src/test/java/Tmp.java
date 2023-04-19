/*
 * @author：jinsheng
 * @date：2022/08/24 21:45
 */
public class Tmp {

    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        swap(a, b);
        System.out.println("num1=" + a);
        System.out.println("num2=" + b);
    }

    private static void swap(Integer a , Integer b){
        Integer temp = a;
        a = b;
        b= temp;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
