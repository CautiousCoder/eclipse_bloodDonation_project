package bloodDonation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JPasswordField tfPassword;
	private String firstName,lastName,fulName,email,password,phone,address,gender,bGroup;
	private JLabel elFirstName,elLastName,elEmail,elPassword,elPhone,elAddress;
	private JRadioButton rbFemale,rbMale;
	static Statement state;
	static Connection conn;
	private JTextField tfPhone;
	private JTextField tfAddres;
	private ButtonGroup bgroup,bloodGroup;
	private JLabel lblFathersName;
	private JTextField tfFetherName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setTitle("New User");
		setFont(new Font("Dialog", Font.BOLD, 48));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFirstName.setBounds(60, 50, 130, 20);
		contentPane.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(200, 50, 300, 30);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLastName.setBounds(60, 90, 130, 20);
		contentPane.add(lblLastName);
		
		tfLastName = new JTextField();
		
		tfLastName.setBounds(200, 90, 300, 30);
		contentPane.add(tfLastName);
		tfLastName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEmail.setBounds(60, 170, 130, 20);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
				Pattern patt =Pattern.compile(PATTERN);
				Matcher match = patt.matcher(tfEmail.getText());
				if(!match.matches()) {
					elEmail.setText("Invalid! Email");
				} else {
					email = tfEmail.getText();
					elEmail.setText(null);
				}
			}
		});
		tfEmail.setBounds(200, 170, 300, 30);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(60, 210, 130, 20);
		contentPane.add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(200, 210, 300, 30);
		contentPane.add(tfPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhone.setBounds(60, 250, 130, 20);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddress.setBounds(60, 290, 130, 20);
		contentPane.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGender.setBounds(60, 340, 130, 20);
		contentPane.add(lblGender);
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setFont(new Font("Dialog", Font.BOLD, 14));
		rbFemale.setBounds(200, 340, 100, 30);
		contentPane.add(rbFemale);
		
		rbMale = new JRadioButton("Male");
		rbMale.setFont(new Font("Dialog", Font.BOLD, 14));
		rbMale.setBounds(325, 340, 100, 30);
		contentPane.add(rbMale);
		
		bgroup = new ButtonGroup();
		bgroup.add(rbMale);
		bgroup.add(rbFemale);
		
		elFirstName = new JLabel("");
		elFirstName.setFont(new Font("Dialog", Font.BOLD, 14));
		elFirstName.setForeground(Color.RED);
		elFirstName.setBounds(518, 55, 300, 20);
		contentPane.add(elFirstName);
		
		elLastName = new JLabel("");
		elLastName.setForeground(Color.RED);
		elLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		elLastName.setBounds(518, 95, 300, 20);
		contentPane.add(elLastName);
		
		elEmail = new JLabel("");
		elEmail.setForeground(Color.RED);
		elEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		elEmail.setBounds(518, 135, 300, 20);
		contentPane.add(elEmail);
		
		elPassword = new JLabel("");
		elPassword.setForeground(Color.RED);
		elPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		elPassword.setBounds(518, 175, 300, 20);
		contentPane.add(elPassword);
		
		elPhone = new JLabel("");
		elPhone.setForeground(Color.RED);
		elPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		elPhone.setBounds(518, 215, 300, 20);
		contentPane.add(elPhone);
		
		elAddress = new JLabel("");
		elAddress.setForeground(Color.RED);
		elAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		elAddress.setBounds(518, 255, 300, 20);
		contentPane.add(elAddress);
		
		tfPhone = new JTextField();
		tfPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Pattern patt =Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
				Matcher match = patt.matcher(tfPhone.getText());
				if(!match.matches()) {
					elPhone.setText("Incorrect! Phone..");
				} else {
					phone = tfPhone.getText();
					elPhone.setText(null);
				}
			}
		});
		tfPhone.setColumns(10);
		tfPhone.setBounds(200, 250, 300, 30);
		contentPane.add(tfPhone);
		
		tfAddres = new JTextField();
		tfAddres.setColumns(10);
		tfAddres.setBounds(200, 290, 300, 30);
		contentPane.add(tfAddres);
		
		lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFathersName.setBounds(60, 130, 130, 20);
		contentPane.add(lblFathersName);
		
		tfFetherName = new JTextField();
		tfFetherName.setColumns(10);
		tfFetherName.setBounds(200, 130, 300, 30);
		contentPane.add(tfFetherName);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBloodGroup.setBounds(60, 380, 130, 20);
		contentPane.add(lblBloodGroup);
		
		JRadioButton groupAp = new JRadioButton("A+");
		groupAp.setFont(new Font("Dialog", Font.BOLD, 18));
		groupAp.setBounds(200, 380, 60, 30);
		contentPane.add(groupAp);
		
		JRadioButton groupAm = new JRadioButton("A-");
		groupAm.setFont(new Font("Dialog", Font.BOLD, 18));
		groupAm.setBounds(265, 380, 50, 30);
		contentPane.add(groupAm);
		
		JRadioButton groupBp = new JRadioButton("B+");
		groupBp.setFont(new Font("Dialog", Font.BOLD, 18));
		groupBp.setBounds(340, 380, 55, 30);
		contentPane.add(groupBp);
		
		JRadioButton groupBm = new JRadioButton("B-");
		groupBm.setFont(new Font("Dialog", Font.BOLD, 18));
		groupBm.setBounds(420, 380, 50, 30);
		contentPane.add(groupBm);
		
		JRadioButton groupABp = new JRadioButton("AB+");
		groupABp.setFont(new Font("Dialog", Font.BOLD, 18));
		groupABp.setBounds(200, 415, 70, 30);
		contentPane.add(groupABp);
		
		JRadioButton groupABm = new JRadioButton("AB-");
		groupABm.setFont(new Font("Dialog", Font.BOLD, 18));
		groupABm.setBounds(275, 415, 70, 30);
		contentPane.add(groupABm);
		
		JRadioButton groupOp = new JRadioButton("O+");
		groupOp.setFont(new Font("Dialog", Font.BOLD, 18));
		groupOp.setBounds(340, 415, 60, 30);
		contentPane.add(groupOp);
		
		JRadioButton groupOm = new JRadioButton("O-");
		groupOm.setFont(new Font("Dialog", Font.BOLD, 18));
		groupOm.setBounds(420, 415, 60, 30);
		contentPane.add(groupOm);
		
		bloodGroup = new ButtonGroup();
		bloodGroup.add(groupAp);
		bloodGroup.add(groupAm);
		bloodGroup.add(groupBp);
		bloodGroup.add(groupBm);
		bloodGroup.add(groupABp);
		bloodGroup.add(groupABm);
		bloodGroup.add(groupOp);
		bloodGroup.add(groupOm);
		
		JButton btnSignUp = new JButton("Create User");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				dbConnection connect = new dbConnection();
