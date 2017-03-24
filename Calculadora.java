import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    JPanel[] panel = new JPanel[3];
    JButton[] btnC = new JButton[17];
    String[] btnNombre = {"CE","/","*",
                           "7", "8", "9", 
                             "4", "5", "6", 
                             "1", "2", "3","-", 
                              "+","=", "0","."};
    int flag;
    double temp1;
    double temp2;
    JTextArea pantalla = new JTextArea(1,21);
    
    Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for(int i = 0; i < 3; i++){
           panel[i] = new JPanel();
           panel[i].setLayout(new FlowLayout());
        }
        for(int i = 0; i < 17; i++) {
            btnC[i] = new JButton();
            btnC[i].setText(btnNombre[i]);
            btnC[i].addActionListener(this);
        }
        pantalla.setEditable(false);
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pantalla.setPreferredSize(new Dimension(210, 50));
        for(int i = 0; i < 13; i++)
            btnC[i].setPreferredSize(new Dimension(50, 40));
        btnC[13].setPreferredSize(new Dimension(50, 85));
        btnC[14].setPreferredSize(new Dimension(50, 85));
        btnC[15].setPreferredSize(new Dimension(95, 40));
        btnC[16].setPreferredSize(new Dimension(60,40));
        panel[0].add(pantalla);
        add(panel[0],BorderLayout.PAGE_START);
        for(int i = 0; i < 12; i++)
            panel[1].add(btnC[i]);
        panel[1].add(btnC[15]);
        panel[1].add(btnC[16]);
        add(panel[1],BorderLayout.CENTER);
        add(panel[1]);
        for(int i = 12; i < 15; i++)
            panel[2].add(btnC[i]);
        panel[2].setPreferredSize(new Dimension(60,200));
        add(panel[2],BorderLayout.LINE_END);
    }

    private void limpiar() {
        pantalla.setText("");
    }

    public void getResultado() {
        temp2=(pantalla.getText()=="")?0:Double.parseDouble(pantalla.getText());
        double resultado=0;
        switch(flag){
            case 1: resultado=temp2+temp1;break;
            case 2: resultado=temp1-temp2;break;
            case 3: resultado=temp2*temp1;break;
            case 4: if(temp2!=0)resultado=temp1/temp2;break;
            default: resultado=temp2;
        }
        temp1=resultado;
        int res=(int)resultado;
        String r;
        r=(resultado%1==0)?Integer.toString(res):Double.toString(resultado);
        if(flag==4 && temp2==0)pantalla.setText("Div por cero!");
        else pantalla.setText(r);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand()=="0"){//no agrega cero con pantalla vacia
            if(pantalla.getText().length()!=0)
            pantalla.setText(pantalla.getText()+event.getActionCommand());
        }
        else if(event.getActionCommand()=="."){
            //no agrega puntos de mas
            if(pantalla.getText().indexOf('.')==-1)
                pantalla.setText(pantalla.getText()+event.getActionCommand());
        }
        
        else if(event.getActionCommand()=="+"){
            temp1=Double.parseDouble(pantalla.getText());
            limpiar();
            flag=1;
        }
        else if(event.getActionCommand()=="-"){
            temp1=Double.parseDouble(pantalla.getText());
            limpiar();
            flag=2;
        }
        if(event.getActionCommand()=="*"){
            temp1=Double.parseDouble(pantalla.getText());
            limpiar();
            flag=3;
        }
        else if(event.getSource()==btnC[1]){
            temp1=Double.parseDouble(pantalla.getText());
            flag=4;
            limpiar();
        }
        else if(event.getActionCommand()=="="){
            getResultado();
            flag=0;
        }
        else if(event.getSource()==btnC[0]){
            limpiar();
        }
        
        else{
            Double aux=Double.parseDouble(event.getActionCommand());
            if(aux<10 && aux>0||pantalla.getText()=="Div por cero!"){//numerales
                pantalla.setText(pantalla.getText()+event.getActionCommand());
            }
        }
    }
}