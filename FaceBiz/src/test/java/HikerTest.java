import org.junit.*;
import static org.junit.Assert.*;

public class HikerTest {

    @Test
    public void testSimpleNumber() {

        hiker_assert("1", 1);        
        hiker_assert("2", 2);
    }
    
    @Test
    public void test_face_number() {

        hiker_assert("face",3);         
        hiker_assert("face",6); 
        
    }
    
    
    @Test
    public void test_biz_number() {

        hiker_assert("biz",5);          
        hiker_assert("biz",10);  
    }
    
    
    @Test
    public void test_facebiz_number() {

        hiker_assert("facebiz",15);        
        hiker_assert("facebiz",45);
    }
    
    private void hiker_assert(String expect, int input){
    	assertEquals(expect, Hiker.answer(input));
    }
}
