import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bryannguyen on 4/29/15.
 */
public class Pit
{
    private JFrame frame;
    private JTextArea stoneNumber;
    private JLabel stoneLabel;
    private JButton Enter;
    private Container pane;
    private JPanel pnlStones;
    private int number;

    public Pit(int x)
    {
        number = x;
        frame = new JFrame();
        pane = frame.getContentPane();
        stoneNumber = new JTextArea();
        stoneLabel = new JLabel("Enter Number of Stones: ");
        Enter = new JButton("Enter");
        pnlStones = new JPanel(null);
        frame.setSize(300, 200);

        pane.add(pnlStones);
        pnlStones.add(stoneNumber);
        pnlStones.add(stoneLabel);
        pnlStones.add(Enter);

        stoneLabel.setBounds(20, 20, 250, 50);
        stoneNumber.setBounds(30, 80, 50, 25);
        Enter.setBounds(100, 80, 50, 20);

        frame.setVisible(true);
        frame.setResizable(false);

        Enter.addActionListener(new Enter_Action());

    }

    public class Enter_Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(number == 0)
            {
                int StonesEntered = Integer.parseInt(stoneNumber.getText());
                Model model = new Model();
                model.initiatePits(StonesEntered);
                Controller c = new Controller(model, new View());
            }
            else
            {
                int StonesEntered = Integer.parseInt(stoneNumber.getText());
                Model model = new Model();
                model.initiatePits(StonesEntered);
                Controller c = new Controller(model, new View2());
            }
        }
    }

}
