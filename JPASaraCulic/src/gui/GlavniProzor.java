package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GlavniProzor {

	private JFrame frmGlavniProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmGlavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGlavniProzor = new JFrame();
		frmGlavniProzor.setTitle("Glavni prozor");
		frmGlavniProzor.setBounds(100, 100, 450, 300);
		frmGlavniProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGlavniProzor.getContentPane().setLayout(null);
		
		JButton btnUnosKorisnika = new JButton("Unos korisnika");
		btnUnosKorisnika.setBackground(new Color(173, 216, 230));
		btnUnosKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosKorisnika duk = new DUnosKorisnika();
				duk.setVisible(true);
			}
		});
		btnUnosKorisnika.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnUnosKorisnika.setBounds(112, 31, 221, 42);
		frmGlavniProzor.getContentPane().add(btnUnosKorisnika);
		
		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		btnBrisanjeKorisnika.setBackground(new Color(173, 216, 230));
		btnBrisanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBrisanjeKorisnika dbk = new DBrisanjeKorisnika();
				dbk.setVisible(true);
			}
		});
		btnBrisanjeKorisnika.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnBrisanjeKorisnika.setBounds(112, 105, 221, 42);
		frmGlavniProzor.getContentPane().add(btnBrisanjeKorisnika);
		
		JButton btnPrikazPoslatihPoruka = new JButton("Prikaz poslatih poruka");
		btnPrikazPoslatihPoruka.setBackground(new Color(173, 216, 230));
		btnPrikazPoslatihPoruka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPrikazPoslatihPoruka dppp = new DPrikazPoslatihPoruka();
				dppp.setVisible(true);
			}
		});
		btnPrikazPoslatihPoruka.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnPrikazPoslatihPoruka.setBounds(112, 179, 221, 42);
		frmGlavniProzor.getContentPane().add(btnPrikazPoslatihPoruka);
	}
}
