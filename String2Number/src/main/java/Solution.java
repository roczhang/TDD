/**
 * Created by I076057 on 7/17/2017.
 */
public class Solution {

    public static final char E = 'e';

    public static boolean isNumber(String s) {

        s = s.trim();

        if (containOnlyOneCharactorInMiddle(s, E)) {

            String[] list = s.split("e");
            String indexPart = removeSymbol(list[1]);

            if (indexPart.isEmpty()) {
                return false;
            } else {
                return isDoubleWithoutIndex(list[0]) && isNatureNumber(indexPart);
            }
        } else {
            return isDoubleWithoutIndex(s);
        }
    }

    private static boolean isDoubleWithoutIndex(String s) {

        if (s.length() == 0) return false;

        s = removeSymbol(s);

        if (conatinOnlyCharacter(s, '.')) {
            String[] list = s.split("\\.");

            boolean firtPartValidtor = false;
            if (list[0].length() == 0) {
                firtPartValidtor = true;
            } else {
                firtPartValidtor = isNatureNumber(list[0]);
            }

            boolean secondPartValiditor = false;
            if (list.length == 1)
                secondPartValiditor = true;
            if (list.length == 2) {
                secondPartValiditor = isNatureNumber(list[1]);
            }

            return firtPartValidtor && secondPartValiditor;

        } else {

            return isNatureNumber(s);
        }
    }

    private static boolean isNatureNumber(String s) {

        if (s.isEmpty()) return false;

        boolean others = true;
        for (int i = 0; i < s.length(); i++) {
            others = others && is_single_number_within_zero(s.charAt(i));
        }
        return others;
    }

    private static boolean is_single_number_within_zero(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean is_single_number_without_zero(char c) {
        return '0' < c && c <= '9';
    }

    private static boolean isPostiveNegativeSymbol(char firstCharcter) {
        return firstCharcter == '+' || firstCharcter == '-';
    }

    private static String removeSymbol(String s) {
        char firstCharcter = s.charAt(0);
        if (isPostiveNegativeSymbol(firstCharcter)) {
            s = s.substring(1);
        }
        return s;
    }

    private static boolean containOnlyOneCharactorInMiddle(String s, char e) {

        if (s.isEmpty()) return false;
        if (s.startsWith(String.valueOf(e)) || s.endsWith(String.valueOf(e))) return false;

        return conatinOnlyCharacter(s, e);
    }

    private static boolean conatinOnlyCharacter(String s, char e) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == e) {
                count++;
            }
        }

        return count == 1;
    }


}
