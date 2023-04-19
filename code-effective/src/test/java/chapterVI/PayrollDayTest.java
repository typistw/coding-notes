package chapterVI;

import com.effective.chapterVI.PayrollDay;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2022/09/17 16:02
 */
public class PayrollDayTest {

    @Test
    public void testPay(){
        int  hours = 8;
        double payRate = 0.8;
        System.out.println(PayrollDay.MONDAY.pay(hours, payRate));
        System.out.println(PayrollDay.SATURDAY.pay(hours, payRate));
    }
}
