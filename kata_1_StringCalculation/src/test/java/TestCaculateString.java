import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by I076057 on 7/16/2017.
 */
public class TestCaculateString {
    @Test
    public void testCacluteEmptyString() throws Exception {

        Assert.assertTrue("empty String == 0", StringCaculation.caculate("") == 0);
    }

    @Test
    public void testCacluteSingleString() throws Exception {

        Assert.assertTrue("1==1", StringCaculation.caculate("1") == 1);
        Assert.assertTrue("2==1", StringCaculation.caculate("2") == 2);
    }

    @Test
    public void testCacluteTwoNumberInString() throws Exception {


        Assert.assertTrue("1,2 == 3", StringCaculation.caculate("1,2") == 3);
    }

    @Test
    public void testManyNumberInstring() throws Exception {

        Assert.assertTrue("1....10=55", StringCaculation.caculate("1,2,3,4,5,6,7,8,9,10") == 55);

    }


    @Test
    public void testAddNewLine_in_String() throws Exception {

        Assert.assertTrue("1\n2,3", StringCaculation.caculate("1\n2,3") == 6);
    }

    @Test
    public void test_support_newline_with_delimit() throws Exception {

        String input = "//;\n1;2";
        Assert.assertTrue(input, StringCaculation.caculate(input) == 3);
    }

    @Test(expected = Exception.class)
    public void test_negative_number_with_exception() throws Exception {

        StringCaculation.caculate("-1");
    }


    @Test
    public void test_mutiple_negative_number() throws Exception {

        try {

            StringCaculation.caculate("-1,-2,-3");

        } catch (Exception e) {

            Assert.assertTrue(e.getMessage().equals(StringCaculation.NEGATIVE_NUMBER_ARE_NOT_ALLOWED + "-1,-2,-3"));
        }
    }


    @Test
    public void test_different_delimit() throws Exception {

        String inputString = "//[***]\n1***2***3";
        assertThat(inputString +"==6",StringCaculation.caculate(inputString), equalTo(6));
    }


}
