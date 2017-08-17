import org.junit.*;
import static org.junit.Assert.*;

public class HikerTest {

    
      @Test
    public void empty_number_test() {
        
        assertStatisticsInfo( new StatisticsInfo(),
                              Hiker.answer( new int[]{}));
        
         
    }
 
    
    @Test
    public void only_one_number_test() {
        
        assertStatisticsInfo( new StatisticsInfo(1,1,1,1),
                              Hiker.answer( new int[]{1}));
        
        assertStatisticsInfo( new StatisticsInfo(2,2,2,2),
                              Hiker.answer( new int[]{2}));
    }
 

    
    @Test
    public void two_number_test() {
        
        assertStatisticsInfo( new StatisticsInfo(3,1,2,2),
                              Hiker.answer( new int[]{1,3}));
        
        
        assertStatisticsInfo( new StatisticsInfo(5,1,3,3),
                              Hiker.answer( new int[]{1,5,3}));
 
        
       
    }
    
     @Test
    public void three_number_test() {
        
                
        assertStatisticsInfo( new StatisticsInfo(9,-7,3,1),
                              Hiker.answer( new int[]{1,-7,9}));
 
      
    }
    
    
    
    private void assertStatisticsInfo(StatisticsInfo expected, 
                                      StatisticsInfo  result  ){
        assertEquals(expected.max , result.max);
    }
    

}
