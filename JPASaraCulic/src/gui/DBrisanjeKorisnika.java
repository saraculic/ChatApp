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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DBrisanjeKorisnika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	KorisnikCrud kc = new KorisnikCrud();
	JComboBox<Korisnik> cbKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeKorisnika dialog = new DBrisanjeKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeKorisnika() {
		setTitle("Brisanje korisnika");
		setBounds(100, 100, 492, 286);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 206);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblKorisnik = new JLabel("Izaberi korisnika:");
			lblKorisnik.setBounds(54, 70, 126, 13);
			contentPanel.add(lblKorisnik);
		}
		{
			cbKorisnik = new JComboBox<Korisnik>();
			cbKorisnik.setBounds(168, 66, 230, 21);
			contentPanel.add(cbKorisnik);
			List<Korisnik> korisnici = kc.listKorisnika();
			for (Korisnik korisnik : korisnici) {
				cbKorisnik.addItem(korisnik);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(32, 196, 436, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnObrisi = new JButton("Obrisi");
				btnObrisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Korisnik k = (Korisnik) cbKorisnik.getSelectedItem();
						if(kc.deleteKorisnik(k)) {
							cbKorisnik.removeItem(k);
						}
					}
				});
				btnObrisi.setActionCommand("OK");
				buttonPane.add(btnObrisi);
				getRootPane().setDefaultButton(btnObrisi);
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
