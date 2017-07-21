
public class Hiker {

    public static String answer( int input) {
        
        if( input%3 == 0 && input%5==0) return "facebiz";
        
        if( input %3 ==0) return "face";
        
        if( input %5 == 0) return "biz";
        
        return new Integer(input).toString();
    }
}
