import org.junit.*;
import static org.junit.Assert.*;

public class gitHikerTest {

    @Test
    public void test_simple_number() {
    
        hikerAssert("2",2);
        hikerAssert("1",1);
       
    }

    @Test
    public void test_Fizz_with_3_end() {
    
        hikerAssert("Fizz",43);
        hikerAssert("Fizz",3);
    }


    @Test
    public void test_Fizz_with_3_times() {
    
        hikerAssert("Fizz",6);
        hikerAssert("Fizz",9);       
    }

    @Test
    public void test_Fizz_with_5_end() {
    
        hikerAssert("Buzz",55);
        hikerAssert("Buzz",65);
    }

    @Test
    public void test_Fizz_with_5_times() {
    
        hikerAssert("Buzz",5);
        hikerAssert("Buzz",25);       
    }
   

    @Test
    public void test_Fizz_Buzz() {
    
      hikerAssert("FizzBuzz",15);
      hikerAssert("FizzBuzz",45);
    }

    private void hikerAssert(String expected, int input){

        assertEquals(expected, Hiker.answer(input));    
    }


}
