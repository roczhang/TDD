import org.junit.*;
import static org.junit.Assert.*;

public class HikerTest {

    Hiker game;
    
    @Before
    public void init(){
        game = new Hiker();
    }
    
    
    @Test
    public void checkAvaialbePosition_1()
    {
        game.set(3,3);        
        assertEquals( true, game.availableInPosition(0,0));            
    }
    
        
    @Test
    public void checkAvaialbePosition_2(){
        
        game.set(3,3);   
        game.setQueue(0,0);        
        
        assertEquals( false, game.availableInPosition(0,0));        
        assertEquals( false, game.availableInPosition(0,1));
        assertEquals( false, game.availableInPosition(2,0));
    }
    
    
        @Test
    public void checkAvaialbePosition_3(){
        
        game.set(3,3); 
        game.setQueue(0,0);        
        
        assertEquals( false, game.availableOnCross(0,0));  
        assertEquals( false, game.availableOnCross(1,1));   
     
    }
  
    
         @Test
    public void checkAvaialbePosition_4(){
        
        game.set(3,3); 
        game.setQueue(0,0);        
        
        assertEquals( false, game.availableInPosition(0,2));  
        assertEquals( true, game.availableRow(2));
        assertEquals( true, game.availableCol(1));
        assertEquals( true, game.availableOnCross(2,1));
        assertEquals( true, game.availableInPosition(2,1));       
        assertEquals( true, game.availableInPosition(1,2));
    }
  
    
    
    @Test
    public void checkAvaialbePosition_5(){
        
        game.set(4,4); 
        game.setQueue(2,1);
        assertEquals(false, game.availableOnCross(3,2));
    }
    
    
    @Test
    public void Game_1x1() {
        game.set(1,1);
        assertEquals(1, game.answer());
    }
    
    
     @Test
    public void Game_2x2() {
        game.set(2,2);
        assertEquals(0, game.answer());
    }
    
     
     @Test
    public void Game_3x3() {
        game.set(3,3);
        assertEquals(0, game.answer());
        }
   
      @Test
    public void Game_4x4() {
        game.set(4,4);
        assertEquals(2, game.answer());
    
    }
   
    
      @Test
    public void Game_5x5() {
        game.set(5,5);
        assertEquals(10, game.answer());
        
    }
    
    
      @Test
    public void Game_8x8() {
        game.set(8,8);
        assertEquals(92, game.answer());
        
    }
    
      @Test
    public void Game_9x9() {
        game.set(9,9);
        assertEquals(352, game.answer());
        
    }

     
}
