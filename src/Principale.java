import javax.swing.*;
import java.awt.*;


public class Principale {

    static JFrame SCI=new JFrame("Schermata Iniziale");
    public static void main(String[]arg)throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        INIZ IN= new INIZ();
        SCI.add(IN);
        SCI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        SCI.setVisible(true);
        SCI.setSize(800,400);
        SCI.setResizable(false);
        SCI.setBackground(new Color(255, 255, 255));


    }
}
