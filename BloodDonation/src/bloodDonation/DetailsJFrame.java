package bloodDonation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailsJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsJFrame frame = new DetailsJFrame();
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
	public DetailsJFrame() {
		setTitle("Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JTextArea txtrWhyShouldPeople = new JTextArea();
		txtrWhyShouldPeople.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrWhyShouldPeople.setTabSize(4);
		txtrWhyShouldPeople.setText("\n Qn. Why should people donate blood?\n\n"
				+ " Ans. Safe blood saves lives. Blood is needed by women with complications during\n" + 
				 "	pregnancy and childbirth, children with severe anaemia, often resulting from\n" + 
				 "	malaria or malnutrition, accident victims and surgical and cancer patients.\n"
				+ "\n" + "	There is a constant need for a regular supply of blood because it can be stored\n" + 
				 "	only for a limited period of time before use. Regular blood donation by a sufficient\n" + 
				 "	number of healthy people is needed to ensure that blood will always be available\n" + 
				 "	whenever and wherever it is needed.\n" + 
				"\n" + 
				"	Blood is the most precious gift that anyone can give to another person – the\n" + 
				 "	gift of life. A decision to donate your blood can save a life,\n" + 
				 "	or even several if your blood is separated into its components – red cells,\n" + 
				 "	platelets and plasma – which can be used individually for patients with specific conditions.\n"+
				"\n\n Qn. What happens when I give blood?  \n"+
				"\n Ans. Whether you are a first-time or regular donor, the blood service must make sure that \n "
				+ "	you will come to no harm by donating blood.\n"
				+ "\n	A drop of blood will then be taken from your fingertip to check that giving blood will\n	not make you anaemic."
				+ " Your health is very important to the blood transfusion service and blood\n	will not be taken unless you can safely"
				+ " give a donation that day.\n"+
				"\n	After resting for 10 or 15 minutes and taking some refreshment, you will be able to return\n	to your normal activities,"
				+ " although you should avoid strenuous activity for\n	the rest of the day. You should drink plenty of fluids over the next"
				+ " 24 hours."+
				"\n\n Qn. How much blood will be taken? Will I have enough?\n\n"+
				" Ans. In most countries, the volume of blood taken is 450 millilitres, less than 10 per cent\n	of your total blood volume (the average"
				+ " adult has 4.5 to 5\n	litres of blood). In some countries, a smaller volume is taken. Your body\n	will replace the lost fluid"
				+ " within about 36 hours."+
				"\n\n Qn. Is giving blood safe? \n\n"+
				" Ans. Yes. Remember that you will only be accepted as a blood donor if you are fit and well.\n	Your health and well-being are very"
				+ " important to the blood service.\n	The needle and blood bag used to collect blood come in a sterile pack that cannot be reused,\n"
				+ "	so the process is made as safe as possible."+
				"\n\n Qn. Who should not give blood? \n\n"+
				" Ans. The blood service is concerned with the welfare of both the blood donor and the\n	recipient (patient). Donors are often asked"
				+ " not to donate blood for a period of\n	time in the interests of their safety and/or that of the blood supply.\n" + 
				"\n" + 
				"	You should not give blood if your own health might suffer as a result.\n	The first concern of the blood service is to ensure that\n"
				+ "	blood donation does no harm to the blood donor. You should not donate blood if:\n" + 
				"\n" + 
				"    You are feeling unwell\n" + 
				"    You are anaemic\n" + 
				"    You are pregnant, have been pregnant within the last year or are breastfeeding\n" + 
				"    You have certain medical conditions, which might make you an unsuitable donor \n" + 
				"    You are taking certain medications, such as antibiotics.");
		txtrWhyShouldPeople.setColumns(60);
		txtrWhyShouldPeople.setRows(26);
		
		JScrollPane sp = new JScrollPane(txtrWhyShouldPeople, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setContentPane(contentPane);
		
		contentPane.add(sp);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeJFrame hf = new HomeJFrame();
				hf.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBackground(Color.CYAN);
		contentPane.add(btnBack);
		
	}

}
