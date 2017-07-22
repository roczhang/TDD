import org.junit.*;
import static org.junit.Assert.*;


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
        assertCoinCount(1, 3);
        assertCoinCount(1, 4);
   
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
        assertCoinCount(2, 8);
        assertCoinCount(2, 9);
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
    
         System.out.print( Hiker.answer(100));

         System.out.print( Hiker.internalChange3(4,100));

         System.out.print( Hiker.internalChange2(0,100));
    }

    private void assertCoinCount(int expected, int input){
            assertEquals(expected, Hiker.answer(input));
    }

}
