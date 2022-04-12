package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.KorisnikCrud;
import model.Korisnik;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosKorisnika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfIme;
	private JTextField tfPrezime;
	
	KorisnikCrud kc = new KorisnikCrud();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosKorisnika dialog = new DUnosKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosKorisnika() {
		setTitle("Unos korisnika");
		setBounds(100, 100, 521, 278);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 198);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblIme.setBounds(53, 40, 55, 38);
		contentPanel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblPrezime.setBounds(53, 118, 79, 38);
		contentPanel.add(lblPrezime);
		
		tfIme = new JTextField();
		tfIme.setBounds(142, 47, 168, 19);
		contentPanel.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(142, 125, 168, 19);
		contentPanel.add(tfPrezime);
		tfPrezime.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 192, 436, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnUnesi = new JButton("Unesi");
				btnUnesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String imeKorinsika = tfIme.getText();
						String prezimeKorisnika = tfPrezime.getText();
						Korisnik k = new Korisnik(imeKorinsika, prezimeKorisnika);
						kc.insertKorisnik(k);
						
						DUnosPoruke dup = new DUnosPoruke();
						dup.setVisible(true);
						
					}
				});
				btnUnesi.setActionCommand("OK");
				buttonPane.add(btnUnesi);
				getRootPane().setDefaultButton(btnUnesi);
			}
			{
				JButton btnZatvori = new JButton("Zatvori");
				btnZatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
	}
}
