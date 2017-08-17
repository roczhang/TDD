public class StatisticsInfo{

    public    int max;
    public    int min;
    public    int count;
    public    float average;

    public StatisticsInfo(){this(0,0,0,0.0f);}
    public StatisticsInfo(int max, int min, int count, float average){

        this.max = max;
        this.min = min;
        this.count = count;
        this.average = average;
    }

    public boolean equals( Object obj){
    
           StatisticsInfo other = (StatisticsInfo ) obj;
           if( obj!= null){
            
                return other.max == this.max &&
                       other.min == this.min &&
                       other.count == this.count &&
                       Math.abs(other.average - this.average) < 0.000001;     
    
           }
           
           return false;
           
    }

}