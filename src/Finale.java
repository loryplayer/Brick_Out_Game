import javax.swing.*;
import java.awt.*;

public class Finale extends JPanel {


    private JPanel PAN;
    private JButton riavviaButton;
    private JButton esciButton;
    private JLabel FI;
    private JLabel PN;
    private JLabel PN1;
    private JLabel BD;
    private JLabel BD1;
    private JLabel SC;
    private JLabel SC1;
    private JTextArea CON;
    static JFrame SG;
    static JFrame INI;
    static int R=0;
    Finale()
    {
    super();
    add(PAN);
    setVisible(true);
    PN.setVisible(true);
    BD.setVisible(true);
    SC.setVisible(true);
    FI.setVisible(false);
    riavviaButton.addActionListener(e -> RI());
    esciButton.addActionListener(e -> US());
    Blocco2.TIM.dispose();
        int punteggio = Timer.pun;
        int blocco = Timer.Bd;
        int schermata = Blocco2.Sc;
        int ncon = 1 + (int) (Math.random() * 4);
        Blocco2.TA.dispose();
        Blocco2.RECO.dispose();
        START.SG.dispose();
     if(ncon ==1)
     {
         CON.setText("Consiglio:\nUtilizza contemporaneamente i tasti 'A' e fraccia sinistra per muoverti più velocemente verso sinistra.\n Allo stesso modo 'D' e freccia destra per andare più velocemtente verso destra");
     }else if (ncon ==2)
     {
         CON.setText("Consiglio:\nPiù aumenti di schermata più la velocità della palla e la generazione dei blocchi aumentano");
     }else if(ncon ==3)
     {
         CON.setText("Consiglio:\nI blocchi grigi, i più resistenti, quando vengono colpiti dalla palla, essa si muoverà in maniera diversa rispetto agli altri blocchi, tranne nell' ultima fase.\n Cerca di precederla");
     }else if(ncon ==4)
     {
         CON.setText("Consiglio:\nQuando la palla tocca la barra, in base alla difficoltà, aumenta la vellocità della palla");
     }
        FI.setVisible(true);
        int fin = 0;
        switch (Blocco2.difficlt) {
            case "Normale":
                if (punteggio > Timer.NewPun1) {

                    fin++;
                    PN1.setText("Record :  " + punteggio + "   +" + (punteggio - Timer.NewPun1) + " Record Prec :   " + Timer.NewPun1);
                } else {
                    PN1.setText(punteggio + "    -" + (Timer.NewPun1 - punteggio) + "  Record :  " + Timer.NewPun1);
                }
                if (blocco > Timer.NewBloc1) {
                    fin++;
                    BD1.setText("Record :  " + blocco + "   +" + (blocco - Timer.NewBloc1) + " Record Prec :   " + Timer.NewBloc1);
                } else {
                    BD1.setText(blocco + "    -" + (Timer.NewBloc1 - blocco) + "  Record :  " + Timer.NewBloc1);
                }
                if (schermata > Timer.NewScherm1) {
                    fin++;
                    SC1.setText("Record :  " + schermata + "   +" + (schermata - Timer.NewScherm1) + " Record Prec :   " + Timer.NewScherm1);
                } else if (schermata == Timer.NewScherm1) {
                    SC1.setText(schermata + "    +" + (Timer.NewScherm1 - schermata) + "  Uguale all'ultimo record :  " + Timer.NewScherm1);
                } else {
                    SC1.setText(schermata + "    -" + (Timer.NewScherm1 - schermata) + "  Record :  " + Timer.NewScherm1);
                }
                break;
            case "Difficile":
                if (punteggio > Timer.NewPun2) {
                    fin++;
                    PN1.setText("Record :  " + punteggio + "   +" + (punteggio - Timer.NewPun2) + " Record Prec :   " + Timer.NewPun2);
                } else {
                    PN1.setText(punteggio + "    -" + (Timer.NewPun2 - punteggio) + "  Record :  " + Timer.NewPun2);
                }
                if (blocco > Timer.NewBloc2) {
                    fin++;
                    BD1.setText("Record :  " + blocco + "   +" + (blocco - Timer.NewBloc2) + " Record Prec :   " + Timer.NewBloc2);
                } else {
                    BD1.setText(blocco + "    -" + (Timer.NewBloc2 - blocco) + "  Record :  " + Timer.NewBloc2);
                }
                if (schermata > Timer.NewScherm2) {
                    fin++;
                    SC1.setText("Record :  " + schermata + "   +" + (schermata - Timer.NewScherm2) + " Record Prec :   " + Timer.NewScherm2);
                } else if (schermata == Timer.NewScherm2) {
                    SC1.setText(schermata + "    +" + (Timer.NewScherm2 - schermata) + "  Uguale all'ultimo record :  " + Timer.NewScherm2);
                } else {
                    SC1.setText(schermata + "    -" + (Timer.NewScherm2 - schermata) + "  Record :  " + Timer.NewScherm2);
                }
                break;
            case "Impossibile":
                if (punteggio > Timer.NewPun3) {
                    fin++;
                    PN1.setText("Record :  " + punteggio + "   +" + (punteggio - Timer.NewPun3) + " Record Prec :   " + Timer.NewPun3);
                } else {
                    PN1.setText(punteggio + "    -" + (Timer.NewPun3 - punteggio) + "  Record :  " + Timer.NewPun3);
                }
                if (blocco > Timer.NewBloc3) {
                    fin++;
                    BD1.setText("Record :  " + blocco + "   +" + (blocco - Timer.NewBloc3) + " Record Prec :   " + Timer.NewBloc3);
                } else {
                    BD1.setText(blocco + "    -" + (Timer.NewBloc3 - blocco) + "  Record :  " + Timer.NewBloc3);
                }
                if (schermata > Timer.NewScherm3) {
                    fin++;
                    SC1.setText("Record :  " + schermata + "   +" + (schermata - Timer.NewScherm3) + " Record Prec :   " + Timer.NewScherm3);
                } else if (schermata == Timer.NewScherm3) {
                    SC1.setText(schermata + "    +" + (Timer.NewScherm3 - schermata) + "  Uguale all'ultimo record :  " + Timer.NewScherm3);
                } else {
                    SC1.setText(schermata + "    -" + (Timer.NewScherm3 - schermata) + "  Record :  " + Timer.NewScherm3);
                }
                break;

        }
        if (fin != 0) {
            FI.setText("Bene hai migliorato " + fin + " record!!");
        } else {
            FI.setText("Preccato, non sei riuscito a battere i tuoi Record:");

        }

    }

