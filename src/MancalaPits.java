import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by bryannguyen on 4/14/15.
 */
public class MancalaPits implements AllShapes
{
    private int x;
    private int y;
    private int width;

    public MancalaPits(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double Pit
                = new Ellipse2D.Double(x, y + width / 6,
                width / 6, width / 6);
        g2.draw(Pit);
    }

}
