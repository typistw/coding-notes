package chapterVI;

import com.effective.chapterVI.Phase;
import com.effective.chapterVI.Planet;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2022/09/04 16:46
 */
public class WeightTable {

    @Test
    public void testEnum(){
        double earthWeight = 175;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p : Planet.values()){
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }

    @Test
    public void testPhase(){
        System.out.println(Phase.Transition.from(Phase.SOLID, Phase.LIQUID));
    }
}
