package com.effective.chapterVI;

/*
 * @author：jinsheng
 * @date：2022/09/04 17:16
 */
public class OperationTest {

    public static void main(String[] args) {
        double x = 24;
        double y = 6;
        for (OperationTwo op : OperationTwo.values()){
            System.out.printf("%f %s %f =%f%n", x, op, y, op.applay(x, y));
        }


    }
}
