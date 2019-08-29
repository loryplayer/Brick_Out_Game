import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
class Blocco extends Rectangle {
     private Image bloc,res1,res2,res3;
    boolean distrutto=false,resistente=true,resistente1=true,resistente2=true;
    double movX,movY;
    Blocco(int x,int y, int l, int al, String im)
    {
        this.x=x;
        this.y=y;
         movX=3;
         movY=3;
        this.width=l;
        this.height=al;
//ciao

        /*34234*/
        try {
            bloc= ImageIO.read(new File("immagini/"+im));
            res1= ImageIO.read(new File("immagini/BloccoRe2.png"));
            res2= ImageIO.read(new File("immagini/BloccoRe3.png"));
            res3= ImageIO.read(new File("immagini/BloccoRe4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        void draw(Graphics g, Component c)
        {
                if(!resistente) {
                g.drawImage(res1, x, y, width, height, c);
                if(!resistente1)
                {
                    g.drawImage(res2, x, y, width, height, c);
                    if(!resistente2)
                    {
                        g.drawImage(res3, x, y, width, height, c);
                    }
                }
            }
                else
            if((!distrutto)) {
                g.drawImage(bloc, x, y, width, height, c);
            }
        }
}
