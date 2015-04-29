import javax.swing.*;
import java.awt.*;
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
        //creates mancala B and then mancala A
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
        mancalaPlayerA.setForeground(Color.red);
        mancalaPlayerB.setForeground(Color.blue);
        getPlayerLabel().add(mancalaPlayerB);
        getPlayerLabel().add(mancalaPlayerA);
        for(int i = 0; i < getPlayerLabel().size(); i++)
        {
            int xCoord = getMancala().get(i).getX() + getMancala().get(i).getWidth() / 3;
            int yCoord = getMancala().get(i).getY() - getMancala().get(i).getHeight() / 2;
            getPlayerLabel().get(i).setBounds(xCoord, yCoord, getMancala().get(i).getWidth() / 2, getMancala().get(i).getHeight() / 2);
            pnlMancala.add(getPlayerLabel().get(i));
        }
    }
}
