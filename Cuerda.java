import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
//by Ark
public class Cuerda extends JFrame{
    private Timer timer;
    private int iniX,iniY,cont;
    private double x,y,nY;
    public Cuerda(){
    super ("Simulacion de Cuerda");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniX=50;
        iniY=250;
        do{
            String altura=JOptionPane.showInputDialog("Ingrese altura <200");
            nY=Double.parseDouble(altura);
        }while(nY>200);
        do{
            String distancia=JOptionPane.showInputDialog("Ingrese la distancia desde donde se soltara \nla cuerda (<400)");
            x=Double.parseDouble(distancia);
        }while(x<0 || x>399);
        y=nY;
        cont=0;
        Manejador m=new Manejador();
        timer = new Timer(20,m);
        timer.setInitialDelay(100);
        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        cont++;//variable tiempo
        Line2D l1 = new Line2D.Double(iniX,iniY,iniX+x,iniY-y);
        Line2D l2 = new Line2D.Double(iniX+x,iniY-y,iniX+400,iniY);
        g2.draw(l1);
        g2.draw(l2);
    }
    private class Manejador implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            double prevY=y;
            y=nY*Math.cos((double)cont/2*Math.PI/2);//movimiento armonico simple
            if(prevY<=0 && y>0){
                nY-=10;
            }
            repaint();
            if(nY<5){
                timer.stop();
                y=0;
                repaint();
            }   
        }
    }
}
