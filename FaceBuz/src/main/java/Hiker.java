
public class Hiker {

    private final static String FIZZ="Fizz";
    private final static String BUZZ="Buzz";

    public static String answer(int input) {

        if( isMultiple(input, 3) && isMultiple(input,5)){
            return FIZZ + BUZZ;
        }

        if( isEndWith(input,3) || isMultiple(input, 3)){
                return FIZZ;
        }
        
        if( isEndWith(input,5) || isMultiple(input,5)){
                return BUZZ;
        }

        return  new  Integer(input).toString();
    }


   private static boolean isEndWith(int input, int postfix){  
      
        String postfixString = new Integer(postfix).toString();
        return new Integer(input).toString().endsWith(postfixString );       
   }

   private static boolean isMultiple(int input, int factor){
         return input%factor==0;
   }


}
