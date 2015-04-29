import java.util.Scanner;

public class Model
{
    private int[] pits;
    private boolean gameOver;
    private int counter;
    private Player player1;
    private Player player2;

    public Model()
    {
        pits = new int[12];
        boolean gameOver = false;
        counter = 0;
        player1 = new Player();
        player2 = new Player();
        //initiatePits(initialStones);
        //startGame();
    }

    public void initiatePits(int n)
    {
        for(int i = 0; i < pits.length; i++)
            pits[i] = n;
    }

    public int getStonesInPit(int index)
    {
        return pits[index];
    }

    public void setStonesInPit(int index, int numOfStones)
    {
        pits[index] = numOfStones;
    }

    public void addToP1Mancala()
    {
        player1.addStoneToMancala();
    }

    public void addToP2Mancala() {
        player2.addStoneToMancala();
    }

    public int getStonesInP1Mancala()
    {
        return player1.getStonesInMancala();
    }

    public int getStonesInP2Mancala()
    {
        return player2.getStonesInMancala();
    }

    public static void main(String[] args)
    {
        //Model test = new Model(2);
    }
	

    public void pickPitNumber(String pit)
    {
        int pitNumber = Integer.parseInt(pit.substring(1, 2)) - 1;
        if(pit.substring(0, 1).equals("B"))
            pitNumber = pitNumber + 6;

        int stonesToPlace = pits[pitNumber];
        pits[pitNumber] = 0;

        for(int i = pitNumber + 1, j = 0; j < stonesToPlace; i++, j++)
        {
            if(i == 6 && counter % 2 == 0)
            {
                player1.addStoneToMancala();
                if(j < stonesToPlace - 1)
                {
                    pits[i % 12]++;
                    j++;
                }
                else if(j == stonesToPlace - 1)
                {
                    checkWinner();
                    counter--;
                }
            }
            else if(i == 12 && counter % 2 == 1)
            {
                player2.addStoneToMancala();
                if(j < stonesToPlace - 1)
                {
                    pits[i % 12]++;
                    j++;
                }
                else if(j == stonesToPlace - 1)
                {
                    checkWinner();
                    counter--;
                }
            }
            else
                pits[i % 12]++;

            if(j == stonesToPlace - 1 && counter % 2 == 0 && pits[i % 12] == 1)
            {
                if(i % 12 <= 5)
                {
                    //System.out.println("Checking capture; i = " + i);
                    player1.setStones(player1.getStonesInMancala() + pits[pits.length - i - 1]);
                    pits[pits.length - i - 1] = 0;
                    //System.out.println("Stones captured @ index " + (pits.length - i - 1));
                    checkWinner();
                }
            }
            else if(j == stonesToPlace - 1 && counter % 2 == 1 && pits[i % 12] == 1)
            {
                if(i % 12 >= 6)
                {
                    //System.out.println("Checking capture; i = " + i);
                    player2.setStones(player2.getStonesInMancala() + pits[pits.length - i % 12 - 1]);
                    pits[pits.length - i - 1] = 0;
                    //System.out.println("Stones captured @ index " + (pits.length - i - 1));
                    checkWinner();
                }
            }
        }
        //showPits();
        checkWinner();
        counter++; //added here instead of startGame()
    }

    public void checkWinner()
    {
        int zerosFound = 0;
        if(counter % 2 == 0)
        {
            for(int i = 0; i < pits.length / 2; i++)
                if(pits[i] == 0)
                    zerosFound++;
        }
        else if(counter % 2 == 1)
        {
            for(int i = 6; i < pits.length; i++)
                if(pits[i] == 0)
                    zerosFound++;
        }

        if(zerosFound == 6)
        {
            gameOver = true;
//            if(player1.getStonesInMancala() > player2.getStonesInMancala())
//                System.out.println("Player 1 Wins");
//            else if(player2.getStonesInMancala() > player2.getStonesInMancala())
//                System.out.println("Player 2 Wins");
//            else
//                System.out.println("Draw Game");
        }
    }
	
	public int getCounter()
	{
		return counter;
	}
		
	/*
    private void showPits()
    {
        System.out.println();
        for(int j = pits.length - 1, i = 6; j > pits.length / 2 - 1; j--, i--)
            System.out.printf("B%d = %d ", i, pits[j]);

        System.out.println();
        System.out.println();

        for(int i = 0; i < pits.length / 2; i++)
            System.out.printf("A%d = %d ", i+1, pits[i]);

        System.out.println();
        System.out.println("Player 1's Mancala: " + player1.getStonesInMancala());
        System.out.println("Player 2's Mancala: " + player2.getStonesInMancala());
        System.out.println();
    }


    private void startGame()
    {
        Scanner input = new Scanner(System.in);

        showPits();

        while(!gameOver)
        {
            System.out.println("It is Player " + (counter%2+1) + "'s turn");
            System.out.print("Pick a pit: ");
            String pit = input.nextLine().toUpperCase();

            if(counter % 2 == 0 && !pit.substring(0, 1).equals("A"))
            {
                System.out.println("Invalid move.");
                continue;
            }
            else if(counter % 2 == 1 && !pit.substring(0, 1).equals("B"))
            {
                System.out.println("Invalid move.");
                continue;
            }

            pickPitNumber(pit);
            counter++;
        }

    }
*/
    public int pitIndex(String pit){
        int pitNumber = Integer.parseInt(pit.substring(1, 2)) - 1;
        if(pit.substring(0, 1).equals("B"))
            pitNumber = pitNumber + 6;
        return pitNumber;
    }
    
    public boolean checkGameOver(){
    	return gameOver;
    }  
    public boolean checkIfValid(String pit){
//    	if(!gameOver){
    		if(counter % 2 == 0 && !pit.substring(0, 1).equals("A"))
            {
                return true;
                
            }
            else if(counter % 2 == 1 && !pit.substring(0, 1).equals("B"))
            {
               	return true;
               
            }
//    	}
    	return false;
    }

	

}