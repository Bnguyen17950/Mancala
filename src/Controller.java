import javax.swing.*;
import java.awt.*;

/**
 * Created by bryannguyen on 4/13/15.
 */
public class Controller extends JFrame
{
    //update information (Contains all the listeners)
    // Contains buttons
    final JButton newButton;
    final private JFrame frame;
    final Container pane;
    final JButton pit;

    public Controller()
    {
        frame = new JFrame("Mancala Board");
        frame.setSize(500,500);
        pane = frame.getContentPane();
        pane.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newButton = new JButton();
        newButton.add(Pits);
    }
}
