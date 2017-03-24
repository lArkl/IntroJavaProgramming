
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Pelota extends JFrame{
    private Timer timer;
    private Ellipse2D bola1,bola2;
    private int x;
    private int a;
    Graphics2D g2;
    public Pelota() {
        super ("Simulacion de rebote");//by Ark
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        a=10;
        Manejador m=new Manejador();
        timer = new Timer(35,m);
        timer.setInitialDelay(90);
        timer.start();
    }
    public void paint (Graphics g) {
        super.paint(g);
        g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        bola1= new Ellipse2D.Double(8+x,100,40,40);
        bola2= new Ellipse2D.Double(455-x,100,40,40);
        g2.fill(bola1);
        g2.fill(bola2);
    }
    
    private class Manejador implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if((x>200 && a>=0) ||(x<0 && a<0)) a=-a;
            x+=a;
            repaint();
        }
    }
}
