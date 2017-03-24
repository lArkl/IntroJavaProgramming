import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Dimension;
public class Figura extends JFrame{
	JLabel figura;
	private String[] lblFigura= {"Constantine", "Sandman", "Preacher","Ninguno"};;
	JComboBox lista;
	public Figura(){	
		super("JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista= new JComboBox(lblFigura);
		lista.setSelectedIndex(3);		
		CambiarFigura cf=new CambiarFigura();
		lista.addActionListener(cf);		
		figura = new JLabel();
		figura.setHorizontalAlignment(JLabel.CENTER);		
		add(lista,BorderLayout.PAGE_START);
		add(figura,BorderLayout.CENTER);
	}
	private class CambiarFigura implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			JComboBox c = (JComboBox)event.getSource();
			String nombre = (String)c.getSelectedItem();
			ImageIcon icon = createImageIcon(nombre + ".jpeg");
			figura.setIcon(icon);
			if (icon != null) {
			figura.setText(null);
		}
            }
	}
        protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Figura.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
}