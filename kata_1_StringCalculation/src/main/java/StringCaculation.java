import java.util.Arrays;

/**
 * Created by I076057 on 7/16/2017.
 */
public class StringCaculation {

    public static final String NEGATIVE_NUMBER_ARE_NOT_ALLOWED = "Negative Number are not allowed:";
    private static final String defaultDelimit = ",";
    private static final String commentSymbol = "//";


    public static int caculate(String input) throws Exception {


        String delimit = defaultDelimit;

        if (input.length() > 4) {
            boolean hasDelimit = input.substring(0, 2).equals(commentSymbol);
            if (hasDelimit) {
                delimit = input.substring(0, input.indexOf("\n")).replace(commentSymbol, "").replace("\n", "");
                input = input.substring(input.indexOf("\n") + 1);
            }
        }

        input = input.replace("\n", ",");
        String[] numberList = input.split(delimit);
        boolean hasNegative = Arrays.stream(numberList).map(x -> String2Number(x)).anyMatch(x -> x < 0);
        if (hasNegative) {
            throw new Exception(NEGATIVE_NUMBER_ARE_NOT_ALLOWED + Arrays.stream(numberList)
                    .map(x -> String2Number(x))
                    .filter(x -> x < 0)
                    .map(x -> x.toString())
                    .reduce("", (a, b) -> a.isEmpty() ? b : a.concat(",").concat(b)));
        }

        return Arrays.stream(numberList)
                .map(x -> String2Number(x))
                .map(x -> x % 1000)
                .reduce(0, (x, y) -> x + y);
        }

    private static int String2Number(String a) {
        return a.isEmpty() ? 0 : Integer.valueOf(a);
    }
}
