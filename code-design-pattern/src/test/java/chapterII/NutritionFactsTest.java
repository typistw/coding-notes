package chapterII;

import com.effective.chapterII.NutritionFactsBuilder;
import com.effective.chapterII.NutritionFactsConstructor;
import com.effective.chapterII.NutritionFactsJavaBean;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2022/08/09 00:27
 */
public class NutritionFactsTest {

    @Test
   public void testJavaBean(){
        NutritionFactsJavaBean javaBean = new NutritionFactsJavaBean();
        javaBean.setCalories(1);
        // ...
   }

   @Test
    public  void testConstructor(){
       NutritionFactsConstructor constructor = new NutritionFactsConstructor(240,8,100,0,35,27);
   }

   @Test
   public void testBuilder(){
       NutritionFactsBuilder builder = new NutritionFactsBuilder.Builder(240,8).calories(100).sodium(35).calories(27).build();
   }

}
