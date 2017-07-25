
public class Hiker {

    public static StatisticsInfo answer(int[] array) {
        
        if( array.length == 0)
            return new StatisticsInfo();
        
        StatisticsInfo result =  new StatisticsInfo();        
        result.count = array.length;        
        result.max = array[0];
        result.min = array[0];
        result.average = array[0];        
        
        int sum = array[0];
        for(int i = 1; i< array.length; i++){
            
            if( result.max < array[i]){
                result.max = array[i];
            }
            
            if( result.min > array[i]){
                result.min = array[i];
            }
            
            sum += array[i];            
        }        
        result.average = sum/result.count;
        
        return result;
        
        
        
    }
}
