/**
 * Created by I076057 on 7/17/2017.
 */
public class Solution {
    public static boolean isNumber(String s) {

        s = s.trim();

        if (s.isEmpty())
            return false;

        char firstCharcter = s.charAt(0);
        if (isPostiveNegativeSymbol(firstCharcter)) {
            s = s.substring(1);
        }

        boolean eValidtor = false;
        if (containOnlyOneCharactorInMiddle(s, 'e')) {

            String[] list = s.split("e");


            if (isPostiveNegativeSymbol(list[1].charAt(0))) {
                list[1]  = list[1] .substring(1);
            }

            return isDoubleWithoutIndex(list[0]) &&  list[1].length()>0 && isFragement(list[1]);

        } else {

            return isDoubleWithoutIndex(s);
        }


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

    private static boolean isDoubleWithoutIndex(String s) {

        if (s.length() == 0) return false;

        if (s.length() == 1)
            return is_single_number_within_zero(s.charAt(0));


        if (conatinOnlyCharacter(s, '.')) {
            String[] list = s.split("\\.");


            boolean firtPartValidtor = false;
            if (list[0].length() == 0) {

                firtPartValidtor = true;
            }else if (list[0].length() == 1){
                firtPartValidtor = is_single_number_within_zero(list[0].charAt(0));
            }
            else {
                firtPartValidtor = isFragement(list[0]);
            }


            boolean secondPartValiditor = false;
            if( list.length ==1)
                secondPartValiditor =true;
            if( list.length ==2){
                secondPartValiditor = isFragement(list[1]);
            }

            return firtPartValidtor && secondPartValiditor;


        } else {

            return isFragement(s);
        }
    }

    private static boolean isFragement(String s) {

        boolean others = true;
        for (int i = 0; i < s.length(); i++) {
            others = others && is_single_number_within_zero(s.charAt(i));
        }
        return others;
    }

    private static boolean isNatureNumber(String s) {
        boolean firstNumber = is_single_number_without_zero(s.charAt(0));
        boolean others = true;
        for (int i = 1; i < s.length(); i++) {
            others = others && is_single_number_within_zero(s.charAt(i));
        }
        return firstNumber && others;
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


}
