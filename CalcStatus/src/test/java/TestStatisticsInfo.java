import org.junit.*;
import static org.junit.Assert.*;

public class TestStatisticsInfo {

    @Test
    public void life_the_universe_and_everything() {

      	assertEquals( new StatisticsInfo(), new StatisticsInfo());
       	assertEquals( new StatisticsInfo(1,2,3,0), new StatisticsInfo(1,2,3,0));        
        assertEquals( new StatisticsInfo(1,2,3,0), new StatisticsInfo(1,2,3,0.0000001f));
     
    }
 

    

}
