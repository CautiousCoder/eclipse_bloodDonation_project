package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField signEmail;
	private JPasswordField signPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJFrame() {
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignInPage = new JLabel("Sign In Page");
		lblSignInPage.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSignInPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignInPage.setBounds(61, 22, 300, 30);
		contentPane.add(lblSignInPage);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 64, 80, 30);
		contentPane.add(lblNewLabel);
		
		signEmail = new JTextField();
		signEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		signEmail.setBounds(150, 71, 220, 30);
		contentPane.add(signEmail);
		signEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(45, 120, 90, 30);
		contentPane.add(lblPassword);
		
		signPass = new JPasswordField();
		signPass.setBounds(150, 120, 220, 30);
		contentPane.add(signPass);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Statement state;
				 Connection conn;
				 String email,pass;
				 
				 email = signEmail.getText();
				 pass = signPass.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
					state = conn.createStatement();
					
					String query = "SELECT *FROM signupdb WHERE email= '" +email+ "'AND password = '"+pass+"'";
					Resultset res = (Resultset) state.executeQuery(query);
					if(((ResultSet) res).next()) {
						HomeJFrame hom = new HomeJFrame();
						hom.setVisible(true);
						setVisible(false);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
				 	     
		});
		btnLogIn.setBackground(Color.CYAN);
		btnLogIn.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLogIn.setBounds(160, 180, 120, 30);
		contentPane.add(btnLogIn);
		
		JButton btnHaventAccountPlease = new JButton("Haven't Account? Please SignIn");
		btnHaventAccountPlease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignupJFrame su = new SignupJFrame();
				su.setVisible(true);
				setVisible(false);
			}
		});
		btnHaventAccountPlease.setBounds(100, 284, 300, 20);
		contentPane.add(btnHaventAccountPlease);
	}
}
