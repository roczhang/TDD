import org.junit.*;
import static org.junit.Assert.*;

public class HikerTest {

    @Test
    public void test_empty_parentheses() {
       assertBalanced(true, "");
       assertBalanced(true, "xxxxxx"); 
    }

    @Test
    public void test_onlyOne_parentheses() {
       assertBalanced(true, "()");
       assertBalanced(false, ")(");
    }

    @Test
    public void test_onlyOne_brackets() {
       assertBalanced(true, "[]");
       assertBalanced(false, "][");
    }

    @Test
    public void test_onlyOne_brace() {
       assertBalanced(true, "{}");
       assertBalanced(false, "}{");
    }

    @Test
    public void test_mix_brace() {
       assertBalanced(false, "{{)(}}");
       assertBalanced(false, "({)}");

       assertBalanced(true, "[({})]");
       assertBalanced(true, "{}([])");
       assertBalanced(true, "{()}[[{}]]");       


    }


    private void assertBalanced( boolean expected, String input){    
        assertEquals(expected, Hiker.answer(input));
    }
}
