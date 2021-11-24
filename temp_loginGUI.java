//import javax.swing.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginGUI implements ActionListener{

    private static JLabel password1, label;
	private static JTextField username;
	private static JButton button;
	private static JPasswordField Password;

    public static JFrame frame;
    public static void createUI(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame();
        frame.setTitle("LOGIN PAGE");
        frame.setLocation(new Point(500, 300));
        frame.add(panel);
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Username");
        label.setBounds(100, 8, 70, 20);
        panel.add(label);

        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);

        password1 = new JLabel("Password");
        password1.setBounds(100, 55, 70, 20);
        panel.add(password1);

        Password = new JPasswordField();
        Password.setBounds(100, 75, 193, 28);
        panel.add(Password);

        button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener((ActionListener) new loginGUI());
        panel.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = username.getText();
        String Password1 = String.valueOf(Password.getPassword());

        // below this function needs to change
        // if (Username.equals("section.io") && Password1.equals("123"))
        //     JOptionPane.showMessageDialog(null, "Login Successful");
        // else
        //     JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
        // changed function
        try{
            int status = Player.login(Username, Password1);
            if(status > 0){
                Player current_player = Player.get_current_player_details(status);
                JOptionPane.showMessageDialog(null, "You are logged in with id :" + current_player.id);
                homeGUI.createUI(current_player);
                frame.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Check your username and password again !");
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in logging in player !");
        }
    }


}
