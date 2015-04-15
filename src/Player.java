/**
 * Created by bryannguyen on 4/13/15.
 */
public class Player
{
    private int stonesInMancala;

    public Player()
    {
        setStones(0);
    }

    public void setStones(int n)
    {
        stonesInMancala = n;
    }

    public void addStoneToMancala()
    {
        stonesInMancala++;
    }

    public int getStonesInMancala()
    {
        return stonesInMancala;
    }
}
