    import java.util.ArrayList;
    import java.util.Arrays;

public class Hiker {


    public static String[] answer(String orignal) {

        return  find("", orignal).toArray( new String[ ]{});
    }

    private  static  ArrayList<String> find(String profix, String input){

        ArrayList<String> result = new ArrayList<>();
        if( input.length() <=1) {
            result.add( profix + input);
            return  result;
        }

        for (int i = 0; i < input.length(); i++) {
            String newInput;
            if(i < input.length()){
                newInput = input.substring(0,i) + input.substring(i+1);
            }else{
                newInput = input.substring(0,i);
            }

            result.addAll( find( profix +input.substring(i,i+1) ,newInput ));
        }

        return  result;
    }
}










