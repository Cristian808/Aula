
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Teste extends JFrame implements ActionListener {
    
    JButton btn =new JButton("jose");
    JButton btn2= new JButton("adirsu");
    JButton btn3 = new JButton("otavio");
    JTextField textField = new JTextField(20);
    String input = "";
    
    public Teste(){
        setLayout(new FlowLayout());
        setSize(250, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Os véio");
        
        btn.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ola " + textField.getText() + " francisco");
            }
        });
        textField.addActionListener(this);
        
        add(btn);
        add(btn2);
        add(btn3);
        add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            System.exit(0);
        }
        if(e.getSource() == btn2){
            JOptionPane.showMessageDialog(null, "Jose");
        }
        if(e.getSource() == textField){
            input = textField.getText();
        }
        
    }
    
}
