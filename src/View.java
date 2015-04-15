import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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

        public View() {
            //prepare frame
            frame = new JFrame("Mancala Board");
            frame.setSize(1200, 600);
            pane = frame.getContentPane();
            pane.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newModel = new Model(0); // added a zero because of error of int

            //Create controls
            JButton A1Button = new JButton();
            JButton A2Button = new JButton();
            JButton A3Button = new JButton();
            JButton A4Button = new JButton();
            JButton A5Button = new JButton();
            JButton A6Button = new JButton();

            JButton B1Button = new JButton();
            JButton B2Button = new JButton();
            JButton B3Button = new JButton();
            JButton B4Button = new JButton();
            JButton B5Button = new JButton();
            JButton B6Button = new JButton();

            pnlMancala = new JPanel(null);
            String space = "                     ";
            PitLabelsA = new JLabel("A1" + space + "A2" + space + "A3" + space + "A4" + space + "A5" + space + "A6");
            PitLabelsB = new JLabel("B1" + space + "B2" + space + "B3" + space + "B4" + space + "B5" + space + "B6");
            pnlMancala.setBorder(BorderFactory.createTitledBorder("Mancala"));

            //Add controls
            pane.add(pnlMancala);
            pnlMancala.add(PitLabelsA);
            pnlMancala.add(PitLabelsB);
            pnlMancala.add(A1Button);
            pnlMancala.add(A2Button);
            pnlMancala.add(A3Button);
            pnlMancala.add(A4Button);
            pnlMancala.add(A5Button);
            pnlMancala.add(A6Button);
            pnlMancala.add(B1Button);
            pnlMancala.add(B2Button);
            pnlMancala.add(B3Button);
            pnlMancala.add(B4Button);
            pnlMancala.add(B5Button);
            pnlMancala.add(B6Button);


            //setBounds
            pnlMancala.setBounds(0, 0, 1200, 600);
            PitLabelsA.setBounds(250, 150, 600, 350);
            PitLabelsB.setBounds(250, 80, 600, 250);
            A1Button.setBounds(200, 260, 100, 40);
            A2Button.setBounds(300, 260, 100, 40);
            A3Button.setBounds(400, 260, 100, 40);
            A4Button.setBounds(500, 260, 100, 40);
            A5Button.setBounds(600, 260, 100, 40);
            A6Button.setBounds(700, 260, 100, 40);
            B1Button.setBounds(200, 220, 100, 40);
            B2Button.setBounds(300, 220, 100, 40);
            B3Button.setBounds(400, 220, 100, 40);
            B4Button.setBounds(500, 220, 100, 40);
            B5Button.setBounds(600, 220, 100, 40);
            B6Button.setBounds(700, 220, 100, 40);


            //Make frame visible
            frame.setResizable(true);
            frame.setVisible(true);
        }

        public void showPlayersTurn() {
            //newPlayer
        }
    }