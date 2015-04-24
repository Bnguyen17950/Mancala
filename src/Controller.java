import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * Created by bryannguyen on 4/13/15.
 */
public class Controller
{
    //update information (Contains all the listeners)
	private int counter;
    private Model model;
    private View view;

    public Controller(Model model, View view)
    {
     this.model = model;
     this.view = view;
	 counter = 0;
     
     
  
     this.view.addPitActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       String pitNumber = ((JButton) e.getSource()).getName();
       
       
       pickPitNumber(pitNumber);
       
       ArrayList<JButton> allPits = view.getPits();
       int[] modelArray = model.getModelPits();
             for(int i =0; i < allPits.size(); i++){
              String stones = setStones(model.getPitsInStones(3));
              allPits.get(i).setText(stones);
             }
             view.updateButton(stones, 4, true);
			 view.updateButtons(stones, 3, false);
//             ArrayList<Player> players = new ArrayList<Player>();
//             players.add(model.getPlayerA());
//             players.add(model.getPlayerB(); 
//             ArrayList<JButton> mancalaButton = view.getMancalaButtons();
//      
//             for(int i = 0; i < players.size(); i++){
//              String stones = setStones(players.getStonesInMancala());
//              mancalaButton.get(i).setText(stones);
//             }
      }
     });
    
    }
    //in model class or controller. takes the number of stones and return appropriate number of asterisks
    public String setStones(int number){
     String stones = "";
     for(int i =0; i < number; i++){
      stones += "*";
     }
     return stones;
    }
	
    private void pickPitNumber(String pit)
    {
        int pitNumber = Integer.parseInt(pit.substring(1, 2)) - 1;
        if(pit.substring(0, 1).equals("B"))
            pitNumber = pitNumber + 6;
		

        int stonesToPlace = model.getStonesInPit(pitNumber);
		model.setStonesInPit(pitNumber, 0);

        for(int i = pitNumber + 1, j = 0; j < stonesToPlace; i++, j++)
        {
            if(i == 6 && counter % 2 == 0)
            {
				model.addToP1Mancala();
                if(j < stonesToPlace - 1)
                {
					model.setStonesInPit(i % 12, model.getStonesInPit(i % 12) + 1);
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
				model.addToP2Mancala();
                if(j < stonesToPlace - 1)
                {
                    model.setStonesInPit(i % 12, model.getStonesInPit(i % 12) + 1);
                    j++;
                }
                else if(j == stonesToPlace - 1)
                {
                    checkWinner();
                    counter--;
                }
            }
            else
                model.setStonesInPit(i % 12, model.getStonesInPit(i % 12) + 1);

            if(j == stonesToPlace - 1 && counter % 2 == 0 && model.getStonesInPit(i % 12) == 1)
            {
                if(i % 12 <= 5)
                {
					model.setP1Stones(model.getStonesInP1Mancala() + model.getStonesInPit(11 - i));
                    //player1.setStones(player1.getStonesInMancala() + pits[pits.length - i - 1]);
                    //pits[pits.length - i - 1] = 0;
					model.setStonesInPit(11 - i, 0);
                    //System.out.println("Stones captured @ index " + (pits.length - i - 1));
                    checkWinner();
                }
            }
            else if(j == stonesToPlace - 1 && counter % 2 == 1 && model.getStonesInPit(i % 12) == 1)
            {
                if(i % 12 >= 6)
                {
                    //System.out.println("Checking capture; i = " + i);
                    //player2.setStones(player2.getStonesInMancala() + pits[pits.length - i % 12 - 1]);
					model.setP2Stones(model.getStonesInP2Mancala() + model.getStonesInPit(12 - i % 12 - 1));
                    //pits[pits.length - i - 1] = 0;
					model.setStonesInPit(11 - i, 0);
                    //System.out.println("Stones captured @ index " + (pits.length - i - 1));
                    checkWinner();
                }
            }
        }
        checkWinner();
    }

    private void checkWinner()
    {
        int zerosFound = 0;
        if(counter % 2 == 0)
        {
            for(int i = 0; i < 6; i++)
                if(model.getStonesInPit(i) == 0)
                    zerosFound++;
        }
        else if(counter % 2 == 1)
        {
            for(int i = 6; i < pits.length; i++)
                if(model.getStonesInPit(i) == 0)
                    zerosFound++;
        }

        if(zerosFound == 6)
        {
            gameOver = true;
            if(model.getStonesInP1Mancala() > model.getStonesInP2Mancala())
                System.out.println("Player 1 Wins");
            else if(model.getStonesInP2Mancala() > model.getStonesInP1Mancala())
                System.out.println("Player 2 Wins");
            else
                System.out.println("Draw Game");
        }
    }
	
	public int getCounter()
	{
		return counter;
	}
	
}