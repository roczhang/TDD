
import java.util.Stack;
public class Hiker {

    public static boolean answer(String input) {
    
        Stack<Character> stack = new Stack<Character>();
        for( int i = 0; i< input.length(); i++){
    
            char e = input.charAt(i);
            
            if( isGeneralBrackets(e) ){
                    
                   if( stack.isEmpty() ){
                        stack.push (e);
                   }    
                   else if( isPair(stack.peek(),e) ){
                        stack.pop();
                   }   
                   else{
                        stack.push(e);
                   }
            }
        }        

        return stack.isEmpty();

    }

   
   public static boolean isPair(char left, char right){

     if( left == '(' && right == ')' )
        return true;
     else if( left == '[' && right == ']')
        return true;
     else if( left == '{' && right == '}')
        return true;    
     else 
        return false;    

   } 
    
   public static boolean isGeneralBrackets(char e){
      return e == '(' || e == ')' ||
             e == '[' || e == ']' ||
             e == '{' || e== '}';
   }

}
