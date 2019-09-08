import javax.swing.*;
import java.awt.*;


public class Records extends JPanel {
    private JLabel DIFF;
    private JLabel PUNTEGGIO;
    private JLabel BLOCCHI;
    private JLabel SCHERMATA;
    private JLabel VALUTA3;
    private JLabel VALUTA2;
    private JLabel VALUTA1;
    private JPanel Panello;
    private JLabel DIFF1;
    private Color ColN=new Color(27, 187, 44);
    private Color ColD=new Color(187, 179, 45);
    private Color ColI=new Color(187, 15, 17);

    Records()
{
    super();
    add(Panello);
    reset();
    new Thread(() -> {
        while (true)
        {
                try {
                    loop();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}).start();
}
private void reset()
{

    DIFF.setVisible(true);
    PUNTEGGIO.setVisible(true);
    BLOCCHI.setVisible(true);
    SCHERMATA.setVisible(true);
    VALUTA1.setVisible(true);
    VALUTA2.setVisible(true);
    VALUTA3.setVisible(true);
    Panello.setVisible(true);
    add(Panello);
}
private void loop()
{
    DIFF1.setText(Blocco2.difficlt);
    DIFF.setForeground(ColN);
    DIFF1.setForeground(ColN);
    switch (Blocco2.difficlt) {
        case "Normale":
            DIFF.setForeground(ColN);
            DIFF1.setForeground(ColN);
            if(Timer.NewPun1-Blocco2.Bd<=0)
            {
                VALUTA1.setText("Record Raggiunto..  -> "+Blocco2.Bd);
            }else
            {
                VALUTA1.setText(Timer.NewPun1 - Blocco2.Bd + " / " + Timer.NewPun1);
            }
            if(Timer.NewBloc1-Blocco2.pun<=0)
            {
                VALUTA2.setText("Record Raggiunto..  -> "+Blocco2.pun);
            }else
            {
                VALUTA2.setText(Timer.NewBloc1-Blocco2.pun+" / "+Timer.NewBloc1);
            }
            if(Timer.NewScherm1-Blocco2.Sc<=0)
            {
                VALUTA3.setText("Record Raggiunto..  -> "+Blocco2.Sc);
            }else
            {
                VALUTA3.setText(Timer.NewScherm1-Blocco2.Sc+" / "+Timer.NewScherm1);
            }
            break;
        case "Difficile":
            DIFF.setForeground(ColD);
            DIFF1.setForeground(ColD);
            if(Timer.NewPun2-Blocco2.Bd<=0)
            {
                VALUTA1.setText("Record Raggiunto..  -> "+Blocco2.Bd);
            }else
            {
                VALUTA1.setText(Timer.NewPun2 - Blocco2.Bd + " / " + Timer.NewPun2);
            }
            if(Timer.NewBloc2-Blocco2.pun<=0)
            {
                VALUTA2.setText("Record Raggiunto..  -> "+Blocco2.pun);
            }else
            {
                VALUTA2.setText(Timer.NewBloc2-Blocco2.pun+" / "+Timer.NewBloc2);
            }
            if(Timer.NewScherm2-Blocco2.Sc<=0)
            {
                VALUTA3.setText("Record Raggiunto..  -> "+Blocco2.Sc);
            }else
            {
                VALUTA3.setText(Timer.NewScherm2-Blocco2.Sc+" / "+Timer.NewScherm2);
            }
               break;
        case "Impossibile":
            DIFF.setForeground(ColI);
            DIFF1.setForeground(ColI);
            if(Timer.NewPun3-Blocco2.Bd<=0)
            {
                VALUTA1.setText("Record Raggiunto..  -> "+Blocco2.Bd);
            }else
            {
                VALUTA1.setText(Timer.NewPun3 - Blocco2.Bd + " / " + Timer.NewPun3);
            }
            if(Timer.NewBloc3-Blocco2.pun<=0)
            {
                VALUTA2.setText("Record Raggiunto..  -> "+Blocco2.pun);
            }else
            {
                VALUTA2.setText(Timer.NewBloc3-Blocco2.pun+" / "+Timer.NewBloc3);
            }
            if(Timer.NewScherm3-Blocco2.Sc<=0)
            {
                VALUTA3.setText("Record Raggiunto..  -> "+Blocco2.Sc);
            }else
            {
                VALUTA3.setText(Timer.NewScherm3-Blocco2.Sc+" / "+Timer.NewScherm3);
            }
               break;
                }
            }
}
