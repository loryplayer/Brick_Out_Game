
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class USI extends JPanel implements KeyListener
{

    private JButton esciButton;
    private JButton riprendiButton;
    private JPanel PAN;
    static JFrame INI;

    USI()
    {
        super();
        add(PAN);
        esciButton.setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        riprendiButton.setVisible(true);
        esciButton.addActionListener(e -> ES());
        riprendiButton.addActionListener(e -> RIP());
    }
    private void ES()
    {
        Blocco2.Es=0;
        Blocco2.L=0;
        Blocco2.p=0;
        Blocco2.Tp=0;
        Blocco2.Bd=0;
        Blocco2.pun=0;
        Blocco2.fuori=0;
        Blocco2.F=1;
        Timer.Lo=0;
        INI=new JFrame("Seleziona Difficoltà");
        START ST = new START();
        INI.getContentPane().add(ST);
        INI.setVisible(true);
        INI.setSize(800,400);
        INI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        INI.setResizable(false);
        try {

            START.SG.dispose();
            Blocco2.TIM.dispose();
            Blocco2.TA.dispose();
            Finale.SG.dispose();
            Blocco2.RECO.dispose();
            Blocco2.US.dispose();

        }catch (NullPointerException ignored){}
    } void RIP()
    {
        Blocco2.Es=0;
        Blocco2.L=0;
        Blocco2.p=0;
        Blocco2.fuori=0;
        try {
            Blocco2.US.dispose();
        }catch (NullPointerException ignored){}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            ControlloTasti.escpremuto=true;
            RIP();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            ControlloTasti.escpremuto=false;

        }
    }
}
