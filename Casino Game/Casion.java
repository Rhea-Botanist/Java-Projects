
import java.util.*;
import java.util.ArrayList;


public class Casion {
    public static boolean response=true;
    
    public static String reply;
    public static double Money;
    public static String bet;
    public static int betting=0;
    public static boolean game=true;
    public static boolean chips=true;
   
    public static Scanner main= new Scanner(System.in);
    public static ArrayList<cards> Cards=new ArrayList<>();
    public static int[][] roulette={
    {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36}, 
    {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
    {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34}};
    
    public static final int WhiteChip=1;
    public static final int RedChip=5;
    public static final int BlueChip=10;
    public static final int GreenChip=25;
    public static final int BlackChip=100;
    public static final int PurpleChip=500;
   
    
   
    public Casion(){
    Cards=new ArrayList<>();
    shuffle shuffler=new shuffle();
    ArrayList<cards> shuffledCards = new ArrayList<>();

    String[] name={"♠", "♥", "♦", "♣"};
    String[] value= {"King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "Ace"};
    int[] points= {10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
    
    for(int a=0; a<name.length; a++){
    for(int b=0; b<points.length; b++){
    Cards.add(new cards(name[a], value[b], points[b]));
        }
      }
    int[] cardnumbers = new int[Cards.size()];
        for (int c = 0; c < cardnumbers.length; c++) {
    cardnumbers[c] = c;
        }
    shuffler.perfectShuffle(cardnumbers);
       for (int i = 0; i < cardnumbers.length; i++) {
    shuffledCards.add(Cards.get(cardnumbers[i]));
    }   
        Cards = shuffledCards;
        
    }//casion cards
    
    public static void main(String[] args){     
        System.out.println();
        System.out.println("Welcome to the casino. How much money did you bring? (No Dollarsign)");
        Money=main.nextDouble();
        System.out.println();
        
        while(response){
        System.out.println("You have $" + Money);
        System.out.println("Please enter a choice"); 
        System.out.println("Blackjack, or chips"); 
        System.out.println("Type 'done' to quit");
        System.out.println();
        reply=main.next();
        reply=reply.toLowerCase();
        System.out.println();
        
        if(reply.equals("done"))
            response=false;
        if(reply.equals("roulette"))
            Casion.roulette(Money);
        if(reply.equals("blackjack"))
            Casion.blackjack(Money);
        if(reply.equals("chips"))
            Casion.chips(Money);
        if(reply.equals("^^downdown<><>ba"))
            Casion.information();   
        else 
            System.out.println("Please come again");
        }
    }
    
    
    public static void roulette(double Money){
    System.out.println("Welcome to roulette ");     
    System.out.println("|How it works is that you are given a table of |");
    System.out.println("|numbers and colors of your choosing and you   |");
    System.out.println("|bet money on that                             |"); 
    System.out.println();
        
    System.out.println("The payout system");
    System.out.println("|For every color you bet on you'll recieve your|");
    System.out.println("|bet back with and addional amout of how much  |");
    System.out.println("|you bet                                       |");
    
    System.out.println("|For every number you bet on you'll recieve in |");
    System.out.println("|total how much you bet on multliplied by 35   |");
    System.out.println();
    
    Casion.roulettegame(Money);
    }
    
    public static void roulettegame(double Money){
    int bettingr=0;
    
    while(game){
        while(chips){
        System.out.println("You are betting $" + betting);
        System.out.println("Reply 'done' to stop the game");
        System.out.println();
        System.out.println("what chip(s) are you betting");
        System.out.println("|Chip Colors|      |Chip Prices|");
        System.out.println("|White Chip |      |$1         |");
        System.out.println("|Red Chip   |      |$5         |");
        System.out.println("|Blue Chip  |      |$10        |");
        System.out.println("|Green Chip |      |$25        |");
        System.out.println("|Black Chip |      |$100       |");
        System.out.println("|Purple Chip|      |$500       |");
        bet=main.nextLine();
        bet=bet.toLowerCase();
        
            if(bet.equals("done")){
            chips=false;
            }
            else{
            betting=0;
            bettingr=0;   
            }
            
            if(bet.equals("white chip")|| bet.equals("white")|| bet.equals("white chips")){
            bettingr=WhiteChip;
            }
            else if(bet.equals("red chip")|| bet.equals("red")|| bet.equals("red chips")){
            bettingr=RedChip;    
            }
            else if(bet.equals("blue chip")|| bet.equals("blue")|| bet.equals("blue chips")){
            bettingr=BlueChip;
            }
            else if(bet.equals("green chip")|| bet.equals("green")|| bet.equals("green chips")){
            bettingr=GreenChip;
            }
            else if(bet.equals("black chip")|| bet.equals("black")|| bet.equals("black chips")){
            bettingr=BlackChip;
            }
            else if(bet.equals("purple chip")|| bet.equals("purple")|| bet.equals("purple chips")){
            bettingr=PurpleChip;
            }
            else{
            System.out.println("Not a chip color, try again");   
            }
            
            if(Money<(betting+bettingr)){
            System.out.println("Your betting more than you owe, try again");   
            }
            else{
            betting=betting+bettingr;
            }
        }//chips
    
     for (int a = 0; a < roulette.length; a++) {
        for (int b = 0; b < roulette[a].length; b++) {
        System.out.print("+----");
        }
        System.out.println("+"); 
            for (int b = 0; b < roulette[a].length; b++) {
            System.out.print("| %2d|" + roulette[a][b]); 
            }
            System.out.println("|"); 
                for (int b = 0; b < roulette[a].length; b++) {
                    System.out.print("+---+"); 
                }
            System.out.println("+"); 
    }
    }
    //2d array goes down/up then left/right
    //2 up and down, 11 left right
    //36 total numbers 
    }//roulettegame
    
    public static void blackjack(double Money){
    System.out.println("You are gonna play blackjack");
    System.out.println("|For every chip you bet on you'll recieve      |");
    System.out.println("|you'll either double or lose that amount      |");
    System.out.println("|The goal is to get closer to 21, but not go   |");
    System.out.println("|higher and your suppose to beat the dealer    |");
    System.out.println();
    Casion.blackjackgame(Money);   
    }//blackjack
   
   
    public static void blackjackgame(double Money){
    Casion casion = new Casion();   
    int cardcount=0;
    boolean player=true;
    boolean robot=true;
 
    int bettingbj=0;   
    int playercount=0;
    int robotcount=0;

    
    while(game){
        while(chips){
        System.out.println("You are betting $" + betting);
        System.out.println("You have $" + Money);
        System.out.println("Reply 'done' to stop the game");
        System.out.println();
        System.out.println("what chip(s) are you betting");
        System.out.println("|Chip Colors|      |Chip Prices|");
        System.out.println("|White Chip |      |$1         |");
        System.out.println("|Red Chip   |      |$5         |");
        System.out.println("|Blue Chip  |      |$10        |");
        System.out.println("|Green Chip |      |$25        |");
        System.out.println("|Black Chip |      |$100       |");
        System.out.println("|Purple Chip|      |$500       |");
        System.out.println();
        bet=main.nextLine();
        bet=bet.toLowerCase();
        
            if(bet.equals("done")){
            chips=false;
            }
            else{
            betting=0;
            bettingbj=0;   
            }
            
            if(bet.equals("white chip")|| bet.equals("white")|| bet.equals("white chips")){
            bettingbj=WhiteChip;
            }
            else if(bet.equals("red chip")|| bet.equals("red")|| bet.equals("red chips")){
            bettingbj=RedChip;    
            }
            else if(bet.equals("blue chip")|| bet.equals("blue")|| bet.equals("blue chips")){
            bettingbj=BlueChip;
            }
            else if(bet.equals("green chip")|| bet.equals("green")|| bet.equals("green chips")){
            bettingbj=GreenChip;
            }
            else if(bet.equals("black chip")|| bet.equals("black")|| bet.equals("black chips")){
            bettingbj=BlackChip;
            }
            else if(bet.equals("purple chip")|| bet.equals("purple")|| bet.equals("purple chips")){
            bettingbj=PurpleChip;
            }
            else{
            System.out.println("Not a chip color, try again");   
            }
            
            if(Money<(betting+bettingbj)){
            System.out.println("Your betting more than you owe, try again");   
            }
            else{
            betting=betting+bettingbj;
            }
        }//chips
    
    
    System.out.println();
    System.out.println("Your 2 cards are");
        for (int a=0; a<2; a++) {
            cards card = Casion.Cards.get(cardcount);
            System.out.println("Card Name: " + card.newcards());
            System.out.println("Card Value: " + card.value());
            System.out.println("Card Points: " + card.points());
            playercount=playercount+card.points();
            cardcount++;
         }
        
        while(player){
        System.out.println("Would you like to add anothercard?");
        System.out.println("|Y/N|");
        reply=main.nextLine();
        reply=reply.toLowerCase();
            
            if(reply.equals("y")){
            cards card = Casion.Cards.get(cardcount);
            System.out.println("Card Name: " + card.newcards());
            System.out.println("Card Value: " + card.value());
            System.out.println("Card Points: " + card.points());
            playercount=playercount+card.points();
            cardcount++;
            
            if(playercount>21){
            System.out.println("You got over 21");
            System.out.println("It's a bust");
            Money=Money+(Money/betting);
            player=false;
            robot=false;
            }
            }
            
            else if(reply.equals("n")){
            player=false;       
            }
            else{
            System.out.println("Thats not an answer, try again");    
            }
        }
        
        if(robot){
            System.out.println("Now the dealer is drawing cards");
                while(robotcount<=17) {
                cards card = Casion.Cards.get(cardcount);
                System.out.println("Card Name: " + card.newcards());
                System.out.println("Card Value: " + card.value());
                System.out.println("Card Points: " + card.points());
                robotcount=robotcount+card.points();
                cardcount++;
                }
                
            if(robotcount>21){
            System.out.println("Robot loses");
            System.out.println("Congrats you won");
            Money=Money+betting;
            robot=false;
            }
            
            else if(playercount==robotcount){
            System.out.println("You both won, its a tie.... surprisingly");   
            robot=false;
            }
            
            else if(playercount>robotcount){
            System.out.println("Congrats you won");   
            Money=Money+(Money*betting);
            robot=false;
            }
            else if(playercount<robotcount){
            System.out.println("Somebody's a sore loser");   
            Money=Money-betting;
            robot=false;
            }
        }
        
     
    
    System.out.println("Play again?");
    System.out.println("|Y/N|");
    reply=main.nextLine();
    reply=reply.toLowerCase();
        if(reply.equals("n")){
        game=false;    
        betting=0;
        }
        if(reply.equals("y")){
        playercount=0;
        robotcount=0;
        robot=true;
        player=true;
        chips=true;
        betting=0;
        }
    } 
    
    }//blackjackgame
    
    public static void chips(double Money){
        System.out.println("|Welcome, since you are going to bet money, you might|");
        System.out.println("|as well know the casino chip values");
        
        while(response=true){
            System.out.println("|There are a total of 6 chips you can offer to the   |");
            System.out.println("|table. Which one would you like to know about?      |");
            System.out.println("|White, Red, Blue, Green, Black, Purple              |");
            System.out.println("|Type 'done' to quit                                 |");
            reply=main.next();
            reply=reply.toLowerCase(); 
            
            if(reply.equals("done")){
            response=false;
            }
            
            if(reply.equals("white")){
            System.out.println("The white casino chip is valued at $1");
            }
            if(reply.equals("red")){
            System.out.println("The red casino chip is valued at $5");   
            }  
            if(reply.equals("blue")){
            System.out.println("The blue casino chip is valued at $10");    
            }    
            if(reply.equals("green")){
            System.out.println("The green casino chip is valued at $25");    
            }   
            if(reply.equals("black")){
            System.out.println("The black casino chip is valued at $100");    
            }  
            if(reply.equals("purple")){
            System.out.println("The purple casino chip is valued at $500");    
            } 
        }
    }//chips 
    
    public static void information(){
    System.out.println("There is no law indication that gambling is illegal, but there are restrictions varying by each US state.");    
    System.out.println("Underage gambling is illegal, to partake in most casino game you have to be aged 21 and over.");   
    System.out.println("Appromixatly 1-6% of the world population has a gambling addiction ");  
    System.out.println();
    System.out.println("Since you unlocked this secret place, I will inform you statistically"); 
    
    System.out.println("|1. how unlikely you are to win |");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("|2. how the odds are against you|");
    System.out.println("");
    
    System.out.println("What game would you like to know about?");
    System.out.println("|Blackjack|");
    
    
    while(response=true){
        System.out.println("Type 'done to quit"); 
        reply=main.next();
        reply=reply.toLowerCase();
        
            if(reply.equals("roulette")){
            System.out.println("You are going to play Eurpoean Roulette");
            System.out.println("There are 36 numbers on the board");
            }
                
            if(reply.equals("blackjack")){
            System.out.println("There is approximately 8.0658*10^67 card combinations");
            System.out.println("The probability of winning blackjack is 0.4222");
            System.out.println("The probability of obtaining a natural blackjack is 0.048266 or once in every 20.72 hands");
            System.out.println("Probability of obtaining certain hand values");
            
            System.out.println("Hand Values      Probability");
            System.out.println("|17-20  |        |0.30 |"); 
            System.out.println("|1-16   |        |0.387|");
            System.out.println("|No Bust|        |0.265|");
            }
            
            if(reply.equals("done"))
            response=false;
        }
    }
}//information