import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Panel extends JFrame {
	public Panel() {
		super ("Prueba de Ventana");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint (Graphics g) {
		Rectangle2D r1 = new Rectangle2D.Float(75, 100, 75, 75);
		Graphics2D g2 = (Graphics2D)g;
		Stroke pincel = new BasicStroke(3.0f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		g2.setStroke(pincel);
		g2.setColor(Color.blue);
		g2.draw(r1);
	}
}
/*
		public void paint (Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.orange);
			g2.setStroke(new BasicStroke(3.0f));
			Ellipse2D e = new Ellipse2D.Float(100.0f,75.0f,50.0f,100.0f);
			g2.draw(e);
		}*/
