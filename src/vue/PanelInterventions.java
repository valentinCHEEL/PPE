package vue;
 
import java.awt.Color;
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
import controleur.Intervention;
import controleur.Tableau;
 
public class PanelInterventions extends PanelPrincipal implements ActionListener {
			private JPanel panelForm = new JPanel ();
			private JTextField txtDateAffectation = new JTextField();
			private JTextField txtDateArrive = new JTextField();
			private JTextField txtDateFin = new JTextField();
			private JComboBox<String> txtEtat = new JComboBox<String>();
			private JTextField txtLibelleMateriel= new JTextField();
			private JTextField txtMatricule = new JTextField();
			private JButton btAnnuler = new JButton("Annuler");
			private JButton btEnregistrer = new JButton("Enregistrer");
			
			//table des classes
			private JTable tableInterventions ;
			private int nbInterventions;
			private JLabel lbTitre = new JLabel("Nombre d'interventions : ");
			
			private JScrollPane uneScroll ;
			
			//panel de filtrage
			
			private JPanel panelFiltre = new JPanel();
			private JTextField txtFiltre = new JTextField();
			private JButton btFiltrer = new JButton("Filtrer");
			
			private Tableau unTableau ;
			
			public PanelInterventions() {
			super ();
			//Constructeur du formulaire Classe.
			this.panelForm.setLayout(new GridLayout(7,2));
			this.panelForm.setBackground(new Color (255, 145, 77));
			this.panelForm.setBounds(10, 10, 300, 300);
			this.panelForm.add(new JLabel("DateAffectation :"));
			this.panelForm.add(this.txtDateAffectation);
			this.panelForm.add(new JLabel("dateArrive :"));
			this.panelForm.add(this.txtDateArrive);
			this.panelForm.add(new JLabel("dateFin  :"));
			this.panelForm.add(this.txtDateFin);
			this.panelForm.add(new JLabel("etat :"));
			this.panelForm.add(this.txtEtat);
			this.panelForm.add(new JLabel("libelleMateriel :"));
			this.panelForm.add(this.txtLibelleMateriel);
			this.panelForm.add(new JLabel("matricule :"));
			this.panelForm.add(this.txtMatricule);
			this.panelForm.add(this.btAnnuler);
			this.panelForm.add(this.btEnregistrer);
			this.panelForm.setVisible(true);
			this.add(this.panelForm);
			
			
			//construction de la table des classes
			String entetes [] = {"numI", "dateAffectation ", " dateArrive "," dateFin "," etat "," libelleMateriel"};
			this.unTableau = new Tableau(entetes, this.remplirDonnees(""));
			
			this.tableInterventions = new JTable(this.unTableau);
			this.tableInterventions.getTableHeader().setReorderingAllowed(false);
			this.uneScroll = new JScrollPane(this.tableInterventions);
			this.uneScroll.setBounds(350, 80, 460, 230);
			this.add(this.uneScroll);
			
			//construction du panel filtre
			this.panelFiltre.setBounds(400, 30, 400, 30);
			this.panelFiltre.setBackground(new Color (255, 145, 77));
			this.panelFiltre.setLayout(new GridLayout(1, 3));
			this.panelFiltre.add(new JLabel("Filtrer les interventions par :"));
			this.panelFiltre.add(this.txtFiltre);
			this.panelFiltre.add(btFiltrer);
			this.add(this.panelFiltre);
			
			
			//rendre les boutons ecoutables
		    this.btAnnuler.addActionListener(this);
		    this.btEnregistrer.addActionListener(this);
		    this.btFiltrer.addActionListener(this);
		    
		    //placement du titre
		    this.lbTitre.setBounds(200 , 330, 300, 20);
		    this.nbInterventions = this.unTableau.getRowCount();
		    this.lbTitre.setText("Nombre d'interventions: " + this.nbInterventions);
		    this.add(this.lbTitre);
		    
		    
		  //remplir le type du client 
		    this.txtEtat.addItem("en cours");
		    this.txtEtat.addItem("accepter");
		    this.txtEtat.addItem("refuser");
		    this.txtEtat.addItem("terminer");
		    
		    //suppresion d'une classe
		    this.tableInterventions.addMouseListener(new MouseListener() {
				
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
		        int numI;
		        if (e.getClickCount()>= 2) {
		        	numLigne = tableInterventions.getSelectedRow();
		        	numI = Integer.parseInt(tableInterventions.getValueAt(numLigne, 0).toString());
		        	int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous confirmer la suppression?", "Suppression de l'intervention", JOptionPane.YES_NO_OPTION);
		        	if (reponse == 0) {
		        		// confirmation de la suppresion dans la BDD
		        		Controleur.deleteIntervention(numI);
		        		//confirmation de la suppression dans l'affichage des classes
		        		unTableau.supprimerLigne(numLigne);
		        		nbInterventions = unTableau.getRowCount();
		        		lbTitre.setText("Nombre d'interventions : " + nbInterventions);
		        	}
		        }
		        else if (e.getClickCount()==1) {
		        	numLigne = tableInterventions.getSelectedRow();
		        	txtDateAffectation.setText(tableInterventions.getValueAt(numLigne,1).toString());
		        	txtDateArrive.setText(tableInterventions.getValueAt(numLigne,2).toString());
		        	txtDateFin.setText(tableInterventions.getValueAt(numLigne,3).toString());
		        	//txtEtat(tableInterventions.getValueAt(numLigne,4).toString());
		        	txtLibelleMateriel.setText(tableInterventions.getValueAt(numLigne,4).toString());
		        	btEnregistrer.setText("Modifier");
		        }
					
				}
			});
 
		  }
	



			public Object [][] remplirDonnees (String filtre){
				//cette méthode permet de convertire l'ArrayListe en une matrice de donnés.
				ArrayList<Intervention> lesInterventions = Controleur.selectAllInterventions(filtre);
				Object [][] matrice = new Object [lesInterventions.size()][7];
				int i =0;
				for (Intervention uneIntervention: lesInterventions) {
					matrice [i][0] = uneIntervention.getNumI();
					matrice [i][1] = uneIntervention.getDateAffectation();
					matrice [i][2] = uneIntervention.getDateArrive();
					matrice [i][3] = uneIntervention.getDateFin();
					matrice [i][4] = uneIntervention.getEtat();
					matrice [i][5] = uneIntervention.getLibelleMateriel();
					matrice [i][6] = uneIntervention.getMatricule();
					
					i++;
				}
				return matrice;
			}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.btAnnuler) {
				this.txtDateAffectation.setText("");
				this.txtDateArrive.setText("");
				this.txtDateFin.setText("");
				//this.txtEtat("");
				this.txtLibelleMateriel.setText("");
				
				this.btEnregistrer.setText("Enregistrer");
				}
			else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
				String dateAffectation = this.txtDateAffectation.getText();
				String dateArrive = this.txtDateArrive.getText();
				String dateFin = this.txtDateFin.getText();
				String etat = this.txtEtat.getSelectedItem().toString();
				String libelleMateriel = this.txtLibelleMateriel.getText();
				int matricule = Integer.parseInt(this.txtMatricule.getText());
				//instanciation d'une classe
				
				Intervention uneIntervention = new Intervention( dateAffectation, dateArrive , dateFin, etat, libelleMateriel, matricule);
				
				
				//insertion dans la base de données
				Controleur.insertIntervention(uneIntervention);
				JOptionPane.showMessageDialog(this, "Intervention ajouter avec succès");
				
				//recuperation de l'id de l'etudiant  de la BDD
				uneIntervention = Controleur.selectWhereIntervention (dateAffectation, dateArrive ,dateFin,etat,libelleMateriel);
				
				
				//mettre à jour l'affichage
				Object ligne[]= {uneIntervention.getNumI(), dateAffectation, dateArrive , dateFin, etat, libelleMateriel, matricule};
				this.unTableau.ajouterLigne(ligne);
				this.nbInterventions = unTableau.getRowCount();
				this.lbTitre.setText("Nombre d'Intervention : " + this.nbInterventions);
				this.txtDateAffectation.setText("");
				this.txtDateArrive.setText("");
				this.txtDateFin.setText("");
				//this.txtEtat.setText("");
				this.txtLibelleMateriel.setText("");
				
			}
			else if (e.getSource()== this.btFiltrer) {
				String filtre = this.txtFiltre.getText();
				Object matrice[][] = this.remplirDonnees(filtre);
				this.unTableau.setDonnees(matrice);
			}
			else if (e.getSource()== this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
				String dateAffectation = this.txtDateAffectation.getText();
				String dateArrive = this.txtDateArrive.getText();
				String dateFin = this.txtDateFin.getText();
				String etat = this.txtEtat.getSelectedItem().toString();
				String libelleMateriel = this.txtLibelleMateriel.getText();
				int matricule = Integer.parseInt(this.txtMatricule.getText());
				
				int numLigne = this.tableInterventions.getSelectedRow();
				int idLigne = Integer.parseInt(this.tableInterventions.getValueAt(numLigne, 0).toString());
				//instaciation de la classe
				Intervention uneIntervention = new Intervention(idLigne, dateAffectation, dateArrive , dateFin, etat, libelleMateriel, matricule);
				//modification de la base de données :
				Controleur.updateIntervention(uneIntervention);
				//modification de la table d'affichage
				Object ligne[] = {idLigne,  dateAffectation, dateArrive , dateFin, etat, libelleMateriel, matricule};
				this.unTableau.modifierLigne(numLigne, ligne);
				//on vide le formulaire
				this.txtDateAffectation.setText("");
				this.txtDateArrive.setText("");
				this.txtDateFin.setText("");
				//this.txtEtat.setText("");
				this.txtLibelleMateriel.setText("");
				
				
				this.btEnregistrer.setText("Enregistrer");
				
			}
		 }
		
 
	
	}
 