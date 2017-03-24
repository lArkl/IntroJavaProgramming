
import javax.swing.JFrame;
public class PruebaFigura {
    public static void main( String[] args )
    {
        Figura cuadro = new Figura(); // create ButtonFrame
        cuadro.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        cuadro.setSize(350, 350);
        cuadro.setResizable(false);
        cuadro.setVisible( true ); // display frame
    }   
}
