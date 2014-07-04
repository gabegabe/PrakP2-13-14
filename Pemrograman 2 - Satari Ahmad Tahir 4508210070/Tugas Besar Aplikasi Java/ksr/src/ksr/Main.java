
package ksr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Main implements ActionListener{
    static JFrame f;
    private JButton bLogin;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lSignIn,lUsername, lPassword;
    private JPanel panelUtama, panelIsi, panelTombol;
    
    public Main(){
        f = new JFrame("Admin Page");
        panelUtama = new JPanel();
        panelIsi = new JPanel();
        panelTombol = new JPanel();
        bLogin = new JButton("Login");
        lSignIn = new JLabel("Sign In !");
        lUsername = new JLabel("Username");
        lPassword = new JLabel("Password");
        tfUsername = new JTextField(10);
        pfPassword = new JPasswordField(10);  
    }
     public void luncur(){
        panelUtama.setLayout(new BorderLayout());
        panelIsi.setLayout(new GridLayout(2,2));
        panelTombol.setLayout(new FlowLayout());
        panelUtama.add(lSignIn, BorderLayout.NORTH);
        panelIsi.add(tfUsername);
        panelIsi.add(lUsername);
        panelIsi.add(pfPassword);
        panelIsi.add(lPassword);
        panelTombol.add(bLogin);
        panelUtama.add(panelIsi, BorderLayout.CENTER);
        panelUtama.add(panelTombol, BorderLayout.SOUTH);
        f.add(panelUtama);
        f.setVisible(true);
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        bLogin.addActionListener(this);
        bLogin.setActionCommand("masuk");
    }
    
    public static void main(String[] args) {
        Main ta = new Main();
        ta.luncur();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "masuk"){
            DatabaseService ds = new DatabaseService();
            try {
                String hasil = ds.login(tfUsername.getText(), pfPassword.getText());
                if(hasil != ""){
                    System.out.println("benar");
                    
                    Vector makan = ds.getMakanan();
                    for(int i=0; i< makan.size(); i++){
                       Vector objs = (Vector) makan.get(i);
                       for(int j=0; j< objs.size(); j++){
                        System.out.print(objs.get(j).toString());
                       }
                    System.out.println();
                    }
                    /*Menu m = new Menu();
                    m.luncur();*/
                }
                else{
                    System.out.println("salah");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}