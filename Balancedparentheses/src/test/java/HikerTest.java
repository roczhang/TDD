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
                {"test_empty_parentheses","", true},
                {"test_empty_parentheses","xxxxxx", true},
                {"test_onlyOne_parentheses", "()", true},
                {"test_onlyOne_parentheses",")(", false},
                {"test_onlyOne_brackets", "[]", true},
                {"test_onlyOne_brackets", "][", false},
                {"test_onlyOne_ big _brackets", "{}", true},
                {"test_onlyOne_ big _brackets","}{", false},
                {"test_mix_brace","{{)(}}", false},
                {"test_mix_brace","({)}", false},
                {"test_mix_brace","[({})]", true},
                {"test_mix_brace","{}([])", true},
                {"test_mix_brace","{()}[[{}]]", true},
        });
    }


    private String input;
    private boolean expected;
    private final String description;

    public HikerTest(String discription, String input, boolean expected) {
        this.description = discription;
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        System.out.println(this.description);
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
