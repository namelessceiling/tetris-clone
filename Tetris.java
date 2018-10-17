import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Tetris extends JFrame {

    private JLabel statusBar;

    public static void main(String[] args)
    {
        Tetris myTetris = new Tetris();
        myTetris.setLocationRelativeTo(null);
        myTetris.setVisible(true);
    }

    public Tetris()
    {
        statusBar = new JLabel("0"); //displays status
        add(statusBar, BorderLayout.SOUTH); //points are displayed in the bottom left corner
        Well well = new Well(this); //creates the well for the tetrominoes to fall in
        add(well);
        well.start(); //starts the game
        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Closes when the exit button is pressed
    }

    public JLabel getStatusBar()
    {
        return statusBar;
    }
}


