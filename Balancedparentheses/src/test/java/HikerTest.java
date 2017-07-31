import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HikerTest {


    @Parameterized.Parameters(name = "{index}:")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", true},
                {"xxxxxx", true},
                {"()", true},
                {")(", false},
                {"[]", true},
                {"][", false},
                {"{}", true},
                {"}{", false},
                {"{{)(}}", false},
                {"({)}", false},
                {"[({})]", true},
                {"{}([])", true},
                {"{()}[[{}]]", true},
        });
    }


    private String input;
    private boolean expected;

    public HikerTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        System.out.println(input + " : " + new Boolean(expected).toString());
        assertEquals(expected, Hiker.answer(input));
    }


//    @Test
//    public void test_empty_parentheses() {
//       assertBalanced(true, "");
//       assertBalanced(true, "xxxxxx");
//    }
//
//    @Test
//    public void test_onlyOne_parentheses() {
//       assertBalanced(true, "()");
//       assertBalanced(false, ")(");
//    }
//
//    @Test
//    public void test_onlyOne_brackets() {
//       assertBalanced(true, "[]");
//       assertBalanced(false, "][");
//    }
//
//    @Test
//    public void test_onlyOne_brace() {
//       assertBalanced(true, "{}");
//       assertBalanced(false, "}{");
//    }
//
//    @Test
//    public void test_mix_brace() {
//       assertBalanced(false, "{{)(}}");
//       assertBalanced(false, "({)}");
//
//       assertBalanced(true, "[({})]");
//       assertBalanced(true, "{}([])");
//       assertBalanced(true, "{()}[[{}]]");
//
//
//    }
//
//
//    private void assertBalanced( boolean expected, String input){
//        assertEquals(expected, Hiker.answer(input));
//    }
}
