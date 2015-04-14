import javax.swing.*;
import java.awt.*;

/**
 * Created by bryannguyen on 4/13/15.
 */
public class Pit implements Icon
{
    private int width;

    public void width(int pWidth)
    {
        width = pWidth;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

    }

    @Override
    public int getIconWidth() {
        return 0;
    }

    @Override
    public int getIconHeight() {
        return 0;
    }
}
