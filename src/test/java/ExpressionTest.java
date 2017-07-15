import com.yg.Bank;
import com.yg.Expression;
import com.yg.Number;
import com.yg.Number;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I076057 on 7/15/2017.
 */
public class ExpressionTest {

    Bank bank;
    private Number oneDollar;
    private Number twoDollar;
    private Number twoFrance;


    @Before
    public void init() {

        bank = new Bank();

        oneDollar = Number.getDollar(1);
        twoDollar = Number.getDollar(2);
        twoFrance = Number.getFrance(2);
    }


    @Test
    public void testPlusRudceWithSameCurrency() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Expression expression = oneDollar.plus(oneDollar);
        Assert.assertTrue(Number.getDollar(2).equals(expression.reduce(new Bank())));
    }

    @Test
    public void testReducePlushWithUS_plus_France() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Number twoFrance = Number.getFrance(2);
        Expression expression = oneDollar.plus(twoFrance);
        Assert.assertTrue(Number.getDollar(2).equals(expression.reduce(new Bank())));
    }


    @Test
    public void testSub() throws Exception {

        Assert.assertTrue(oneDollar.sub(oneDollar).reduce(bank).equals(Number.getDollar(0)));

    }

    @Test()
    public void testMutilpe() throws Exception {

        Expression expression = oneDollar;
        Expression times = new Number(4);

        Number number = oneDollar.multiple(times).reduce(bank);
        Assert.assertTrue("1$*4 == 4$", Number.getDollar(4).equals( number ));


        Number number2 = times.multiple(oneDollar).reduce(bank);
        Assert.assertTrue(" 1$*4 == 4*1$",number.equals(number2));
    }


    @Test
    public void testNumber() throws Exception {

        Number number4 = new Number(4);
        Number number5 = new Number(5);
        Number number6 = new Number(6);

        Assert.assertTrue(number4.multiple(number5).reduce(bank).equals(new Number(20)));

        Number number = Number.getNumber(4)
                .plus(Number.getNumber(16))
                .multiple(Number.getNumber(5))
                .sub(Number.getNumber(100))
                .reduce(bank);
        Assert.assertTrue(number.equals(Number.getDollar(0)));

    }

    @Test
    public void testComplex() throws Exception {

        Number number = Number.getDollar(4).plus(Number.getDollar(1)).multiple(new Number(5)).sub(Number.getDollar(25)).reduce(bank);
        Assert.assertTrue(number.equals(Number.getDollar(0)));
    }
}


