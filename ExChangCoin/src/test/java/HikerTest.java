import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HikerTest {


    @Test
    public void count_of_0_cent() {
        assertCoinCount(0, -1);
        assertCoinCount(0, 0);

    }

    @Test
    public void count_of_1_cent() {
        assertCoinCount(1, 1);
        assertCoinCount(1, 2);
    }


    @Test
    public void count_of_5_cent() {
        assertCoinCount(2, 5);
    }


    @Test
    public void count_of_6_cent() {
        assertCoinCount(2, 6);
    }


    @Test
    public void count_of_7_8_9_cent() {
        assertCoinCount(2, 7);
    }

    @Test
    public void count_of_10_cent() {
        assertCoinCount(4, 10);
    }

    @Test
    public void count_of_15_cent() {
        assertCoinCount(6, 15);
    }

    @Test
    public void count_of_100_cent() {

        System.out.print(Hiker.answer(100));

        assertCoinCount(Hiker.answer(100), Hiker.internalChange2(0, 100));
        assertCoinCount(Hiker.answer(100), Hiker.internalChange3(4, 100));
    }

    private void assertCoinCount(int expected, int input) {
        assertEquals(expected, Hiker.answer(input));
    }

}
