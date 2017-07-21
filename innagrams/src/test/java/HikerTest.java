import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by I076057 on 7/22/2017.
 */


public class HikerTest {

    @Test
    public void test_null_anagrams() {

        annagramsEquals(new String[]{""}, "");
    }

    @Test
    public void test_one_character_anagrams() {

        annagramsEquals(new String[]{"1"}, "1");
    }


    @Test
    public void test_2_character_anagrams() {

        annagramsEquals(new String[]{"12", "21"}, "12");
    }


    @Test
    public void test_3_character_anagrams() {

        String expected = "123 132 213 231 312 321";

        annagramsEquals(expected.split(" "), "123");
    }


    @Test
    public void test_4_character_anagrams() {

        String expected = "biro bior brio broi boir bori" +
                " ibro ibor irbo irob iobr iorb" +
                " rbio rboi ribo riob roib robi" +
                " obir obri oibr oirb orbi orib";

        annagramsEquals(expected.split(" "), "bori");
    }


    private void annagramsEquals(String[] expected, String input) {

        String[] result = Hiker.answer(input);

        Arrays.sort(expected);
        Arrays.sort(result);

        assertThat(Arrays.equals(expected, result), is(true));

    }
}


