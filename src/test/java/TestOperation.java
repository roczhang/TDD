import com.yg.Bank;
import com.yg.Number;
import com.yg.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I076057 on 7/15/2017.
 */
public class TestOperation
{


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
    public void TestEnum() throws Exception {

        Operation AddOperation = Operation.ADD;

        Assert.assertTrue("make sure get the current item in the enum ", AddOperation.ordinal() == Operation.ADD.ordinal());

    }



    @Test
    public void add() throws Exception {

         Assert.assertTrue("1$ + 2$ == 3$", Operation.ADD.reduce(oneDollar, twoDollar, bank).equals( Number.getDollar(3)));
    }

    @Test
    public void sub() throws Exception {

        Assert.assertTrue( "2$ - 1$ == 1$", Operation.SUB.reduce(twoDollar, oneDollar, bank).equals( Number.getDollar(1)));
    }

    @Test
    public void mutiple() throws Exception {

        Assert.assertTrue( "4*2$ == 8$", Operation.MULTIPLE.reduce(twoDollar, Number.getNumber(4),bank).equals( Number.getDollar(8)) );
        Assert.assertTrue( "4$*2 == 8$", Operation.MULTIPLE.reduce(twoDollar, Number.getNumber(4),bank).equals( Number.getDollar(8)) );
    }

    @Test( expected = Exception.class)
    public void UnderDefineOperation() throws Exception {

        Assert.assertTrue("underDefined Operation Exception", Operation.UnderDefined.reduce(oneDollar, twoDollar, bank).equals(oneDollar));
    }
}
