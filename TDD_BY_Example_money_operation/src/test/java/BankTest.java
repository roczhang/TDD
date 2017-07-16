import com.yg.Bank;
import com.yg.Number;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by I076057 on 7/15/2017.
 */
public class BankTest {

    @Test
    public void testConvertSameCurrencyNumber() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Bank bank = new Bank();
        Assert.assertTrue(oneDollar.equals(bank.convert(oneDollar, oneDollar.getCurrency())));
    }

    @Test
    public void testConvertBetweenUStoFrance() throws Exception {

        Number oneDollar = Number.getDollar(1);
        Bank bank = new Bank();
        Assert.assertTrue(Number.getFrance(2).equals(bank.convert(oneDollar, "FR")));

        Number twoFrance = Number.getFrance(2);
        Assert.assertTrue(oneDollar.equals(bank.convert(twoFrance, "US")));
    }

}
