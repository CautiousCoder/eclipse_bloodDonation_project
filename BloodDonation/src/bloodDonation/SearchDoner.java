package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchDoner extends JFrame {

	private JPanel contentPane;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDoner frame = new SearchDoner();
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
	public SearchDoner() {
		setTitle("Doner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvailableDoner = new JLabel("Available Doner");
		lblAvailableDoner.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableDoner.setFont(new Font("Dialog", Font.BOLD, 40));
		lblAvailableDoner.setBounds(250, 12, 450, 40);
		contentPane.add(lblAvailableDoner);
		
		JLabel lno1 = new JLabel("");
		lno1.setFont(new Font("Dialog", Font.BOLD, 18));
		lno1.setHorizontalAlignment(SwingConstants.CENTER);
		lno1.setBounds(20, 170, 50, 30);
		contentPane.add(lno1);
		
		JLabel lno2 = new JLabel("");
		lno2.setHorizontalAlignment(SwingConstants.CENTER);
		lno2.setFont(new Font("Dialog", Font.BOLD, 18));
		lno2.setBounds(20, 210, 50, 30);
		contentPane.add(lno2);
		
		JLabel lno3 = new JLabel("");
		lno3.setHorizontalAlignment(SwingConstants.CENTER);
		lno3.setFont(new Font("Dialog", Font.BOLD, 18));
		lno3.setBounds(20, 250, 50, 30);
		contentPane.add(lno3);
		
		JLabel lno4 = new JLabel("");
		lno4.setHorizontalAlignment(SwingConstants.CENTER);
		lno4.setFont(new Font("Dialog", Font.BOLD, 18));
		lno4.setBounds(20, 290, 50, 30);
		contentPane.add(lno4);
		
		JLabel lno5 = new JLabel("");
		lno5.setHorizontalAlignment(SwingConstants.CENTER);
		lno5.setFont(new Font("Dialog", Font.BOLD, 18));
		lno5.setBounds(20, 330, 50, 30);
		contentPane.add(lno5);
		
		JLabel lno6 = new JLabel("");
		lno6.setHorizontalAlignment(SwingConstants.CENTER);
		lno6.setFont(new Font("Dialog", Font.BOLD, 18));
		lno6.setBounds(20, 370, 50, 30);
		contentPane.add(lno6);
		
		JLabel lno7 = new JLabel("");
		lno7.setHorizontalAlignment(SwingConstants.CENTER);
		lno7.setFont(new Font("Dialog", Font.BOLD, 18));
		lno7.setBounds(20, 410, 50, 30);
		contentPane.add(lno7);
		
		JLabel lno8 = new JLabel("");
		lno8.setHorizontalAlignment(SwingConstants.CENTER);
		lno8.setFont(new Font("Dialog", Font.BOLD, 18));
		lno8.setBounds(20, 450, 50, 30);
		contentPane.add(lno8);
		
		JLabel ltext1 = new JLabel("");
		ltext1.setBounds(70, 170, 820, 30);
		contentPane.add(ltext1);
		
		search = new JTextField();
		search.setBounds(350, 70, 250, 30);
		contentPane.add(search);
		search.setColumns(10);
		
		JLabel ltext2 = new JLabel("");
		ltext2.setBounds(70, 210, 820, 30);
		contentPane.add(ltext2);
		
		JLabel ltext4 = new JLabel("");
		ltext4.setBounds(70, 290, 820, 30);
		contentPane.add(ltext4);
		
		JLabel ltext3 = new JLabel("");
		ltext3.setBounds(70, 250, 820, 30);
		contentPane.add(ltext3);
		
		JLabel ltext5 = new JLabel("");
		ltext5.setBounds(70, 330, 820, 30);
		contentPane.add(ltext5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeJFrame hm = new HomeJFrame();
				hm.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel ltext6 = new JLabel("");
		ltext6.setBounds(70, 370, 820, 30);
		contentPane.add(ltext6);
		
		JLabel ltext7 = new JLabel("");
		ltext7.setBounds(70, 410, 820, 30);
		contentPane.add(ltext7);
		
		JLabel ltext8 = new JLabel("");
		ltext8.setBounds(70, 450, 820, 30);
		contentPane.add(ltext8);
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(428, 513, 117, 35);
		contentPane.add(btnBack);
		

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=null;
				String searchstr = search.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/blooddb","root","");
					String query = "SELECT *FROM signupdb WHERE blood_group= '" +searchstr+ "'";
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
						String s7 = ((ResultSet) result).getString(8);
						String s8 = ((ResultSet) result).getString(9);
						String s9 = ((ResultSet) result).getString(10);

						if(i==1) {
							String strr = "N= Name; FN= Father's Name; BG= Blood Group; G= Gender; P= Phone; AD= Address";
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext2.setText(str);
							ltext1.setText(strr);
							lno2.setText(""+i);
							i++;
						}
						else if(i==2) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext3.setText(str);
							lno3.setText(""+i);
							i++;
						}
						else if(i==3) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext4.setText(str);
							lno4.setText(""+i);
							i++;
						}
						else if(i==4) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext5.setText(str);
							lno5.setText(""+i);
							++i;
						}
						else if(i==5) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext6.setText(str);
							lno6.setText(""+i);
							++i;
						}
						else if(i==6) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext7.setText(str);
							lno7.setText(""+i);
							++i;
						}
						else if(i==7) {
							str = "N= "+s1+" "+s2+",  FN= "+s3+",  BG= "+s9+",  G= "+s8+",  P= "+s6+",  AD="+s7;
							ltext8.setText(str);
							lno8.setText(""+i);
							++i;
						}
						
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		searchButton.setFont(new Font("Dialog", Font.BOLD, 20));
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(0, 128, 0));
		searchButton.setBounds(390, 112, 170, 35);
		contentPane.add(searchButton);
	}
}
