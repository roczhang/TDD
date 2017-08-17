
public class Hiker {

    private int length = 0;
    private int width = 0;
    int [][] game;
    int count = 0;
    
    public void set(int length, int width){
        this.length= length;
        this.width = width;
        game = this.newGame();
    }
    
    public void setQueue(int row, int col){
    
         game[row][col] = 1;
    }
    public  int answer() {
       find(0);
       return this.count;
    }
    
    void find(int row){
    
        if( row >= length) return;
        
        if( row == length -1)
        {
            for( int j = 0; j < width; j++)
            {
                if( this.availableInPosition(row, j))
                {
                    game[row][j] = 1;
                    
                    this.count ++;
                    //this.printGame();
                    
                    game[row][j] = 0;
                    
                }
            }
        }

        else{
        
        
            for( int j = 0; j< width; j++)
            {
                if( this.availableInPosition(row, j)){
                    game[row][j] = 1;
                    find(row + 1);
                    game[row][j] = 0;
                }
            }
        }
    }
    
    public  boolean availableInPosition(int row, int col)
    {
       return availableRow(row) && availableCol(col) &&
           availableOnCross(row, col);
    }
    
    public boolean availableRow(int row){
    
        int result = 0;
        for(int j= 0 ; j< width; j++) {
            result += game[row][j];
        }
        return result == 0;
    }
    
    public boolean availableCol(int col){
        int result = 0;
        for( int i = 0; i < length; i++){
            result += game[i][col];
        }
        return result == 0;
    }
    
    public boolean availableOnCross(int row, int col){
        
        int result1 = 0;
        int i = row;
        int j = col;
        while( inBox(i, j))
        {
            result1 +=game[i][j];
            i--;
            j--;
            
        }
        
        int result2 = 0;
        i = row;
        j = col;
        while( inBox(i, j))
        {
            result2 += game[i][j];
            i--;
            j++;
        }
        return result2 == 0 && result1== 0;
    }
    
    public boolean inBox( int row, int col){
    
        return 0<=row && row <length && 
               0<=col && col < width;
    }
    
    public int[][] newGame(){
    
           int[][] game= new int [length][width];
          
           for( int i = 0 ; i< length; i++)
               for( int j = 0; j< width; j++)
                    game[i][j] = 0;        
           
           return game;        
    }
        
    public void printGame(){
        
           System.out.format("\n%d x %d \n", length, width);
           for( int i = 0 ; i< length; i++){
               for( int j = 0; j< width; j++){
                System.out.format("%d ",game[i][j]);        
               }
               System.out.println("");          
           }
    }
}
