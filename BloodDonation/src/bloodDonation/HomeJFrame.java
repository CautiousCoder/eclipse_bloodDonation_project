package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeJFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeJFrame frame = new HomeJFrame();

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
	public HomeJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/zahidul/workSpace/eclipse-workspace/BloodDonation/src/image/img.jpg"));
		setTitle("Home page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 650, 550);
		getContentPane().setLayout(null);
		
		JButton btnDtails = new JButton("Dtails");
		btnDtails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DetailsJFrame dt = new DetailsJFrame();
				dt.setVisible(true);
				setVisible(false);
			}
		});
		btnDtails.setForeground(Color.WHITE);
		btnDtails.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDtails.setBackground(Color.BLUE);
		btnDtails.setBounds(240, 125, 200, 40);
		getContentPane().add(btnDtails);
		
		JLabel lblNewLabel_1 = new JLabel("WELLCOME");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 60));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 20, 550, 60);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnDoner = new JButton("Find Doners");
		btnDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DonerJFrame dj = new DonerJFrame();
				dj.setVisible(true);
				setVisible(false);
			}
		});
		btnDoner.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDoner.setForeground(Color.WHITE);
		btnDoner.setBackground(new Color(139, 0, 0));
		btnDoner.setBounds(240, 185, 200, 40);
		getContentPane().add(btnDoner);
		
		JButton btnPatient = new JButton("Find Patients");
		btnPatient.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPatient.setForeground(Color.WHITE);
		btnPatient.setBackground(new Color(165, 42, 42));
		btnPatient.setBounds(240, 240, 200, 40);
		getContentPane().add(btnPatient);
		
		JButton btnLocation = new JButton("Donate Location");
		btnLocation.setForeground(Color.WHITE);
		btnLocation.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLocation.setBackground(new Color(0, 191, 255));
		btnLocation.setBounds(240, 294, 200, 40);
		getContentPane().add(btnLocation);
		
		JButton btnNewDoner = new JButton("New Doner");
		btnNewDoner.setForeground(Color.WHITE);
		btnNewDoner.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewDoner.setBackground(new Color(0, 128, 0));
		btnNewDoner.setBounds(240, 348, 200, 40);
		getContentPane().add(btnNewDoner);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Dialog", Font.BOLD, 16));
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		btnLogOut.setBounds(240, 403, 200, 40);
		getContentPane().add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 650, 500);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 48));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setIcon(new ImageIcon("/home/zahidul/workSpace/eclipse-workspace/BloodDonation/src/image/img.jpg"));
		getContentPane().add(lblNewLabel);
		JLabel lblWellCome = new JLabel("Well Come");
		lblWellCome.setBackground(Color.CYAN);
		lblWellCome.setFont(new Font("Dialog", Font.BOLD, 60));
		lblWellCome.setBounds(211, 73, 204, 81);
		getContentPane().add(lblWellCome);
	}
}
