package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.KorisnikCrud;
import model.Korisnik;
import model.Poruka;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DPrikazPoslatihPoruka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	KorisnikCrud kc = new KorisnikCrud();
	JComboBox<Korisnik> cbKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazPoslatihPoruka dialog = new DPrikazPoslatihPoruka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazPoslatihPoruka() {
		setTitle("Prikaz poslatih poruka");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblKorisnik = new JLabel("Izaberi korisnika:");
				panel.add(lblKorisnik);
			}
			{
				cbKorisnik = new JComboBox<Korisnik>();
				panel.add(cbKorisnik);
				List<Korisnik> korisnici = kc.listKorisnika();
				for (Korisnik korisnik : korisnici) {
					cbKorisnik.addItem(korisnik);
				}
			}
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Korisnik k = (Korisnik) cbKorisnik.getSelectedItem();
						List<Poruka> poruke = kc.porukeKojeJePoslaoKorisnik(k);
						if(poruke.size() != 0) {
							TableModel tm = new TableModel(poruke);
							table.setModel(tm);
						} else {
							JOptionPane.showMessageDialog(DPrikazPoslatihPoruka.this, "Nema poruka!");
						}
						
						
					}
				});
				panel.add(btnPrikazi);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
