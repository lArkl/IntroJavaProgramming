import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

public class TableroAjedrez extends JFrame{

	public TableroAjedrez() {
		super ("Tablero de Ajedrez");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color col=Color.black;
                g2.setColor(col);
		Rectangle2D cuadro;     
                for(int i=0;i<64;i++){
                    if(i%8!=0){
                        col=(col==Color.white)?Color.black:Color.white;
                        g2.setColor(col);
                    }
                    int j=i%8; 
                    int k=i/8;
                    cuadro = new Rectangle2D.Double(7+50*j, 31+50*k, 50, 50);
                    g2.fill(cuadro);
                }
	}    
}
