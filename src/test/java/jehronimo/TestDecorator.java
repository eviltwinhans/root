/**
 * Created by chapchikov on 12.12.2016.
 */
package jehronimo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDecorator {

    MainComponent arrow = null;
    Modificator m = null;

    @Before
    public void setup(){
        arrow = new MainComponent();
        m = new NameModificator(new PreModificator(new PostModificator(arrow)));
    }

    @Test
    public void testDoDamageRange(){
        m.doDamage(0);
        Assert.assertTrue("Диапазон урона неверно ограничен снизу!", arrow.currentDamage >= 10);
        Assert.assertTrue("Диапазон урона неверно ограничен сверху!", arrow.currentDamage <= 40);
    }

    @Test
    public void testDoDamageRandom(){
        int randomTestResult;
        m.doDamage(0);
        randomTestResult = 10 * arrow.currentDamage;
        System.out.println(randomTestResult);
        for (int i=0; i < 10; i++){
            m.doDamage(0);
            randomTestResult -= arrow.currentDamage;
            System.out.println(arrow.currentDamage);
        }
        //System.out.println(randomTestResult);
        Assert.assertTrue("Диапазон урона не выбирается случайно!", randomTestResult != 0);
    }
}
