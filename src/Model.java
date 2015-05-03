import java.util.Scanner;

public class Model
{
    private int[] pits;
    private int[] copyPits;
    private int previousP1Mancala, previousP2Mancala;
    private boolean gameOver;
    private int counter;
    private int counter2;
    private Player player1;
    private Player player2;

    public Model()
    {
    	previousP1Mancala = 0;
    	previousP2Mancala = 0;
        pits = new int[12];
        copyPits = new int[12];
        boolean gameOver = false;
        counter = 0;
        counter2= 0;
        player1 = new Player();
        player2 = new Player();
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
    
    public void saveState()
    {
     System.arraycopy(pits, 0, copyPits, 0, copyPits.length);
     previousP1Mancala = getStonesInP1Mancala();
     previousP2Mancala = getStonesInP2Mancala();
     counter2 = counter;
    }
    
    public void restoreState()
    {
     System.arraycopy(copyPits, 0, pits, 0, pits.length);
     player1.setStones(previousP1Mancala);
     player2.setStones(previousP2Mancala);
     counter = counter2;
    }
    public void pickPitNumber(String pit)
    {
        saveState();

        int pitNumber = Integer.parseInt(pit.substring(1, 2)) - 1;
        if(pit.substring(0, 1).equals("B"))
            pitNumber = pitNumber + 6;

        int stonesToPlace = pits[pitNumber];
        pits[pitNumber] = 0;

        for(int i = pitNumber + 1, j = 0; j < stonesToPlace; i++, j++)
        {
            if(i == 6 && counter % 2 == 0) // Update P1 Mancala
            {
                player1.addStoneToMancala();
                if(j < stonesToPlace - 1) // if there are more stones to be added
                {
                    pits[i % 12]++;
                    j++;
                }
                else if(j == stonesToPlace - 1) // if there are no more stones to be added
                    counter--;	// Player 1 gets another turn for ending in mancala
            }
            else if(i == 12 && counter % 2 == 1) // Update P2 mancala
            {
                player2.addStoneToMancala();
                if(j < stonesToPlace - 1)	// if there are more stones to be added
                {
                    pits[i % 12]++;
                    j++;
                }
                else if(j == stonesToPlace - 1)
                    counter--; // player 2 gets another turn for ending in mancala
            }
            else
                pits[i % 12]++;

            // Begin checking captures
            if(j == stonesToPlace - 1 && counter % 2 == 0 && pits[i % 12] == 1)
            {
                if(i % 12 <= 5)
                {
                    player1.setStones(player1.getStonesInMancala() + pits[pits.length - (i % 12) - 1]);
                    pits[pits.length - (i % 12) - 1] = 0;
                }
            }
            else if(j == stonesToPlace - 1 && counter % 2 == 1 && pits[i % 12] == 1)
            {
                if(i % 12 >= 6)
                {
                    player2.setStones(player2.getStonesInMancala() + pits[pits.length - (i % 12) - 1]);
                    pits[pits.length - (i % 12) - 1] = 0;
                }
            }
        }

        checkWinner();
        counter++; 
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
            gameOver = true;
    }
	
	public int getCounter()
	{
		return counter;
	}

    public int pitIndex(String pit)
	{
        int pitNumber = Integer.parseInt(pit.substring(1, 2)) - 1;
        if(pit.substring(0, 1).equals("B"))
            pitNumber = pitNumber + 6;
		
        return pitNumber;
    }
    
    public boolean checkGameOver() 
	{
    	return gameOver;
    }  
	
    public boolean checkIfValid(String pit)
	{
		boolean result = false;
		int index = 0;
		
    	if(counter % 2 == 0 && pit.substring(0, 1).equals("A"))
		{
        	result = true;
			index = Integer.parseInt(pit.substring(1, pit.length())) - 1;
		}
		else if(counter % 2 == 1 && pit.substring(0, 1).equals("B"))
		{
			result = true;
 			index = Integer.parseInt(pit.substring(1, pit.length())) - 1 + 6;
		}
		
		if(pits[index] == 0)
			result = false;
		
    	return result;
    }

	public int getP1UndoCount()
	{
		return player1.getUndoCounter();
	}
	
	public int getP2UndoCount()
	{
		return player2.getUndoCounter();
	}
	
	public void addP1Undo()
	{
		player1.addUndo();
	}
	
	public void addP2Undo()
	{
		player2.addUndo();
	}
	
	public void undoOccured()
	{
		counter--;
	}
}