package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindPatientJFrame extends JFrame {

	private JPanel contentPane;
	String str = null,noti=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPatientJFrame frame = new FindPatientJFrame();
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
	public FindPatientJFrame() {
		setTitle("Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewPatientPost = new JButton("New Patient Post");
		btnNewPatientPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPatient npp = new NewPatient();
				npp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewPatientPost.setBackground(new Color(0, 255, 127));
		btnNewPatientPost.setBounds(300, 40, 230, 35);
		contentPane.add(btnNewPatientPost);
		
		JLabel lno1 = new JLabel("");
		lno1.setFont(new Font("Dialog", Font.BOLD, 16));
		lno1.setBounds(20, 150, 40, 30);
		contentPane.add(lno1);
		
		JLabel lno2 = new JLabel("");
		lno2.setFont(new Font("Dialog", Font.BOLD, 16));
		lno2.setBounds(20, 190, 40, 30);
		contentPane.add(lno2);
		
		JLabel lno3 = new JLabel("");
		lno3.setFont(new Font("Dialog", Font.BOLD, 16));
		lno3.setBounds(20, 130, 40, 30);
		contentPane.add(lno3);
		
		JLabel lno4 = new JLabel("");
		lno4.setFont(new Font("Dialog", Font.BOLD, 16));
		lno4.setBounds(20, 270, 40, 30);
		contentPane.add(lno4);
		
		JLabel lno5 = new JLabel("");
		lno5.setFont(new Font("Dialog", Font.BOLD, 16));
		lno5.setBounds(20, 310, 40, 30);
		contentPane.add(lno5);
		
		JLabel sugg = new JLabel("");
		sugg.setBounds(60, 100, 820, 30);
		contentPane.add(sugg);
		
		JLabel ltextno1 = new JLabel("");
		ltextno1.setBounds(60, 150, 820, 30);
		contentPane.add(ltextno1);
		
		JLabel ltextno2 = new JLabel("");
		ltextno2.setBounds(60, 190, 820, 30);
		contentPane.add(ltextno2);
		
		JLabel ltextno3 = new JLabel("");
		ltextno3.setBounds(60, 230, 820, 30);
		contentPane.add(ltextno3);
		
		JLabel ltextno4 = new JLabel("");
		ltextno4.setBounds(60, 270, 820, 30);
		contentPane.add(ltextno4);
		
		JLabel ltextno5 = new JLabel("");
		ltextno5.setBounds(60, 310, 820, 30);
		contentPane.add(ltextno5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeJFrame hmm = new HomeJFrame();
				hmm.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(352, 380, 120, 35);
		contentPane.add(btnBack);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
			String query = "SELECT *FROM patientdb";
			PreparedStatement st = conn.prepareStatement(query);
			
			Resultset result = (Resultset) st.executeQuery(query);
			int i=1;
			while(((ResultSet) result).next()) {
				String s1 = ((ResultSet) result).getString(2);
				String s2 = ((ResultSet) result).getString(3);
				String s3 = ((ResultSet) result).getString(4);
				String s4 = ((ResultSet) result).getString(5);
				String s5 = ((ResultSet) result).getString(6);
				String s6 = ((ResultSet) result).getString(7);
				if(i==1) {
					sugg.setText("Hints: N = Name; G = Gender; BG = Blood Group; P = Phone; AD = Address; DES = Description");
					str = "N= "+s1+",  G= "+s2+",  BG= "+s3+",  P= "+s4+",  AD= "+s5+",  DES= "+s6;
					ltextno1.setText(str);
					lno1.setText(""+i);
					i++;
				}
				else if(i==2) {
					str = "N= "+s1+",  G= "+s2+",  BG= "+s3+",  P= "+s4+",  AD= "+s5+",  DES= "+s6;
					ltextno2.setText(str);
					lno2.setText(""+i);
					i++;
				}
				else if(i==3) {
					str = "N= "+s1+",  G= "+s2+",  BG= "+s3+",  P= "+s4+",  AD= "+s5+",  DES= "+s6;
					ltextno3.setText(str);
					lno3.setText(""+i);
					i++;
				}
				else if(i==4) {
					str = "N= "+s1+",  G= "+s2+",  BG= "+s3+",  P= "+s4+",  AD= "+s5+",  DES= "+s6;
					ltextno4.setText(str);
					lno4.setText(""+i);
					i++;
				}
				else if(i==5) {
					str = "N= "+s1+",  G= "+s2+",  BG= "+s3+",  P= "+s4+",  AD= "+s5+",  DES= "+s6;
					ltextno5.setText(str);
					lno5.setText(""+i);
					++i;
				}
	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
