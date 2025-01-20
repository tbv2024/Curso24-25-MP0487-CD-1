// Fig. 22.22: GridBagDemo.java
// Demonstrating GridBagLayout.
import javax.swing.JFrame;

public class GridBagDemo {
    public static void main(String[] args)  {
        GridBagFrame gridBagFrame = new GridBagFrame();
        gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridBagFrame.setSize(300, 150);
        gridBagFrame.setVisible(true);
    }
} // end class GridBagDemo