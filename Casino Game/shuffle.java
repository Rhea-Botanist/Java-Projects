
import java.util.*;

public class shuffle {
    
    public void perfectShuffle(int[] values) {
    Random rand=new Random();
    int variable;
    
            
    for(int a=values.length-1; a>0; a--){
    int num=rand.nextInt(values.length);
    
    variable=values[a];
    values[a]=values[num];
    values[num]=variable;
    }
    }
}

