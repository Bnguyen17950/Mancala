import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Created by bryannguyen on 4/3/15.
 */
public class View extends JFrame
{
        //update information (Contains all the listeners)
        // Contains buttons
        private JFrame frame;
        final Container pane;
        private DefaultTableModel TableModel;
        final JPanel pnlMancala;
        private JButton mancalaA;
        private JButton mancalaB;
        private JLabel mancalaPlayerA;
        private JLabel mancalaPlayerB;
        
        private ArrayList<JButton> AJButtons = new ArrayList<>();
        private ArrayList<JButton> BJButtons = new ArrayList<>();
        private ArrayList<JButton> mancala = new ArrayList<>();
        private ArrayList<JLabel> playerLabel = new ArrayList<>();
        private ArrayList<JLabel> pitLabel = new ArrayList<>();
        private ArrayList<JButton> allButtons = new ArrayList<>();
         
        public View() {
            //prepare frame
            frame = new JFrame("Mancala Board");
            frame.setSize(1200, 600);
            pane = frame.getContentPane();
            pane.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pnlMancala = new JPanel(null);
            
            
            //creates mancala B and mancala A
            int x = 80;
            for(int i = 0; i < 2; i++){
            	mancala.add(new JButton());
            	mancala.get(i).setBounds(x,100,60,300);
            	x += 780;
            	pnlMancala.add(mancala.get(i));
            	
            }
            
            //creates the label for the mancalas
            mancalaPlayerA = new JLabel("Player A");
            mancalaPlayerB = new JLabel("Player B");
            playerLabel.add(mancalaPlayerA);
            playerLabel.add(mancalaPlayerB);
            x = 80;
            for(int i = 0; i < playerLabel.size(); i++){
            	playerLabel.get(i).setBounds(x, 40, 100,100);
            	x += 780;
            	pnlMancala.add(playerLabel.get(i));
            }
            
            
            //creates row of A pits
            x = 200;
            for(int i = 0; i < 6; i++){
            	AJButtons.add(new JButton());
            	AJButtons.get(i).setBounds(x, 260, 100, 40);
            	x += 100;
            	pnlMancala.add(AJButtons.get(i));
            	String buttonNumber = "A" + (i+1);
            	AJButtons.get(i).setName(buttonNumber);
//            	AJButtons.get(i).setText(buttonNumber);
            }
         
           
            //creates row of B pits
             x = 700;
            for(int i = 0; i < 6; i++){
            	BJButtons.add(new JButton());
            	BJButtons.get(i).setBounds(x, 220, 100, 40);
            	x -= 100;
            	String buttonNumber = "B" + (i+1);
            	BJButtons.get(i).setName(buttonNumber);
//            	BJButtons.get(i).setText(buttonNumber);
            	pnlMancala.add(BJButtons.get(i));
            }
            
            //inserts all the buttons into one arraylist
            for(int i = 0; i < AJButtons.size(); i++){
            	allButtons.add(AJButtons.get(i));
            }
            for(int i = 0; i < BJButtons.size(); i++){
            	allButtons.add(BJButtons.get(i));
            }
            
         // Creates labels for Player A's pits
            for(int i = 0; i < 6; i++)
            {
             final JLabel aLabel = new JLabel("A" + (i+1));
             pitLabel.add(aLabel);
             
             int xCoord = AJButtons.get(i).getX() + AJButtons.get(i).getWidth() / 2;
             int yCoord = AJButtons.get(i).getY() + AJButtons.get(i).getHeight();
             aLabel.setBounds(xCoord, yCoord, AJButtons.get(i).getWidth(), AJButtons.get(i).getHeight()/2);
            }
            
            // Creates labels for Player B's pits
            for(int i = 0; i < 6; i++)
            {
             final JLabel bLabel = new JLabel("B" + (6 - i));
             pitLabel.add(bLabel);
             
             int xCoord = BJButtons.get(i).getX() + BJButtons.get(i).getWidth() / 2;
             int yCoord = BJButtons.get(i).getY() - BJButtons.get(i).getHeight() /2 ;
             bLabel.setBounds(xCoord, yCoord, BJButtons.get(i).getWidth(), BJButtons.get(i).getHeight()/2);
            }
            for(JLabel label: pitLabel){
            	pnlMancala.add(label);
            }
           
            
            pnlMancala.setBounds(0, 0, 1200, 600);
            pnlMancala.setBorder(BorderFactory.createTitledBorder("Mancala"));
            pane.add(pnlMancala);
            frame.setResizable(true);
            frame.setVisible(true);
        }
        public ArrayList<JButton> getPits(){
        	return allButtons;
        }
        
        public void addPitActionListener(ActionListener l){
        	for(JButton button: allButtons){
        		button.addActionListener(l);
        	}
        }
        //controller function. implementation of the pit's actionlistener
//        public void setPits(){
//        	//pits
//        	ArrayList<JButton> allPits = view.getPitArrayList();
//        	array modelArray = model.getArray();
//        	for(int i =0; i < allPits.size(); i++){
//        		String stones = setStones(modelArray[i]);
//        		allPits.get(i).setText(stones);
//        	}
//        	
//        	//order of each player has to match between the two arraylist of Jbutton and players
//        	//same thing for player's mancala. 
//        	ArrayList<Player> players = new ArrayList<Player>();
//        	players.add(model.getPlayerA());
//        	players.add(model.getPlayerB(); 
//        	ArrayList<JButton> mancalaButton = view.getMancalaButtons();
//  
//        	for(int i = 0; i < players.size(); i++){
//        		String stones = setStones(players.getStonesInMancala());
//        		mancalaButton.get(i).setText(stones);
//        	}
//        }
        
   
    }