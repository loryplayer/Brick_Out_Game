
import javax.swing.*;
import java.awt.*;


class ControlloTasti extends JPanel

{
    static boolean Apremuto,Dpremuto,frecciaSpremuto,frecciaDpremuto,escpremuto,inviopremuto,mouseDpremuto,mouseSpremuto,mousecentrale;
    private ImageIcon[] icon=new ImageIcon[10];
    private JLabel[] tasto = new JLabel[10];
    ControlloTasti() {
for(int la=0;la<tasto.length;la++)
{
    icon[la]=new ImageIcon();
    tasto[la]= new JLabel();
}
reset();
        new Thread(() -> {
            while (true) {
                loop();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }


    private void loop()
    {

        String percorso;
        if(Apremuto&&!Dpremuto) {
                    percorso = "Aprem.png";
                    immagine(0, percorso,0,150);
            }else{
                percorso = "A.png";
                immagine(0, percorso,0,150);
            }


            if (Dpremuto&&!Apremuto) {
                    percorso = "Dprem.png";
               immagine(1, percorso,125,150);
            } else {
                percorso = "D.png";
                immagine(1, percorso, 125, 150);
            }
            if(frecciaDpremuto&&!frecciaSpremuto)
            {
                percorso ="Destraprem.png";
                immagine(2, percorso,500,150);
            }else{
                percorso ="Destra.png";
                immagine(2, percorso,500,150);
            }if(frecciaSpremuto&&!frecciaDpremuto)
            {
                percorso ="Sinistraprem.png";
                immagine(3, percorso,250,150);
            }else{
                percorso ="Sinistra.png";
                immagine(3, percorso,250,150);
            }if(escpremuto)
            {
                percorso ="Escprem.png";
                immagine(4, percorso,0,25);
            }else{
                percorso ="Esc.png";
                immagine(4, percorso,0,25);
            }if(inviopremuto)
            {
                percorso ="Invioprem.png";
                immagine(5, percorso,125,25);
            }else{
                percorso ="Invio.png";
                immagine(5, percorso,125,25);
            }if(mouseDpremuto)
            {
                percorso ="mouseDprem.png";
                immagine(6, percorso,500,25);
            }else
            {
                percorso ="mouseD.png";
                immagine(6, percorso,500,25);
            }if(mouseSpremuto)
            {
                percorso ="mouseSprem.png";
                immagine(7, percorso,250,25);
            }else
            {
                percorso ="mouseS.png";
                immagine(7, percorso,250,25);
            }if(mousecentrale)
            {
                percorso ="mouseCprem.png";
                immagine(8, percorso,375,25);
            }else
            {
                  percorso ="mouseC.png";
                immagine(8, percorso,375,25);
            }

    }
        private void immagine(int i, String name, int x, int y)
        {
try {
    icon[i] = new ImageIcon("immagini/" + name);
    Image j = icon[i].getImage();
    j = j.getScaledInstance(100, 100, 0);
    icon[i].setImage(j);
    tasto[i].setIcon(icon[i]);
    tasto[i].setLocation(x, y);
    add(tasto[i]);

}catch (ArrayIndexOutOfBoundsException ignored){}
        }
       static void reset()
        {
           Apremuto=false; Dpremuto=false; frecciaSpremuto=false; frecciaDpremuto=false; escpremuto=false; inviopremuto=false; mouseDpremuto=false; mouseSpremuto=false; mousecentrale=false;}
}