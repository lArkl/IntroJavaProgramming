
import java.awt.AlphaComposite;
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
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Mundo extends JFrame{
    private Timer timer;
    private Ellipse2D bola1,bola2;
    private int cont;
    private final int a=100,b=20;
    private double x,y,diff;
    Graphics2D g2;
    public Mundo() {
        super ("Simulacion de movimiento Satelital");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Manejador m=new Manejador();
        x=a;
        y=0;
        diff=0;
        cont=0;
        timer = new Timer(35,m);
        timer.setInitialDelay(90);
        timer.start();
    }
    public void paint (Graphics g) {
        super.paint(g);
        g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        bola1= new Ellipse2D.Double(220,100,40,40);
        g2.fill(bola1);
//        BufferedImage bi = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D big = bi.createGraphics();
//
//        AlphaComposite ac;
//        if(cont/4>Math.PI)ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
//        else 
//        ac=AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
//        
//        big.setComposite(ac);
        bola2= new Ellipse2D.Double(225+x,105+y,30+diff,30+diff);
        
        g2.setColor(Color.blue);
        g2.fill(bola2);
    }
    
    private class Manejador implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           cont=cont/6==Math.PI*2?0:cont+1;
           x=a*Math.cos((double)cont/6);
           y=b*Math.sin((double)cont/6);
           diff=10*Math.cos((double)cont/6-Math.PI/2);
           //-Math.PI*.50
           repaint();
        }
    }
}