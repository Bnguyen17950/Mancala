import java.awt.event.ActionListener;

/**
 * Created by bryannguyen on 4/24/15.
 */
public interface BoardStrategy
{
    void CreateMancala();
    void CreateLabels();
    void CreateRowAPits();
    void CreateRowBPits();
    void insertButtons();
    void CreateLabelsForPlayerA();
    void addPitActionListener(ActionListener l);
	void addMancalaActionListener(ActionListener l);
	void addUndoActionListener(ActionListener l);
}