//				connect.ConnerDb();
				Random r = new Random();
				int low = 1;
				int high = 1000;
				int result = r.nextInt(high-low) + low;
				firstName = tfFirstName.getText();
				lastName = tfLastName.getText();
				password = tfPassword.getText();
				address = tfAddres.getText();
				String fname = tfFetherName.getText();
				
				if(rbMale.isSelected()) {
					gender = "Male";
				}
				else if(rbFemale.isSelected()) {
					gender = "Female";
				}
				if(groupAp.isSelected()) {
					bGroup = "A+";
				}
				else if(groupAm.isSelected()) {
					bGroup = "A-";
				}
				else if(groupBp.isSelected()) {
					bGroup = "B+";
				}
				else if(groupBm.isSelected()) {
					bGroup = "B-";
				}
				else if(groupABp.isSelected()) {
					bGroup = "AB+";
				}
				else if(groupABm.isSelected()) {
					bGroup = "AB-";
				}
				else if(groupOp.isSelected()) {
					bGroup = "O+";
				}
				else if(groupOm.isSelected()) {
					bGroup = "O-";
				}
				
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
					state = conn.createStatement();
                    String query = "INSERT INTO signupdb  values('" + result + "','" + firstName + "','" + lastName + "','"+fname+"','" +
                    		email + "','" + password + "','" + phone + "','" + address + "','" + gender + "','"+bGroup+"')";

                    int x = state.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnSignUp, "This is alredy exist");
                    } else {
                    	HomeJFrame hom = new HomeJFrame();
                        JOptionPane.showMessageDialog(btnSignUp,
                            "Welcome, " + fulName + ". Your account is sucessfully created");
                        
                        hom.setVisible(true);
                        setVisible(false);
                        
                    }
                    conn.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
			}
		});
		btnSignUp.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.BLUE);
		btnSignUp.setBounds(250, 470, 150, 40);
		contentPane.add(btnSignUp);
		
		JButton arAbutton = new JButton("BACK");
		arAbutton.setBackground(Color.CYAN);
		arAbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeJFrame lg = new HomeJFrame();
				lg.setVisible(true);
				setVisible(false);
			}
		});
		arAbutton.setBounds(250, 530, 150, 35);
		contentPane.add(arAbutton);
		
	}
}
