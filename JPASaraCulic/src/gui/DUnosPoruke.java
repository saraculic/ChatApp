package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.KorisnikCrud;
import crud.PorukaCrud;
import model.Korisnik;
import model.Poruka;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DUnosPoruke extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfDatum;
	
	KorisnikCrud kc = new KorisnikCrud();
	PorukaCrud pc = new PorukaCrud();
	
	JComboBox<Korisnik> cbSalje;
	JComboBox<Korisnik> cbPrima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosPoruke dialog = new DUnosPoruke();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosPoruke() {
		setTitle("Unos poruke");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 232);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblSalje = new JLabel("Salje:");
			lblSalje.setBounds(57, 36, 45, 13);
			contentPanel.add(lblSalje);
		}
		{
			JLabel lblPrima = new JLabel("Prima:");
			lblPrima.setBounds(57, 85, 45, 13);
			contentPanel.add(lblPrima);
		}
		{
			JLabel lblDatum = new JLabel("Datum:");
			lblDatum.setBounds(57, 134, 45, 13);
			contentPanel.add(lblDatum);
		}
		{
			JLabel lblTekst = new JLabel("Tekst:");
			lblTekst.setBounds(57, 183, 45, 13);
			contentPanel.add(lblTekst);
		}
		
		cbSalje = new JComboBox<Korisnik>();
		cbSalje.setBounds(112, 29, 124, 21);
		contentPanel.add(cbSalje);
		List<Korisnik> korisnici = kc.listKorisnika();
		for (Korisnik korisnik : korisnici) {
			cbSalje.addItem(korisnik);
		}
		
		cbPrima = new JComboBox<Korisnik>();
		cbPrima.setBounds(112, 79, 124, 21);
		contentPanel.add(cbPrima);
		for (Korisnik korisnik : korisnici) {
			cbPrima.addItem(korisnik);
		}
		
		
		tfDatum = new JTextField();
		tfDatum.setBounds(112, 129, 124, 19);
		contentPanel.add(tfDatum);
		tfDatum.setColumns(10);
		
		JTextArea taTekst = new JTextArea();
		taTekst.setBounds(112, 177, 233, 41);
		contentPanel.add(taTekst);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 436, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnUnesi = new JButton("Unesi");
				btnUnesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Korisnik kSalje = (Korisnik) cbSalje.getSelectedItem();
						Korisnik kPrima = (Korisnik) cbPrima.getSelectedItem();
						String datum = tfDatum.getText();
						String tekst = taTekst.getText();
						Poruka p = new Poruka();
						p.setKorisnik1(kSalje);
						p.setKorisnik2(kPrima);
						p.setDatum(datum);
						p.setTekst(tekst);
						pc.insertPoruka(kSalje, kPrima, datum, tekst);
						
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
