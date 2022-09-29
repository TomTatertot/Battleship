
package battleship;

public class Levels {
    private static int currentLevel;
    private static Levels levels[] = new Levels[4];
    private int levelNum;
    
    
    Levels(int number)
    {
        levelNum = number;
        
    }
    
    public static void Init(){
        
    }    

    public static void Draw(){

    } 
    
    public static void SwitchLevel()
    {
     if(!Menu.gameStart() && !Menu.tutorial()){
         currentLevel = levels[0].levelNum;
//         System.out.println("Level " + levels);
//         System.out.println("switch level");
     }
     
     else if(Menu.gameStart()){
         currentLevel = levels[1].levelNum;
//         System.out.println("Level " + levels[1].levelNum);
     }
     if(Board.TurnsCheck()){
         currentLevel = levels[2].levelNum;
//         System.out.println("Level " + levels[2].levelNum);
     }
     if(Board.checkWin())
     {
         currentLevel = levels[3].levelNum;
//         System.out.println("Level " + levels[3].levelNum);
     }
            
    }    
    
    public static int Level0(){
        return(levels[0].levelNum);
    }
    public static int Level1(){
        return(levels[1].levelNum);
    }
    public static int Level2(){
        return(levels[2].levelNum);
    }
    
    public static void Reset(){
        
    currentLevel = 0;
        
        if (levels[0] == null)
        {
            levels[0] = new Levels(0);
            levels[1] = new Levels(1);
            levels[2] = new Levels(2);
            levels[3] = new Levels(3);
            
        }
    }
    
    public static int GetCurrentLevel()
    {
        return(currentLevel);
    }    
    
    
}
