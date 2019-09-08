import javax.swing.*;
import java.awt.*;

public class START extends JPanel
{
    private JButton NButton;
    private JButton DButton;
    private JButton IButton;
    public  JPanel DIF;
    private JTextArea TXT;
    private JLabel DOM;
    private static String Diff="null";
    static JFrame SG;

    START()
    {
        super();
        add(DIF);
        NButton.setVisible(true);
        DButton.setVisible(true);
        IButton.setVisible(true);
        DOM.setVisible(true);
        DIF.setSize(800,400);
        TXT.setVisible(true);
        TXT.setText("Utilizzo: \nPer muovere la barra premere i tasti 'A' o 'D', le frecce oppure i tasti laterali del mouse.\nPer avviare la partita premere invio oppure il tasto centrale del mouse. \nObiettivo:\nColpire tutti i quadrati, quindi distruggerli,\n per vincere, cercando di non far cadere la palla sotto il livello della barra.");
        if(NButton.getActionListeners().length==0)
        NButton.addActionListener(e -> F());
        if(DButton.getActionListeners().length==0)
            DButton.addActionListener(e -> M());
        if(IButton.getActionListeners().length==0)
            IButton.addActionListener(e -> D());

    }

    private void Jframe()
    {

SG=new JFrame("Brick Out Game");
        Blocco2 panel = new Blocco2();
        SG.getContentPane().add(panel);
        SG.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        SG.setVisible(true);
        SG.setBounds(-10,0,950,875);
        SG.setResizable(false);
        SG.setBackground(new Color(255, 255, 255));
        try {
            INIZ.INI.dispose();
            Finale.INI.dispose();
        }catch (NullPointerException ignored){}
    }

    private void F()
    {
        Diff="1";
        Jframe();
        try {
            USI.INI.dispose();
        }catch (NullPointerException ignored){}
    }
    private void M()
    {
        Diff="2";
        Jframe();
        try {
            USI.INI.dispose();
        }catch (NullPointerException ignored){}
    }
    private void D()
    {
        Diff="3";
        Jframe();
        try {
            USI.INI.dispose();
        }catch (NullPointerException ignored){}

    }
    static String getDiff()
    {
        return Diff;

    }

}
