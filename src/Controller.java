import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by bryannguyen on 4/13/15.
 */
public class Controller extends View
{
    final JLabel Player1;
    final JLabel Player2;
    final View board;
    private Model m;
    public Controller()
    {
        Player1 = new JLabel("Player 1 -->");
        Player2 = new JLabel("Player 2 -->");
        m = new Model();
        board = new View();

        m.addActionListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                board.showPlayersTurn();
            }
        });
    }
}
