import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by I076057 on 7/17/2017.
 */
public class TestString2Number {

    @Test
    public void testEmptyString() throws Exception {

        assertThat("", Solution.isNumber(""), is(false));
    }

    @Test
    public void testOneSimpleCharacter() throws Exception {

        assertConvertTrue("0", true);
        assertConvertTrue("a", false);
    }

    @Test
    public void test_More_Character() throws Exception {

        assertConvertTrue("123", true);
        assertConvertTrue("1a", false);
    }

    @Test
    public void test_postive_negative_symbol() throws Exception {

        assertConvertTrue("+", false);
        assertConvertTrue("-1", true);
        assertConvertTrue("+2", true);
    }


    @Test
    public void begin_with_zero() throws Exception {

        assertConvertTrue("0", true);
        assertConvertTrue("00", true);
    }



    @Test
    public void test_zero_begin_number() throws Exception {

        assertConvertTrue("1.1", true);
        assertConvertTrue("0.1", true);

    }

    @Test
    public void test_edge_case() throws Exception {

        assertConvertTrue(".1", true);
        assertConvertTrue("1.", true);
    }

    @Test
    public void fragment_number() throws Exception {

        assertConvertTrue("0.1", true);
    }

    @Test
    public void test_with_e() throws Exception {

        assertConvertTrue("1e2", true);
        assertConvertTrue( "10000e0001", false);
        assertConvertTrue("1e", false);
        assertConvertTrue( "6ee69",false);
    }

    @Test
    public void test_e_point() throws Exception {

        assertConvertTrue("e.",false);
        assertConvertTrue("2e0",true);

        assertConvertTrue("26.",true);

        assertConvertTrue("26e+1",true);


        assertConvertTrue("26e+",false);
    }

    @Test
    public void test_trim_space_from_number() throws Exception {

        assertConvertTrue("1 ", true);
        assertConvertTrue(" 1",true);
        assertConvertTrue(" 1 ",true);
    }

    private void assertConvertTrue(String input, boolean expect) {

        assertThat(input, Solution.isNumber(input), is(expect));

    }




}
