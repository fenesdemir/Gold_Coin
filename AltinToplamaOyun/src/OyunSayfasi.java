import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class OyunSayfasi extends JFrame {

	private JPanel contentPane;
	public static int rowC;
	public static int coloumnC;
	public static int altin;
	public static int gizliAltin;
	public static int basAltin;
	public static int adimYol;
	public static int hamleMaliyeti;
	public static int aMali;
	public static int bMali;
	public static int cMali;
	public static int dMali;
	public static int alanAltinSayisi;
	public static int gizliAltinSayisi;
	public int[][] tahta;
	public List<Integer> altin_koor = new ArrayList<Integer>();
	public final static int ONE_SECOND = 1000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OyunSayfasi frame = new OyunSayfasi(rowC, coloumnC, altin, gizliAltin, basAltin, adimYol, aMali, bMali, cMali, dMali, hamleMaliyeti); 		
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
	public OyunSayfasi(int row, int coloumn, int altinX, int gizliAltinX, int basAltinX, int adim, int aHedX, int bHedX, int cHedX, int dHedX, int birAdimMaliyeti) {
		
		rowC = row;
		coloumnC = coloumn;		
		altin = altinX;
		gizliAltin = gizliAltinX;
		basAltin = basAltinX;
		adimYol = adim;
		aMali = aHedX;
		bMali = bHedX;
		cMali = cHedX;
		dMali = dHedX;
		hamleMaliyeti = birAdimMaliyeti;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 990, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		OyunAlani oyunAlani = new OyunAlani(rowC, coloumnC, altin, gizliAltin, basAltin, adimYol, hamleMaliyeti, aMali, bMali, cMali, dMali);
		panel.setBounds(0, 0, (oyunAlani.alan[0].length)*30, (oyunAlani.alan.length)*30);
		panel.add(oyunAlani);
		contentPane.add(panel);
		
	}
}
