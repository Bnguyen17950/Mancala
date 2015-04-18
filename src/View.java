import java.awt.Container;
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
        final private JFrame frame;
        final Container pane;
        private DefaultTableModel TableModel;
        final JPanel pnlMancala;
        final JLabel PitLabelsA;
        final JLabel PitLabelsB;
        final Model newModel;
        private JButton mancalaA;
        private JButton mancalaB;
        private JLabel mancalaPlayerA;
        private JLabel mancalaPlayerB;
        
        private ArrayList<JButton> AJButtons = new ArrayList<>();
        private ArrayList<JButton> BJButtons = new ArrayList<>();
        private ArrayList<JButton> mancala = new ArrayList<>();
        private ArrayList<JLabel> playerLabel = new ArrayList<>();
        private ArrayList<JLabel> pitLabel = new ArrayList<>();
        
        public View() {
            //prepare frame
            frame = new JFrame("Mancala Board");
            frame.setSize(1200, 600);
            pane = frame.getContentPane();
            pane.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pnlMancala = new JPanel(null);
            newModel = new Model(0); // added a zero because of error of int
            
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
            	AJButtons.add(new JButton("A"));
            	AJButtons.get(i).setBounds(x, 260, 100, 40);
            	x += 100;
            	pnlMancala.add(AJButtons.get(i));
            }
         
           
            //creates row of B pits
             x = 200;
            for(int i = 0; i < 6; i++){
            	BJButtons.add(new JButton("B"));
            	BJButtons.get(i).setBounds(x, 220, 100, 40);
            	x += 100;
            	pnlMancala.add(BJButtons.get(i));
            }
            
            //creates labels for pits
            String space = "                            "; 
            PitLabelsB = new JLabel("B6" + space + "B5" + space + "B4" + space + "B3" + space + "B2" + space + "B1"); //4.17.15
            PitLabelsA = new JLabel("A1" + space + "A2" + space + "A3" + space + "A4" + space + "A5" + space + "A6"); //4.17.15
            pitLabel.add(PitLabelsB);
            pitLabel.add(PitLabelsA); 
            PitLabelsA.setBounds(250, 140, 600, 350);
            PitLabelsB.setBounds(250, 80, 600, 250);
            for(JLabel label: pitLabel){
            	pnlMancala.add(label);
            }
           
            
            pnlMancala.setBounds(0, 0, 1200, 600);
            pnlMancala.setBorder(BorderFactory.createTitledBorder("Mancala"));
            pane.add(pnlMancala);
            frame.setResizable(true);
            frame.setVisible(true);
        }

        public void showPlayersTurn() {
            //newPlayer
        }
    }