import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainMenu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Boyut (Boy x En):");
		lblNewLabel.setBounds(10, 11, 100, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Altinlarin Orani:");
		lblNewLabel_1.setBounds(10, 47, 125, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gizli Altinlarin Orani:");
		lblNewLabel_2.setBounds(10, 83, 125, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Baslang\u0131ctaki Altinlar:");
		lblNewLabel_3.setBounds(10, 119, 125, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bir Adimda Alinan Yol:");
		lblNewLabel_4.setBounds(10, 155, 125, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A icin Hedef Belirleme Maliyeti:");
		lblNewLabel_5.setBounds(10, 191, 150, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("B icin Hedef Belirleme Maliyeti:");
		lblNewLabel_6.setBounds(10, 227, 150, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("C icin Hedef Belirleme Maliyeti:");
		lblNewLabel_7.setBounds(10, 263, 150, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("D icin Hedef Belirleme Maliyeti:");
		lblNewLabel_8.setBounds(10, 299, 150, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setText("20");
		textField.setBounds(165, 13, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("20");
		textField_1.setBounds(165, 49, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("10");
		textField_2.setBounds(165, 85, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("200");
		textField_3.setBounds(165, 121, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText("3");
		textField_4.setBounds(165, 157, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("5");
		textField_5.setBounds(165, 193, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("10");
		textField_6.setBounds(165, 229, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText("15");
		textField_7.setBounds(165, 265, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("20");
		textField_8.setBounds(165, 301, 86, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setText("20");
		textField_9.setBounds(261, 13, 86, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setText("5");
		textField_10.setBounds(165, 332, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton = new JButton("BASLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int boy = Integer.parseInt(textField.getText());
				int en = Integer.parseInt(textField_9.getText());
				int altin_oran = Integer.parseInt(textField_1.getText());
				int gizli_oran = Integer.parseInt(textField_2.getText());
				int baslangic_altin = Integer.parseInt(textField_3.getText());
				int adimda_alinan_yol = Integer.parseInt(textField_4.getText());				
				int a_hedef = Integer.parseInt(textField_5.getText());
				int b_hedef = Integer.parseInt(textField_6.getText());
				int c_hedef = Integer.parseInt(textField_7.getText());
				int d_hedef = Integer.parseInt(textField_8.getText());	
				int birHamleMaliyeti = Integer.parseInt(textField_10.getText());
				
				frame.dispose();
				OyunSayfasi oyunSay = new OyunSayfasi(boy, en, altin_oran, gizli_oran, baslangic_altin, adimda_alinan_yol, a_hedef, b_hedef, c_hedef, d_hedef, birHamleMaliyeti);
				oyunSay.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 360, 337, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("Bir Hamlede Harcanan Altin:");
		lblNewLabel_9.setBounds(10, 335, 150, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		
		
	}
}
