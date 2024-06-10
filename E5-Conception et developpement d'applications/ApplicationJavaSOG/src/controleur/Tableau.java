package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel{
	private String entetes [];
	private Object donnees [][];
	
	public Tableau(String [] entetes, Object[][] donnees) {
		this.entetes= entetes;
		this.donnees = donnees;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int lg, int cl) {
		return this.donnees[lg][cl];
	}

	@Override
	public String getColumnName(int cl) {
		return this.entetes[cl];
	}
	
	public void ajouterLigne (Object ligne[]) {
		Object matrice [][ ] = new Object[this.donnees.length + 1][this.entetes.length];
		for (int i= 0; i< this.donnees.length; i++) {
			matrice [i] = this.donnees[i];
		}
		matrice [this.donnees.length] = ligne;
		this.donnees = matrice;
		//mise à jour des données 
		this.fireTableDataChanged();
		
	}
	
	public void supprimerLigne (int numLigne) {
		Object matrice [][ ] = new Object[this.donnees.length - 1][this.entetes.length];
		int j =0;
		for (int i= 0; i< this.donnees.length; i++) {  
			if (i !=numLigne) {
				matrice [j] = this.donnees[i];
				j++;
			}
		}
		this.donnees = matrice;
		//mise à jour des données 
		this.fireTableDataChanged();
	}
	
	public void modifierLigne (int numLigne, Object ligne []) {
		Object matrice [][ ] = new Object[this.donnees.length][this.entetes.length];
		int j =0;
		for (int i= 0; i< this.donnees.length; i++) {  
			if (i !=numLigne) {
				matrice [j] = this.donnees[i];
				j++;
			}else {
				matrice[j] = ligne;
				j++;
			}
		}
		this.donnees = matrice;
		//mise à jour des données 
		this.fireTableDataChanged();
	}
	
	public void setDonnees (Object matrice [][]) {
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	

}
