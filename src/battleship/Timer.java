
package battleship;

import java.awt.*;

public class Timer {
    
    private static int timeCount;
    
   public static void Reset(){
        timeCount = 0;
    } 
    
    public static void Animate(){
        
        
        
        
        timeCount++;
    }
    
    public static int retTC(){
        return(timeCount);
    }
    
    public static void TimeSwitch(){
        
    }
    
}
