package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Poruka;

public class TableModel extends AbstractTableModel{
	
	private List<Poruka> poruke = null;
	String[] kolone = {"Primalac", "Datum slanja", "Tekst"};
	
	public TableModel(List<Poruka> poruke) {
		this.poruke = poruke;
	}

	@Override
	public int getRowCount() {
		return poruke.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Poruka p = poruke.get(rowIndex);
		switch(columnIndex) {
		case 0: return p.getKorisnik2();
		case 1: return p.getDatum();
		case 2: return p.getTekst();
		}
		return null;
	}

	public String getColumnName(int i) {
		return kolone[i];
	}
}
