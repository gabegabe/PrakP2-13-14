/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ksr;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Sopiah
 */
public class Menu {
    static JFrame f;
    private JButton bLogin;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lSignIn,lUsername, lPassword;
    private JPanel panelUtama, panelIsi, panelTombol;
    
    public Menu(){
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
        //f.add(panelUtama);
        f.setVisible(true);
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