    private void US()
    {
        Blocco2.p=0;
        Blocco2.L=0;
        Blocco2.Tp=0;
        Blocco2.Bd=0;
        Blocco2.pun=0;
        Blocco2.Sc=1;
        Timer.TimeS=0;
        Timer.TimeM=0;Blocco2.Fin=1;
        Blocco2.F=1;
        Timer.Lo=0;
        START.SG.dispose();
        INI=new JFrame("Seleziona Difficoltà");
        START ST = new START();
        INI.getContentPane().add(ST);
        INI.setVisible(true);
        INI.setSize(800,400);
        INI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        INI.setResizable(false);
        Blocco2.TIM.dispose();
        Blocco2.FI.dispose();



    }
    private void RI()
    {
        R=1;
        Timer.TimeS=0;
        Timer.TimeM=0;
        Blocco2.Tp=0;
        Blocco2.Bd=0;
        Blocco2.pun=0;
        Blocco2.p=0;
        Blocco2.L=0;
        Blocco2.Sc=1;
        Blocco2.Fin=1;
        Blocco2.F=1;
        Timer.Lo=0;
        START.SG.dispose();
        SG=new JFrame("Brick Out 1Game");
        Blocco2 BL = new Blocco2();
        SG.setBounds(-10,0,950,875);
        SG.getContentPane().add(BL);
        SG.setVisible(true);
        SG.setResizable(false);
        SG.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        SG.setBackground(new Color(255, 255, 255));
        Blocco2.FI.dispose();



}
}
