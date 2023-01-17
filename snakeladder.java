import java.util.*;

public class snakeladder {
    public static void main(String[] args) {
        snakeboard s=new snakeboard();
        s.startgame();
    }
}
  class snakeboard {
    public static int dice(){
        int p;
        p=(int)(Math.random()*6+1);
        return p;
    }
    final static int Winpoint=100;
    static Map<Integer,Integer>snake=new HashMap<Integer,Integer>();
    static Map<Integer,Integer>ladder=new HashMap<Integer,Integer>();
        {
            snake.put(99,4);
            snake.put(95,11);
            snake.put(80,45);
            snake.put(75,40);
            snake.put(60,35);
            snake.put(50,15);
            snake.put(30,7);
            ladder.put(8,25);
            ladder.put(21,97);
            ladder.put(18,35);
            ladder.put(25,55);
            ladder.put(32,75);
            ladder.put(60,90);
            ladder.put(75,92);
        }
    public static int value(int score,int s){
        score=score+s;
        if(score>Winpoint){
            score=score-s;
            return score;
        }
        if(null!=snake.get(score)){
            System.out.println("Swallowed by snake");
            score=snake.get(score);
        }
        if(null!=ladder.get(score)){
            System.out.println("climb up the ladder");
            score=ladder.get(score);
        }
        return score;
    }
    public static boolean isWin(int player){
        return Winpoint==player;
    }
    public static void startgame(){
        Scanner sc = new Scanner(System.in);
      
		int player1 =0, player2=0;
		int currentPlayer=-1;
		Scanner s = new Scanner(System.in);
		String str;
		int diceValue =0;
		do
		{
			System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
			System.out.println("Press r to roll Dice");
			str = s.next();
			diceValue = dice();
			
			
			if(currentPlayer == -1)
			{
				player1 = value(player1,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player1))
				{
					System.out.println("First player wins");
					break;
				}
			}
			else
			{
				player2 = value(player2,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player2))
				{
					System.out.println("Second player wins");
					break;
				}
			}
			
			currentPlayer= -currentPlayer;
		}while("r".equals(str));
        sc.close();
    }
}