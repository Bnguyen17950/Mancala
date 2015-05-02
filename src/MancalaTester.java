import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bryannguyen on 4/13/15.
 */
public class MancalaTester
{
    static JFrame mainFrame;
    static Container pane;
    static JLabel lblMancala, authors;
    static JButton Stone2, Stone4, View1, View2;
    static JPanel pnlDecisionPanel;
    public static void main(String[] args)
    {
        //Create Frame take user input
        mainFrame = new JFrame();
        mainFrame.setSize(500, 500);
        pane = mainFrame.getContentPane();
        pnlDecisionPanel = new JPanel(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblMancala = new JLabel("Play Mancala!");
        authors = new JLabel("Nam Lam, Bryan Nguyen, Kevin Yan");
        View1 = new JButton("View 1");
        View2 = new JButton("View 2");
        Stone2 = new JButton("2");
        Stone4 = new JButton("4");


        pane.add(pnlDecisionPanel);
        pnlDecisionPanel.add(lblMancala);
        pnlDecisionPanel.add(View1);
        pnlDecisionPanel.add(View2);
        pnlDecisionPanel.add(authors);

        lblMancala.setFont(lblMancala.getFont().deriveFont(30.0f));
        lblMancala.setForeground(Color.GRAY);
        authors.setFont(authors.getFont().deriveFont(20.0f));
        authors.setForeground(Color.BLUE);
        lblMancala.setBounds(150, 0, 200, 200);
        View1.setBounds(130, 150, 80, 80);
        View2.setBounds(300, 150, 80, 80);
        authors.setBounds(100, 250, 400, 100);

        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        View1.addActionListener(new View1Action());
        View2.addActionListener(new View2Action());
    }

    static class View1Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Pit p = new Pit();
        }
    }

    static class View2Action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Pit p = new Pit();
        }
    }
}
