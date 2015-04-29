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
 * update kevin 11:18
 * Created by bryannguyen on 4/3/15.
 */
public class View extends AbstractStrategy
{
    private JLabel mancalaPlayerA;
    private JLabel mancalaPlayerB;

    public void CreateMancala()
    {
        //creates mancala B and mancala A
        int x = 80;
        for (int i = 0; i < 2; i++) {
            getMancala().add(new JButton());
            getMancala().get(i).setBounds(x, 100, 60, 300);
            x += 780;
            pnlMancala.add(getMancala().get(i));

        }
    }

    public void CreateLabels()
    {
        //creates the label for the mancalas
        mancalaPlayerA = new JLabel("Player A");
        mancalaPlayerB = new JLabel("Player B");
        getPlayerLabel().add(mancalaPlayerB);
        getPlayerLabel().add(mancalaPlayerA);
        int x = 80;
        for (int i = 0; i < getPlayerLabel().size(); i++) {
            getPlayerLabel().get(i).setBounds(x, 40, 100, 100);
            x += 780;
            pnlMancala.add(getPlayerLabel().get(i));
        }
    }



}