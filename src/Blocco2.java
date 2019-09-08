import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.ArrayList;

public class
Blocco2 extends JPanel implements KeyListener, MouseListener {
    private ArrayList<Blocco> blocchi;
    private ArrayList<Blocco> blocchiR;
    private ArrayList<Blocco> Palla;
    private Blocco palla,pallaP;
    private Blocco barra;
    private Blocco barrapz1,barrapz2,barrapz3,barrapz4;
    private String Diff=START.getDiff();
    static JFrame US;
    static JFrame FI;
    static JFrame TA;
    static JFrame RECO;
    private Timer TIMER;
    private USI USC;
    static  JFrame TIM;
    private int b=10,R=0;
    static int L=0,p=0,pun=0,Tp=0,Bd=0,Sc=1,Bloc=0,bl,Es=0,Fin=1,fuori=0,F=1,escape;
    static String difficlt;
    private JPanel PAN;

    Blocco2() {

    super();
    add(PAN);
    reset();
    timer();
    records();
        try {
            TIMER.update();
            Tasti();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
}
public  void paintComponent(Graphics g){
    barra.draw(g,this);
    barrapz1.draw(g,this);
    barrapz2.draw(g,this);
    barrapz3.draw(g,this);
    barrapz4.draw(g,this);
    pallaP.draw(g,this);
    blocchi.forEach(blocco -> blocco.draw(g,this));
    blocchiR.forEach(blocco -> blocco.draw(g,this));
    palla.draw(g,this);
    setOpaque(false);
}


    private void update() {
        Palla.forEach(PallaUp -> {
            PallaUp.x += PallaUp.movX;
            PallaUp.y += PallaUp.movY;
        });
        if (Es != 1) {
            switch (Diff) {
                case "1":
                    difficlt = "Normale";
                    Palla.forEach(bloccoP1 -> {
                        if (bloccoP1.intersects(barra)) {
                            bloccoP1.movY += 0.2;
                        } else if (bloccoP1.intersects(barrapz3) || bloccoP1.intersects(barrapz4)) {
                            bloccoP1.movY += 0.5;
                            bloccoP1.movY *= -1;
                        } else if (bloccoP1.intersects(barrapz1) || bloccoP1.intersects(barrapz2)) {
                            bloccoP1.movY += 0.3;
                            bloccoP1.movY *= -1;
                        }
                    });
                    break;
                case "2":
                    difficlt = "Difficile";
                    Palla.forEach(bloccoP2 -> {
                        if (bloccoP2.intersects(barra)) {
                            bloccoP2.movY += 0.4;
                        } else if (bloccoP2.intersects(barrapz3) || bloccoP2.intersects(barrapz4)) {
                            bloccoP2.movY += 0.8;
                            bloccoP2.movY *= -1;
                        } else if (bloccoP2.intersects(barrapz1) || bloccoP2.intersects(barrapz2)) {
                            bloccoP2.movY += 1;
                            bloccoP2.movY *= -1;
                        }
                    });
                    break;
                case "3":
                    difficlt = "Impossibile";
                    Palla.forEach(bloccoP3 -> {
                        {
                            if (bloccoP3.intersects(barra)) {
                                bloccoP3.movY += 0.5;
                            } else if (bloccoP3.intersects(barrapz3) || bloccoP3.intersects(barrapz4)) {
                                bloccoP3.movY += 1;
                                bloccoP3.movY *= -1;
                            } else if (bloccoP3.intersects(barrapz1) || bloccoP3.intersects(barrapz2)) {
                                bloccoP3.movY += 2;
                                bloccoP3.movY *= -1;
                            }
                        }
                    });
                    break;
            }
            if (palla.intersects(pallaP)) {
                palla.movY *= -1;
            }
            if ((palla.intersects(pallaP)) && !pallaP.distrutto && R == 0) {
                R = 1;
                F = 2;
                Palla.add(pallaP);
                palla.movY *= -1;
            }
            Palla.forEach(PallaIn -> {
                if ((PallaIn.x) > (getWidth() - 30) || PallaIn.x < 10) {
                    PallaIn.movX *= -1;
                }
                if (PallaIn.y < 0 || PallaIn.intersects(barra)) {
                    PallaIn.movY *= -1;
                }
            });
            Bloc = (blocchi.size() + blocchiR.size()) - pun;

            if (pallaP.y > 900) {

                if (F == 3&&Fin==2) {
                    L = 1;
                    FINALE();
                }
            }
            if (palla.y > 900) {
                if (F == 1&&Fin==1) {
                    Fin=0;
                    L = 1;
                    FINALE();
                } else if (F == 2&&Fin==1) {
                    F = 3;
                    Fin=2;
                }
                Palla.remove(palla);
            }

            if (pun == (blocchi.size() + blocchiR.size())) {
                p = 1;
                R = 0;
                Sc++;
                b = b + 1;
                F = 1;
                Palla.clear();
                Blocchi();
            }
            Palla.forEach(pallaDis -> {
                blocchi.forEach(blocco -> {

                    if (pallaDis.intersects(blocco) && !blocco.distrutto) {
                        blocco.distrutto = true;
                        Bd += 5;
                        pun++;
                        pallaDis.movY *= -1;
                    }
                });
                blocchiR.forEach(blocco1 -> {
                    if (pallaDis.intersects(blocco1) && blocco1.resistente && !blocco1.distrutto) {
                        blocco1.resistente = false;
                        pallaDis.movY *= -1;
                        pallaDis.movX *= -1;

                    } else if (pallaDis.intersects(blocco1) && !blocco1.resistente && blocco1.resistente1 && !blocco1.distrutto) {
                        blocco1.resistente1 = false;
                        pallaDis.movY *= -1;
                        pallaDis.movX *= -1;

                    } else if (pallaDis.intersects(blocco1) && !blocco1.resistente && !blocco1.resistente1 && blocco1.resistente2 && !blocco1.distrutto) {
                        blocco1.resistente2 = false;
                        pallaDis.movY *= -1;
                        pallaDis.movX *= -1;

                    } else if (pallaDis.intersects(blocco1) && !blocco1.distrutto && !blocco1.resistente && !blocco1.resistente1 && !blocco1.resistente2) {
                        blocco1.distrutto = true;
                        blocco1.resistente = true;
                        blocco1.resistente1 = true;
                        Bd += 15;
                        pun++;
                        pallaDis.movY *= -1;
                    }
                });
            });
            repaint();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(L==1)
        {
            try {
                Thread.sleep(100);
            }catch (InterruptedException ignored){}

        }
        switch (Diff) {

            case "1":
                if (e.getKeyCode() == KeyEvent.VK_ENTER && (p != 1)) {
                    ControlloTasti.inviopremuto=true;
                    Tp++;
                    p = 1;
                    new Thread(() -> {
                        while ((L != 1)) {

                            update();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }).start();

                }if(L!=1) {
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (e.getKeyCode() != KeyEvent.VK_LEFT) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;
                    ControlloTasti.frecciaDpremuto = true;
                    avanti(30);

                }
                if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (e.getKeyCode() != KeyEvent.VK_RIGHT) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.frecciaSpremuto = true;
                    indietro(30);

                }
                if ((e.getKeyCode() == KeyEvent.VK_D) && (e.getKeyCode() != KeyEvent.VK_A) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;
                    ControlloTasti.Dpremuto = true;
                    avanti(30);
                } else if ((e.getKeyCode() == KeyEvent.VK_A) && (e.getKeyCode() != KeyEvent.VK_D) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.Apremuto = true;
                    indietro(30);
                }
                break;
            }
            case "2":
                if (e.getKeyCode() == KeyEvent.VK_ENTER && (p != 1)) {
                    ControlloTasti.inviopremuto=true;
                    Tp++;
                    p = 1;
                    new Thread(() -> {
                        while ((L != 1)) {


                            update();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }).start();

                }
                if(L!=1) {
                    if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (e.getKeyCode() != KeyEvent.VK_LEFT) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                        Tp++;

                        ControlloTasti.frecciaDpremuto = true;
                        avanti(32);

                    }
                    if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (e.getKeyCode() != KeyEvent.VK_RIGHT) && barra.x > 31 && p == 1) {
                        Tp++;
                        ControlloTasti.frecciaSpremuto = true;
                        indietro(32);

                    }
                    if ((e.getKeyCode() == KeyEvent.VK_D) && (e.getKeyCode() != KeyEvent.VK_A) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                        Tp++;
                        ControlloTasti.Dpremuto = true;
                        avanti(32);
                    } else if ((e.getKeyCode() == KeyEvent.VK_A) && (e.getKeyCode() != KeyEvent.VK_D) && barra.x > 31 && p == 1) {
                        Tp++;
                        ControlloTasti.Apremuto = true;
                        indietro(32);
                    }
                    break;
                }
            case "3":
                if (e.getKeyCode() == KeyEvent.VK_ENTER && (p != 1)) {
                    ControlloTasti.inviopremuto=true;
                    Tp++;
                    p = 1;
                    new Thread(() -> {
                        while ((L != 1)) {

                            update();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }).start();

                }if(L!=1) {
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (e.getKeyCode() != KeyEvent.VK_LEFT) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;

                    ControlloTasti.frecciaDpremuto = true;
                    avanti(35);

                }
                if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (e.getKeyCode() != KeyEvent.VK_RIGHT) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.frecciaSpremuto = true;
                    indietro(35);

                }
                if ((e.getKeyCode() == KeyEvent.VK_D) && (e.getKeyCode() != KeyEvent.VK_A) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;
                    ControlloTasti.Dpremuto = true;
                    avanti(35);
                } else if ((e.getKeyCode() == KeyEvent.VK_A) && (e.getKeyCode() != KeyEvent.VK_D) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.Apremuto = true;
                    indietro(35);
                }
                break;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE&&Es!=1&&L!=1) {
            escape=1;
            ControlloTasti.escpremuto=true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Uscita();

        }




    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A)
        {
            ControlloTasti.Apremuto=false;
        }else if(e.getKeyCode()==KeyEvent.VK_D)
        {
            ControlloTasti.Dpremuto=false;
        }if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            ControlloTasti.frecciaDpremuto=false;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            ControlloTasti.frecciaSpremuto=false;
        }if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            ControlloTasti.inviopremuto=false;
        }if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            ControlloTasti.escpremuto=false;
        }
    }
    private void reset()
    {
        blocchi=new ArrayList<>();
        blocchiR=new ArrayList<>();
        Palla=new ArrayList<>();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        Blocchi();
        Fin=1;
        F=1;

    }
    private void Blocchi() {

        barra=new Blocco(400,750,138,10,"barra.png");
        barrapz1=new Blocco(400,750,7,10,"PZBarra1.png");
        barrapz2=new Blocco(538,750,7,10,"PZBarra1.png");
        barrapz3=new Blocco(376,750,24,10,"PZBarra2.png");
        barrapz4=new Blocco(545,750,24,10,"PZBarra2.png");
        palla =new Blocco(469,660,20,20,"pallaPrinc.png");
        pallaP=new Blocco((int) (Math.random() * 450),30+(int) (Math.random() * 150),20,20,"palla1.png");
        palla.movY=3;
        pallaP.movY=3;

        int RAN1 = 20 + (int) (Math.random() * 30);
        int RAN2 = 20 + (int) (Math.random() * 30);
        int RAN3 = 20 + (int) (Math.random() * 30);
        int RAN4 = 20 + (int) (Math.random() * 30);
        int RAN5 = 25 + (int) (Math.random() * 40);
        if(Palla.size()==0) {
            Palla.add(palla);
        }
        for (int i = 0; i < b; i++)
            blocchi.add(new Blocco((int) (50+Math.random() * 850),50+ (int) (Math.random() * 500), RAN1, RAN1, "BloccoB.png"));
        for (int i = 0; i <b; i++)
            blocchi.add(new Blocco((int) (50+Math.random() * 850),50+ (int) (Math.random() * 500), RAN2, RAN2, "BloccoR.png"));
        for (int i = 0; i < b; i++)
            blocchi.add(new Blocco((int) (50+Math.random() * 850),50+ (int) (Math.random() * 500), RAN3, RAN3, "BloccoV.png"));
        for (int i = 0; i <b ; i++)
            blocchi.add(new Blocco((int) (50+Math.random() * 850),50+ (int) (Math.random() * 500), RAN4, RAN4, "BloccoG.png"));
        for (int i = 0; i < b; i++) {
            blocchiR.add(new Blocco((int) (50+Math.random() * 850),50+ (int) (Math.random() * 500), RAN5, RAN5, "BloccoRe1.png"));
            bl=blocchi.size()+blocchiR.size()-pun;
            update();
        }
    }

    private void timer()  {
        TIM=new JFrame("Informazioni Partita");
        TIMER=new Timer();
        TIM.add(TIMER);
        TIM.setVisible(true);
        TIM.setResizable(false);
        TIM.setBounds(925,290,625,300);
        TIM.setForeground(new Color(61,100,110));
        TIM.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Diff) {

            case "1":

                if ((e.getButton()==MouseEvent.BUTTON3)&&barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;

                    ControlloTasti.mouseDpremuto=true;
                        avanti(40);

                }
                if ((e.getButton()==MouseEvent.BUTTON1) && barra.x >31 && p == 1) {
                    Tp++;
                    ControlloTasti.mouseSpremuto=true;
                    indietro(40);
                }

                break;
            case "2":
                if ((e.getButton()==MouseEvent.BUTTON3) && barra.x < getWidth() - barra.width - 45 && p == 1) {
                    Tp++;
                    ControlloTasti.mouseDpremuto=true;
                    avanti(43);
                }
                if ((e.getButton()==MouseEvent.BUTTON1) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.mouseSpremuto=true;
                    indietro(43);
                }

                break;
            case "3":
                if ((e.getButton()==MouseEvent.BUTTON3) && barra.x < getWidth() - barra.width - 40 && p == 1) {
                    Tp++;
                    ControlloTasti.mouseDpremuto=true;
                    avanti(45);
                }
                if ((e.getButton()==MouseEvent.BUTTON1) && barra.x > 31 && p == 1) {
                    Tp++;
                    ControlloTasti.mouseSpremuto=true;
                    indietro(45);
                }

                break;
        }
        if(e.getButton()==MouseEvent.BUTTON2)
        {
            if(p!=1) {
                Tp++;
                p = 1;
                ControlloTasti.mousecentrale=true;
                new Thread(() -> {
                    while ((L != 1)) {

                        update();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            ControlloTasti.mouseSpremuto=false;
        }
        if(e.getButton()==MouseEvent.BUTTON3)
        {
            ControlloTasti.mouseDpremuto=false;
        }
        if(e.getButton()==MouseEvent.BUTTON2)
        {
            ControlloTasti.mousecentrale=false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(fuori==1)
        USC.RIP();
}

    @Override
    public void mouseExited(MouseEvent e) {
        if(fuori!=1&&p==1&&escape!=1) {
            fuori = 1;
            Uscita();
        }
    }
    private void FINALE()
    {

        if(Finale.R==1)
        {
            Finale.SG.dispose();
        }
        R=1;
        fuori=0;
        FI=new JFrame("Brick Out Game");
        Finale FIN = new Finale();
        FI.setBounds(200,200,900,300);
        FI.getContentPane().add(FIN);
        FI.setVisible(true);
        FI.setResizable(false);
        FI.setBackground(new Color(255, 255, 255));
        FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Palla.forEach(Palla ->{
            Palla.movY=0;
            Palla.movX=0;
        });

    }
    private void Uscita()
    {
        if(fuori!=1) {
            Tp++;
            try {
                TIMER.update();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    Es=1;
    L =1;
    ControlloTasti.reset();

    USC = new USI();
    US=new JFrame("USCITA");
            US.getContentPane().add(USC);
            US.setVisible(true);
            US.setBounds(50,100,700,200);
            US.setResizable(false);
            US.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

}
private void Tasti()
{
    TA =new JFrame("Tasti");
    ControlloTasti tasti = new ControlloTasti();
    tasti.setVisible(true);
    TA.setBounds(925,575,625,300);
    TA.setVisible(true);
    TA.setResizable(false);
    TA.setBackground(new Color(255, 255, 255));
    TA.getContentPane().add(tasti);
    TA.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
}
private void records()
{
    RECO=new JFrame("Records");
    Records record = new Records();
    record.setVisible(true);
    RECO.setBounds(925,0,625,300);
    RECO.setVisible(true);
    RECO.setResizable(false);
    RECO.setBackground(new Color(255, 255, 255));
    RECO.getContentPane().add(record);
    RECO.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
}
private void avanti(int i)
{
    barra.x += i;
    barrapz1.x += i;
    barrapz2.x += i;
    barrapz3.x += i;
    barrapz4.x += i;
}
private void indietro(int i)
{
    barra.x -= i;
    barrapz1.x -= i;
    barrapz2.x -= i;
    barrapz3.x -= i;
    barrapz4.x -= i;
}


}
