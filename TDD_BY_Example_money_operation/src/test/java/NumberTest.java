import com.yg.Bank;
import com.yg.Expression;
import com.yg.Number;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by I076057 on 7/15/2017.
 */
public class NumberTest {
    @Test
    public void testNumberEqual() throws Exception {


        Number oneDollar = Number.getDollar(1);
        Assert.assertFalse(oneDollar.equals(null));
        Assert.assertFalse(oneDollar.equals(new String()));


        Number fiveDollar = Number.getDollar(5);
        Assert.assertTrue(fiveDollar.equals(Number.getDollar(5)));


        Number sixDollar = Number.getDollar(6);
        Assert.assertFalse(sixDollar.equals(Number.getFrance(6)));

    }

    @Test
    public void testEqualWithDifferentCurrency() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Assert.assertFalse(oneDollar.equals(Number.getFrance(1)));
    }


    @Test
    public void testNumberPlus() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Number twoDollar = Number.getDollar(2);

        Expression expression = oneDollar.plus(twoDollar);

        Bank bank = new Bank();
        Number sum = bank.reduce(expression);

        Assert.assertTrue(sum.equals(Number.getDollar(3)));


    }

    @Test
    public void testOneDollarPlusOneFrance() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Number twoFrance = Number.getFrance(2);

        Expression expression = oneDollar.plus(twoFrance);
        Bank bank = new Bank();
        Number sum = bank.reduce(expression);
        Assert.assertTrue(sum.equals(Number.getDollar(2)));


    }


    @Test
    public void testOneOneFrancePlusTwoDollar() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Number twoFrance = Number.getFrance(2);

        Expression expression = oneDollar.plus(oneDollar);
        Bank bank = new Bank();
        Number sum = expression.reduce(bank);
        Assert.assertTrue(sum.equals(Number.getDollar(2)));
    }


    @Test
    public void testOneOneFrancePlus_plus_TwoDollar() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Number twoFrance = Number.getFrance(2);

        Expression expression = twoFrance.plus(oneDollar);
        Bank bank = new Bank();
        Number sum = bank.reduce(expression);

        Assert.assertTrue(sum.equals(Number.getFrance(4)));
    }
}
