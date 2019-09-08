


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class INIZ extends JPanel implements KeyListener {


    private Blocco OU=new Blocco(250,100,300,50,"out.png");
    private Blocco barra=new Blocco(300,300,200,10,"BarraIniz.png");
    private Blocco X=new Blocco(+100+(int)((Math.random()*500)),-12+(int)(Math.random()*50),50,50,"X.png");
    private int p,C;
    static JFrame INI;

    INIZ()
    {
        super();
        addKeyListener(this);
        setFocusable(true);
    if(OU.intersects(X))
    {
        X.y+=300;
    }
    }

    public  void paintComponent(Graphics g){
        setOpaque(false);
        OU.draw(g,this);
        barra.draw(g,this);
        X.draw(g,this);
    }
    private void update()
    {
        {
            OU.x+=OU.movX;
            if((OU.x)>(getWidth()-OU.width)|| OU.x<0)
                OU.movX*=-1;
            if(OU.y<0||OU.intersects(barra)||(OU.y>320))
                OU.movY*=-1;
            OU.y+=OU.movY;
            if (OU.intersects(X)&&(C!=1)) {
                OUT();
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER&&(p!=1)){
            p=1;
            new Thread(()-> {
                while (true) {
                    update();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }).start();

        }
        if(((e.getKeyCode()==KeyEvent.VK_RIGHT)||(e.getKeyCode()==KeyEvent.VK_D))&& barra.x <getWidth()-barra.width)
        {
            barra.x+=15;

        }
        if(((e.getKeyCode()==KeyEvent.VK_LEFT)||(e.getKeyCode()==KeyEvent.VK_A))&& barra.x>0)
        {

            barra.x-=15;
        }
        if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)||(e.getKeyCode()==KeyEvent.VK_SPACE)||(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)||(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)) {
            OUT();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void OUT()
    {
        C=1;
        INI=new JFrame("Seleziona Difficoltà");
        START ST = new START();
        INI.getContentPane().add(ST);
        INI.setVisible(true);
        INI.setSize(1000,450);
        INI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        INI.setResizable(false);
        try {
            Principale.SCI.dispose();
        }catch (NullPointerException ignored){}
    }
}

