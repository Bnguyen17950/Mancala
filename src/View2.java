import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by bryannguyen on 4/24/15.
 */
public class View2 extends AbstractStrategy
{

    private JLabel mancalaPlayerA;
    private JLabel mancalaPlayerB;

    public void CreateMancala()
    {
        //creates mancala B and mancala A
        int y = 80;
        for (int i = 0; i < 2; i++) {
            getMancala().add(new JButton());
            getMancala().get(i).setBounds(320, y, 320, 40);
            y += 320;
            pnlMancala.add(getMancala().get(i));

        }
    }

    public void CreateLabels()
    {
        //creates the label for the mancalas
        mancalaPlayerA = new JLabel("Player A");
        mancalaPlayerB = new JLabel("Player B");
        getPlayerLabel().add(mancalaPlayerA);
        getPlayerLabel().add(mancalaPlayerB);
        int x = 80;
        for (int i = 0; i < getPlayerLabel().size(); i++) {
            getPlayerLabel().get(i).setBounds(x, 40, 100, 100);
            x += 780;
            pnlMancala.add(getPlayerLabel().get(i));
        }
    }
}
