import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Timer extends JPanel
{
    private JLabel NT;
    private JLabel NT1;
    private JLabel PN;
    private JLabel PN1;
    private JLabel BD;
    private JLabel BD1;
    private JLabel TT;
    private JLabel TT1;
    private JPanel PAN;
    private JLabel DIFF;
    private JLabel DIF1;
    private JLabel SC;
    private JLabel SC1;
    private JLabel BR;
    private JLabel BR1;
    private JLabel SC2;
    private JLabel PN2;
    private JLabel BD2;
    private String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    private int Tp, l;
    static  int pun,Bd,TimeS=0,TimeM=0,Lo=0;
    static int NewPun1=0, NewBloc1=0,NewScherm1=0,NewPun2=0, NewBloc2=0,NewScherm2=0,NewPun3=0, NewBloc3=0,NewScherm3=0;
    private Color ColN=new Color(27, 187, 44);
    private Color ColD=new Color(187, 179, 45);
    private Color ColI=new Color(187, 15, 17);
    private File filemo;
    Timer() {
        super();
        add(PAN);
        NT.setVisible(true);
        PN.setVisible(true);
        BD.setVisible(true);
        TT.setVisible(true);
        SC.setVisible(true);
        BR.setVisible(true);
        String patch = "src/Records.txt";

        PAN.setVisible(true);
        Loop();
        filemo = new File(patch);
        FileReader l;
        try {
            if (!filemo.exists()) {
                if (filemo.createNewFile()) {
                    NewPun1 = 0;
                    NewBloc1 = 0;
                    NewScherm1 = 1;
                    NewPun2 = 0;
                    NewBloc2 = 0;
                    NewScherm2 = 1;
                    NewPun3 = 0;
                    NewBloc3 = 0;
                    NewScherm3 = 1;
                }
            } else {
                try {
                l = new FileReader(filemo);
                BufferedReader le;
                le = new BufferedReader(l);
                s1 = le.readLine();
                s2 = le.readLine();
                s3 = le.readLine();
                s4 = le.readLine();
                s5 = le.readLine();
                s6 = le.readLine();
                s7 = le.readLine();
                s8 = le.readLine();
                s9 = le.readLine();
    try {
        NewPun1 = Integer.parseInt(s1);
    }catch (NumberFormatException exc)
    {
        NewPun1 = 0;
        s1="0";
    }
    try{NewBloc1 = Integer.parseInt(s2);}catch (NumberFormatException exc){NewBloc1 = 0;
        s2="0";}
    try{NewScherm1 = Integer.parseInt(s3);}catch (NumberFormatException exc){NewScherm1 = 0;
        s3="1";}
    try{NewPun2 = Integer.parseInt(s4);}catch (NumberFormatException exc){NewPun2 = 0;
        s4="0";}
    try{NewBloc2 = Integer.parseInt(s5);}catch (NumberFormatException exc){NewBloc2 = 0;
        s5="0";}
    try{NewScherm2 = Integer.parseInt(s6);}catch (NumberFormatException exc){NewScherm2 = 0;
        s6="1";}
    try{NewPun3 = Integer.parseInt(s7);}catch (NumberFormatException exc){NewPun3 = 0;
        s7="0";}
    try{NewBloc3 = Integer.parseInt(s8);}catch (NumberFormatException exc){NewBloc3 = 0;
        s8="0";}
    try{NewScherm3 = Integer.parseInt(s9);}catch (NumberFormatException exc){NewScherm3 = 0;
        s9="1";}
}catch (NullPointerException ignored) {

}
}

            } catch (IOException ex) {
            PrintWriter mo = null;
            try {
                mo = new PrintWriter(filemo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                assert mo != null;
                mo.println(0);
            }
            ex.printStackTrace();
        }
    }


private void TimeLoop()
{
    new Thread(() -> {
        while (Blocco2.L!=1)
        {
            Time();
            try {
                Thread.sleep(1250);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }).start();
}
private void Loop()
{
    new Thread(() -> {
        while (true)
        {
        if(Blocco2.Tp!=0&&Blocco2.L!=1) {
            try {
                update();
                TT1.setText(TimeM+" : "+TimeS);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if ((Blocco2.L != 1) && (Tp != 0) && (Lo != 1) && (Blocco2.p != 0)) {
                Lo = 1;
                TimeLoop();
            }
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}).start();
}
void update() throws FileNotFoundException {
    NT1.setText(String.valueOf(Blocco2.Tp));
    PN1.setText(String.valueOf(Blocco2.Bd));
    BD1.setText(String.valueOf(Blocco2.pun));
    SC1.setText(String.valueOf(Blocco2.Sc));
    BR1.setText(Blocco2.Bloc+" / "+Blocco2.bl);
    if(l!=1) {
        switch (Blocco2.difficlt) {
            case "Normale":
                DIF1.setForeground(ColN);
                DIFF.setForeground(ColN);
                if (Blocco2.Bd < NewPun1) {
                    PN2.setText("    " + "Record: " + NewPun1);

                } else if (Blocco2.Bd == NewPun1) {
                    PN2.setText("    " + "Record raggiunto: " + Blocco2.Bd);
                } else {
                    PN2.setText("    " + "Record Superato: " + Blocco2.Bd);
                }
                if (Blocco2.pun < NewBloc1) {
                    BD2.setText("    " + "Record: " + NewBloc1);
                } else if (Blocco2.pun == NewBloc1) {
                    BD2.setText("    " + "Record raggiunto: " + Blocco2.pun);
                } else {
                    BD2.setText("    " + "Record Superato: " + Blocco2.pun);
                }
                if (Blocco2.Sc < NewScherm1) {
                    SC2.setText("    " + "Record: " + NewScherm1);
                } else if (Blocco2.Sc == NewScherm1) {
                    SC2.setText("    " + "Record raggiunto: " + Blocco2.Sc);
                } else {
                    SC2.setText("    " + "Record Superato: " + Blocco2.Sc);
                }
                break;
            case "Difficile":
                DIFF.setForeground(ColD);
                DIF1.setForeground(ColD);

                if (Blocco2.Bd < NewPun2) {
                    PN2.setText("    " + "Record: " + NewPun2);
                } else if (Blocco2.Bd == NewPun2) {
                    PN2.setText("    " + "Record raggiunto: " + Blocco2.Bd);
                } else {
                    PN2.setText("    " + "Record Superato: " + Blocco2.Bd);
                }
                if (Blocco2.pun < NewBloc2) {
                    BD2.setText("    " + "Record: " + NewBloc2);
                } else if (Blocco2.pun == NewBloc2) {
                    BD2.setText("    " + "Record raggiunto: " + Blocco2.pun);
                } else {
                    BD2.setText("    " + "Record Superato: " + Blocco2.pun);
                }
                if (Blocco2.Sc < NewScherm2) {
                    SC2.setText("    " + "Record: " + NewScherm2);
                } else if (Blocco2.Sc == NewScherm2) {
                    SC2.setText("    " + "Record raggiunto: " + Blocco2.Sc);
                } else {
                    SC2.setText("    " + "Record Superato: " + Blocco2.Sc);
                }
                break;
            case "Impossibile":
                DIF1.setForeground(ColI);
                DIFF.setForeground(ColI);
                if (Blocco2.Bd < NewPun3) {
                    PN2.setText("    " + "Record: " + NewPun3);
                } else if (Blocco2.Bd == NewPun3) {
                    PN2.setText("    " + "Record raggiunto: " + Blocco2.Bd);
                } else {
                    PN2.setText("    " + "Record Superato: " + Blocco2.Bd);
                }
                if (Blocco2.pun < NewBloc3) {
                    BD2.setText("    " + "Record: " + NewBloc3);
                } else if (Blocco2.pun == NewBloc3) {
                    BD2.setText("    " + "Record raggiunto: " + Blocco2.pun);
                } else {
                    BD2.setText("    " + "Record Superato: " + Blocco2.pun);
                }
                if (Blocco2.Sc < NewScherm3) {
                    SC2.setText("    " + "Record: " + NewScherm3);
                } else if (Blocco2.Sc == NewScherm3) {
                    SC2.setText("    " + "Record raggiunto: " + Blocco2.Sc);
                } else {
                    SC2.setText("    " + "Record Superato: " + Blocco2.Sc);
                }
                break;

        }
    }

    DIF1.setText(Blocco2.difficlt);
    l = Blocco2.L;
    Bd=Blocco2.pun;
    pun=Blocco2.Bd;
    String Diff=Blocco2.difficlt;
    if(l ==1) {
        PrintWriter mo = new PrintWriter(filemo);
        if(Diff.equals("Normale")) {
            if (pun >  NewPun1) {

                mo.println(pun);
                s1= String.valueOf(pun);
            } else {
                mo.println(NewPun1);
                s1= String.valueOf(NewPun1);
            }
            if (Bd >NewBloc1) {
                mo.println(Bd);
                s2= String.valueOf(Bd);
            } else {
                mo.println(NewBloc1);
                s2= String.valueOf(NewBloc1);
            }

            if (Blocco2.Sc > NewScherm1) {
                mo.println(Blocco2.Sc);
                mo.println(s4);
                mo.println(s5);
                mo.println(s6);
                mo.println(s7);
                mo.println(s8);
                mo.println(s9);
                s3= String.valueOf(Blocco2.Sc);
            } else {
                mo.println(NewScherm1);
                mo.println(s4);
                mo.println(s5);
                mo.println(s6);
                mo.println(s7);
                mo.println(s8);
                mo.println(s9);
                s3= String.valueOf(NewScherm1);
            }
            mo.flush();
            mo.close();

        }
        if(Diff.equals("Difficile")) {
            if (pun > NewPun2) {
                mo.println(s1);
                mo.println(s2);
                mo.println(s3);
                mo.println(pun);
                s4= String.valueOf(pun);
            } else {
                mo.println(s1);
                mo.println(s2);
                mo.println(s3);
                mo.println(NewPun2);
                s4= String.valueOf(NewPun2);
            }
            if (Bd > NewBloc2) {
                mo.println(Bd);
                s5=String.valueOf(Bd);
            } else {
                mo.println(NewBloc2);
                s5=String.valueOf(NewBloc2);
            }

            if (Blocco2.Sc > NewScherm2) {
                mo.println(Blocco2.Sc);
                mo.println(s7);
                mo.println(s8);
                mo.println(s9);
                s6=String.valueOf(Blocco2.Sc);
            } else {
                mo.println(NewScherm2);
                mo.println(s7);
                mo.println(s8);
                mo.println(s9);
                s6=String.valueOf(NewScherm2);
            }
            mo.flush();
            mo.close();
        }
        if(Diff.equals("Impossibile")) {
            if (pun > NewPun3) {
                mo.println(s1);
                mo.println(s2);
                mo.println(s3);
                mo.println(s4);
                mo.println(s5);
                mo.println(s6);
                mo.println(pun);
                s7= String.valueOf(pun);
            } else {
                mo.println(s1);
                mo.println(s2);
                mo.println(s3);
                mo.println(s4);
                mo.println(s5);
                mo.println(s6);
                mo.println(NewPun3);
                s7= String.valueOf(NewPun3);
            }
            if (Bd > NewBloc3) {
                mo.println(Bd);
                s8=String.valueOf(Bd);
            } else {
                mo.println(NewBloc3);
                s8=String.valueOf(NewBloc3);
            }

            if (Blocco2.Sc > NewScherm3) {
                mo.println(Blocco2.Sc);
                s9=String.valueOf(Blocco2.Sc);
            } else {
                mo.println(NewScherm3);
                s9=String.valueOf(NewScherm3);
            }
            mo.flush();
            mo.close();
        }
    }
    Tp=Blocco2.Tp;

}
private void Time()
{
    TimeS++;
    if(TimeS==60)
    {

        TimeM++;
        TimeS=0;
    }
}


}
