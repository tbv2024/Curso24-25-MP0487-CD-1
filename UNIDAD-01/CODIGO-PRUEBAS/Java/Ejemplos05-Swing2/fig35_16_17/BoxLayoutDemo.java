// Fig. 22.17: BoxLayoutDemo.java
// Demonstrating BoxLayout.
import javax.swing.JFrame;
public class BoxLayoutDemo {
    public static void main(String[] args)  {
        BoxLayoutFrame boxLayoutFrame = new BoxLayoutFrame();
        boxLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boxLayoutFrame.setSize(400, 220);
        boxLayoutFrame.setVisible(true);
    }
} // end class BoxLayoutDemo