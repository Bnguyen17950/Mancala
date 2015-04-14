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
    final JButton newButton;
    final private JFrame frame;
    final Container pane;
    private DefaultTableModel TableModel;
    final JPanel pnlMancala;
    final JLabel A1;
    public View()
    {
        //prepare frame
        frame = new JFrame("Mancala Board");
        frame.setSize(500, 500);
        pane = frame.getContentPane();
        pane.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create controls
        newButton = new JButton();
        pnlMancala = new JPanel(null);
        A1 = new JLabel("A1");
        pnlMancala.setBorder(BorderFactory.createTitledBorder("Mancala"));

        //Add controls
        pane.add(pnlMancala);
        pnlMancala.add(newButton);
        pnlMancala.add(A1);

        //setBounds
        pnlMancala.setBounds(0, 0, 480, 500);
        newButton.setBounds(200, 200, 20, 20);
        A1.setBounds(100, 200, 20, 20);

        //Make frame visible
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
