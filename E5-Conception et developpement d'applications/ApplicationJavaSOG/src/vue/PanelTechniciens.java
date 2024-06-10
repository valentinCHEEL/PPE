package vue;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 

import controleur.Controleur;
import controleur.Tableau;
import controleur.Technicien;
 
public class PanelTechniciens extends PanelPrincipal implements ActionListener{
 
 
		private JPanel panelForm = new JPanel ();
		private JTextField txtNomT = new JTextField();
		private JTextField txtPrenomT = new JTextField();
		private JComboBox<String> txtDisponibilite = new JComboBox<String>();
		private JTextField txtTarifHoraire = new JTextField();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btEnregistrer = new JButton("Enregistrer");
		
		//table des technicien
		private JTable tableTechniciens ; 
		private int nbTechniciens;
		private JLabel lbTitre = new JLabel("Nombre de techniciens : ");
		private JScrollPane uneScroll ;
		
		//panel de filtrage
		private JPanel panelFiltre = new JPanel();
		private JTextField txtFiltre = new JTextField();
		private JButton btFiltrer = new JButton("Filtrer");
		private Tableau unTableau ;
		public PanelTechniciens() {
		super ();
		
		//Constructeur du formulaire technicien.
		this.panelForm.setLayout(new GridLayout(5,2));
		this.panelForm.setBackground(new Color (0, 0, 130));
		this.panelForm.setBounds(10, 10, 300, 300);
		this.panelForm.add(new JLabel("Nom technicien :"));
		this.panelForm.add(this.txtNomT);
		this.panelForm.add(new JLabel("Prenom  :"));
		this.panelForm.add(this.txtPrenomT);
		this.panelForm.add(new JLabel("Disponibilite :"));
		this.panelForm.add(this.txtDisponibilite);
		this.panelForm.add(new JLabel("Tarif horraire :"));
		this.panelForm.add(this.txtTarifHoraire);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.setVisible(true);
		this.add(this.panelForm);
		
		Component[] components = this.panelForm.getComponents();
	    Color textColor = Color.WHITE;
	    for (Component component : components) {
	        if ( component instanceof JLabel) {
	            component.setForeground(textColor);
	        }
	    }

		//construction de la table des technicien
		String entetes [] = {"matricule", "NomT", "PrenomT","disponibilite","tarifHoraire"};
		this.unTableau = new Tableau(entetes, this.remplirDonnees(""));
		this.tableTechniciens = new JTable(this.unTableau);
		this.tableTechniciens.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableTechniciens);
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);
		//construction du panel filtre
		this.panelFiltre.setBounds(400, 30, 400, 30);
		this.panelFiltre.setBackground(new Color (255, 255, 255));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les techniciens par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(btFiltrer);
		this.add(this.panelFiltre);

		//rendre les boutons ecoutables
	    this.btAnnuler.addActionListener(this);
	    this.btEnregistrer.addActionListener(this);
	    this.btFiltrer.addActionListener(this);
	    //placement du titre 
	    this.lbTitre.setBounds(200 , 330, 300, 20);
	    this.nbTechniciens = this.unTableau.getRowCount();
	    this.lbTitre.setText("Nombre de la techniciens : " + this.nbTechniciens);
	    this.add(this.lbTitre);
	    
	  //remplir la disponibilite du technicien 
	    this.txtDisponibilite.addItem("oui");
	    this.txtDisponibilite.addItem("non");
	    
	    
	    //suppresion d'une classe
	    this.tableTechniciens.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			@Override
			public void mousePressed(MouseEvent e) {

			}
			@Override
			public void mouseExited(MouseEvent e) {
 
 
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			public void mouseClicked(MouseEvent e) {
	        int numLigne ;
	        int matricule;
	        if (e.getClickCount()>= 2) {
	        	numLigne = tableTechniciens.getSelectedRow();
	        	matricule = Integer.parseInt(tableTechniciens.getValueAt(numLigne, 0).toString());
	        	int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous confirmer la suppression?", "Suppression de la technicien", JOptionPane.YES_NO_OPTION);
	        	if (reponse == 0) {
	        		// confirmation de la suppresion dans la BDD
	        		Controleur.deleteTechnicien(matricule);
	        		//confirmation de la suppression dans l'affichage des classes
	        		unTableau.supprimerLigne(numLigne);
	        		nbTechniciens = unTableau.getRowCount();
	        		lbTitre.setText("Nombre de la techniciens : " + nbTechniciens);
	        	}
	        }
	        else if (e.getClickCount()==1) {
	        	numLigne = tableTechniciens.getSelectedRow();
	        	txtNomT.setText(tableTechniciens.getValueAt(numLigne,1).toString());
	        	txtPrenomT.setText(tableTechniciens.getValueAt(numLigne,2).toString());
	        	//txtDisponibilite.setText(tableTechniciens.getValueAt(numLigne,3).toString());
	        	txtTarifHoraire.setText(Float.toString(Float.parseFloat(tableTechniciens.getValueAt(numLigne, 4).toString())));
	        	btEnregistrer.setText("Modifier");
	        }
			}
		});
 
	  }
		public Object [][] remplirDonnees (String filtre){
			//cette méthode permet de convertire l'ArrayListe en une matrice de donnés.
			ArrayList<Technicien> lesTechniciens = Controleur.selectAllTechniciens(filtre);
			Object [][] matrice = new Object [lesTechniciens.size()][5];
			int i =0;
			for (Technicien unTechnicien: lesTechniciens) {
				matrice [i][0] = unTechnicien.getMatricule();
				matrice [i][1] = unTechnicien.getNomT();
				matrice [i][2] = unTechnicien.getPrenomT();
				matrice [i][3] = unTechnicien.getDisponibilite();
				matrice [i][4] = unTechnicien.getTarifHoraire();
				i++;
			}
			return matrice;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtNomT.setText("");
			this.txtPrenomT.setText("");
			//this.txtDisponibilite.setText("");
			this.txtTarifHoraire.setText(Float.toString(0.0f));
			this.btEnregistrer.setText("Enregistrer");
			}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String nomT = this.txtNomT.getText();
			String prenomT = this.txtPrenomT.getText();
			String disponibilite = this.txtDisponibilite.getSelectedItem().toString();
			float tarifHoraire = Float.parseFloat(this.txtTarifHoraire.getText());

			//instanciation d'une classe
			Technicien unTechnicien = new Technicien (nomT, prenomT, disponibilite, tarifHoraire);

			//insertion dans la base de données
			Controleur.insertTechnicien(unTechnicien);
			JOptionPane.showMessageDialog(this, "technicien ajouter avec succès");
			//recuperetion de l'id de la classe de la BDD
			unTechnicien = Controleur.selectWhereTechnicien(nomT, prenomT);

			//mettre à jour l'affichage
			Object ligne[]= {unTechnicien.getMatricule(), nomT, prenomT, disponibilite, tarifHoraire};
			this.unTableau.ajouterLigne(ligne);
			this.nbTechniciens = unTableau.getRowCount();
			this.lbTitre.setText("Nombre de technicien : " + this.nbTechniciens);
			this.txtNomT.setText("");
			this.txtPrenomT.setText("");
			//this.txtDisponibilite.setText("");
			this.txtTarifHoraire.setText("");

		}
		else if (e.getSource()== this.btFiltrer) {
			String filtre = this.txtFiltre.getText();
			Object matrice[][] = this.remplirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
		}
		else if (e.getSource()== this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String nomT = this.txtNomT.getText();
			String prenomT = this.txtPrenomT.getText();
			String disponibilite = this.txtDisponibilite.getSelectedItem().toString();
			float tarifHoraire = Float.parseFloat(this.txtTarifHoraire.getText());
	
			int numLigne = this.tableTechniciens.getSelectedRow();
			int idLigne = Integer.parseInt(this.tableTechniciens.getValueAt(numLigne, 0).toString());
			//instaciation de la classe 
			Technicien unTechnicien = new Technicien(idLigne, nomT, prenomT, disponibilite, tarifHoraire);
			//modification de la base de données :
			Controleur.updateTechnicien(unTechnicien);
			//modification de la table d'affichage
			Object ligne[] = {idLigne, nomT, prenomT, disponibilite, tarifHoraire};
			this.unTableau.modifierLigne(numLigne, ligne);
			//on vide le formulaire
			this.txtNomT.setText("");
			this.txtPrenomT.setText("");
			//this.txtDisponibilite.setText("");
			this.txtTarifHoraire.setText("");
			this.btEnregistrer.setText("Enregistrer");

		}
	 }
	}
 