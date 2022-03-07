package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DonerJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField fName;
	private JTextField dgender;
	private JTextField bgroup;
	private JTextField phone;
	private JTextField adres;
	Statement state;
	Connection conn;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonerJFrame frame = new DonerJFrame();
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
	public DonerJFrame() {
		setFont(new Font("Dialog", Font.BOLD, 44));
		setTitle("Doner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel donerName = new JLabel("Name :");
		donerName.setFont(new Font("Dialog", Font.BOLD, 14));
		donerName.setBounds(50, 150, 100, 30);
		contentPane.add(donerName);
		
		JLabel fatherName = new JLabel("Father's Name :");
		fatherName.setFont(new Font("Dialog", Font.BOLD, 14));
		fatherName.setBounds(50, 190, 125, 30);
		contentPane.add(fatherName);
		
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Dialog", Font.BOLD, 14));
		gender.setBounds(50, 230, 100, 30);
		contentPane.add(gender);
		
		JLabel bloodgroup = new JLabel("Blood Group :");
		bloodgroup.setFont(new Font("Dialog", Font.BOLD, 14));
		bloodgroup.setBounds(50, 270, 125, 30);
		contentPane.add(bloodgroup);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhone.setBounds(50, 310, 100, 30);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(50, 350, 100, 30);
		contentPane.add(lblAddress);
		
		fname = new JTextField();
		fname.setBounds(190, 150, 400, 30);
		contentPane.add(fname);
		fname.setColumns(10);
		
		fName = new JTextField();
		fName.setColumns(10);
		fName.setBounds(190, 190, 400, 30);
		contentPane.add(fName);
		
		dgender = new JTextField();
		dgender.setColumns(10);
		dgender.setBounds(190, 230, 400, 30);
		contentPane.add(dgender);
		
		bgroup = new JTextField();
		bgroup.setColumns(10);
		bgroup.setBounds(190, 270, 400, 30);
		contentPane.add(bgroup);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(190, 310, 400, 30);
		contentPane.add(phone);
		
		adres = new JTextField();
		adres.setColumns(10);
		adres.setBounds(190, 350, 400, 30);
		contentPane.add(adres);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				HomeJFrame hj = new HomeJFrame();
				hj.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setBackground(Color.CYAN);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 24));
		btnBack.setBounds(473, 406, 117, 40);
		contentPane.add(btnBack);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
			String query = "SELECT *FROM signupdb";
			PreparedStatement st = conn.prepareStatement(query);
			
			Resultset result = (Resultset) st.executeQuery(query);
			while(((ResultSet) result).next()) {
				String s1 = ((ResultSet) result).getString(2);
				String s2 = ((ResultSet) result).getString(3);
				String s3 = ((ResultSet) result).getString(4);
				String s4 = ((ResultSet) result).getString(5);
				String s5 = ((ResultSet) result).getString(6);
				String s6 = ((ResultSet) result).getString(7);
				String s7 = ((ResultSet) result).getString(8);
				String s8 = ((ResultSet) result).getString(9);
				String s9 = ((ResultSet) result).getString(10);
				
				fname.setText(s1+" "+s2);
				fName.setText(s3);
				dgender.setText(s8);
				bgroup.setText(s9);
				phone.setText(s6);
				adres.setText(s7);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
