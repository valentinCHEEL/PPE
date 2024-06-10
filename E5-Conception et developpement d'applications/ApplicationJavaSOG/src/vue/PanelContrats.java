package vue;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 

 
import controleur.Controleur;
import controleur.Client;
import controleur.Contrat;
import controleur.Tableau;
 
public class PanelContrats extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel();
	private JTextField txtDatefin = new JTextField();
	private JTextField txtDatev = new JTextField();
	private JTextField txtMontantmht = new JTextField();
	private JTextField txtNumclient = new JTextField();
	
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableContrats ; //table des contrats
	private JScrollPane uneScroll ;
	
	//panel de filtrage
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");
	
	private Tableau unTableau ;
	
	private int nbContrats ;
	private JLabel lbTitre = new JLabel("Nombre de contrats : ");
	
	public PanelContrats()
	{
		super();
		//construction du formulaire Contrat
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.setBackground(new Color (0, 0, 130));
		this.panelForm.setBounds(10, 60, 250, 300);
		this.panelForm.add(new JLabel("Date de fin :"));
		this.panelForm.add(this.txtDatefin);
		this.panelForm.add(new JLabel("Date de validite :"));
		this.panelForm.add(this.txtDatev);
		this.panelForm.add(new JLabel("Montant mensuel HT"));
		this.panelForm.add(this.txtMontantmht);
		this.panelForm.add(new JLabel("Client"));
		this.panelForm.add(this.txtNumclient);
		
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
		
		//construction de la table des étudiants
		String entetes [] = {"ID Contrat", "Datefin ", "Datev ", "Montantmht", "Client"};
		this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
		
		this.tableContrats = new JTable(this.unTableau);
		this.tableContrats.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableContrats);
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);
		
		//construction du panel filtre
		this.panelFiltre.setBounds(400, 30, 400, 30);
		this.panelFiltre.setBackground(new Color (255, 255, 255));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les contrats par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(this.btFiltrer);
		this.add(this.panelFiltre);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltrer.addActionListener(this);
		
		//placement des titres
		this.lbTitre.setBounds(200, 330, 300, 20);
		this.nbContrats = this.unTableau.getRowCount();
		this.lbTitre.setText("Nombre de contrats : " + this.nbContrats);
		this.add(this.lbTitre);
		
		//suppression d'un contrat
		this.tableContrats.addMouseListener(new MouseListener() {
			
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
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne ;
				int numContrat ;
				if (e.getClickCount() >= 2) {
					numLigne = tableContrats.getSelectedRow();
					numContrat = Integer.parseInt(tableContrats.getValueAt(numLigne, 0).toString());
					int reponse = JOptionPane.showConfirmDialog(null,  "Voulez vous confirmer la suppression ?", "Suppression du contrat",
							JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						//confirmation de la suppression dans la bdd
						Controleur.deleteContrat(numContrat);
						//confirmation de la suppression dans l'affichage des contrats
						unTableau.supprimerLigne(numLigne);
						nbContrats = unTableau.getRowCount();
						lbTitre.setText("Nombre de contrats : " + nbContrats);
					}
				}
				else if (e.getClickCount() == 1) {
					numLigne = tableContrats.getSelectedRow();
					txtDatefin.setText(tableContrats.getValueAt(numLigne,1).toString());
					txtDatev.setText(tableContrats.getValueAt(numLigne,2).toString());
					txtMontantmht.setText(Float.toString(Float.parseFloat(tableContrats.getValueAt(numLigne, 4).toString())));
					//txtIdClient.setText(tableContrats.getValueAt(numLigne,4).toString());
					btEnregistrer.setText("Modifier");
				}
			}
		} );
		
	}
		public Object [][] remplirDonnees (String filtre){
			//permet de convertir l'arraylist en une matrice de données
			ArrayList<Contrat> lesContrats = Controleur.selectAllContrats(filtre);
			Object [][] matrice = new Object [lesContrats.size()][6];
			int i =0;
			for (Contrat unContrat : lesContrats) {
				matrice [i][0] = unContrat.getNumcontrat();
				matrice [i][1] = unContrat.getDatefin();
				matrice [i][2] = unContrat.getDatev();
				matrice [i][3] = unContrat.getMontantmht();
				matrice [i][4] = unContrat.getNumclient();
				i++;
			}
			return matrice;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtDatefin.setText("");
			this.txtDatev.setText("");
			this.txtMontantmht.setText(Float.toString(0.0f));
			//this.txtIdClient.setText("");
			this.btEnregistrer.setText("Enregistrer");
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String datefin = this.txtDatefin.getText();
			String datev = this.txtDatev.getText();
			float montantmht = Float.parseFloat(this.txtMontantmht.getText());
			int numclient = Integer.parseInt(this.txtNumclient.getText()); 
			
			//instanciation d'un contrat
			Contrat unContrat = new Contrat (datefin, datev, montantmht, numclient);
			
			//insertion dans la base de données
			Controleur.insertContrat(unContrat);
			JOptionPane.showMessageDialog(this, "Contrat ajoutée avec succès");
			
			//recupération de l'id de la contrat de la BDD
			unContrat = Controleur.selectWhereContrat ( datefin,  datev, montantmht);
			
			//mettre à jour l'affichage
			Object ligne[]= {unContrat.getNumcontrat(), datefin, datev, montantmht, numclient};
			this.unTableau.ajouterLigne(ligne);
			
			this.nbContrats = unTableau.getRowCount();
			this.lbTitre.setText("Nombre de contrats : " + this.nbContrats);
			
			this.txtDatefin.setText("");
			this.txtDatev.setText("");
			this.txtMontantmht.setText("");
			//this.txtNumclient.setText("");
		}
		else if (e.getSource() == this.btFiltrer) {
			String filtre = this.txtFiltre.getText();
			Object matrice [][] = this.remplirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String datefin = this.txtDatefin.getText();
			String datev = this.txtDatev.getText();
			float montantmht = Float.parseFloat(this.txtMontantmht.getText());
			int numclient = Integer.parseInt(this.txtNumclient.getText());
			
			int numLigne = this.tableContrats.getSelectedRow();
			int idLigne = Integer.parseInt(this.tableContrats.getValueAt(numLigne, 0).toString());
			//instanciation du contrat
			Contrat unContrat = new Contrat(idLigne, datefin, datev, montantmht, numclient);
			//modification dans la base de donnée :
			Controleur.updateContrat(unContrat);
			//modification dans le tableau d'affichage
			Object ligne[] = {idLigne, datefin, datev, montantmht, numclient};
			this.unTableau.modifierLigne(numLigne, ligne);
			//on vide le formulaire
			this.txtDatefin.setText("");
			this.txtDatev.setText("");
			this.txtMontantmht.setText("");
			this.btEnregistrer.setText("Enregistrer");
		}
	}
}
 