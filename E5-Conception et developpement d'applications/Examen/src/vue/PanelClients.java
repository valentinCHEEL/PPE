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

import controleur.Client;
import controleur.Controleur;
import controleur.Tableau;

public class PanelClients extends PanelPrincipal implements ActionListener {
	private JPanel panelForm = new JPanel ();
	private JTextField txtNomclient = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCodepostal = new JTextField();
	private JTextField txtNumtel = new JTextField();
	private JTextField txtAdressemail = new JTextField();
	private JComboBox<String> txtTypeclient = new JComboBox<String>();
	private JTextField txtSiret = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	
	
	//table des clients
		private JTable tableClients ; 
		private int nbClients;
		private JLabel lbTitre = new JLabel("Nombre de clients : ");
		
		private JScrollPane uneScroll ;
		
		//panel de filtrage
		
		private JPanel panelFiltre = new JPanel();
		private JTextField txtFiltre = new JTextField();
		private JButton btFiltrer = new JButton("Filtrer");
		
		private Tableau unTableau ;
	
	public PanelClients () {
		super ();
		//Constructeur du formulaire Classe.	
		this.panelForm.setLayout(new GridLayout(9,2));
		this.panelForm.setBackground(new Color (0, 0, 130));
		this.panelForm.setBounds(10, 10, 300, 300);
		this.panelForm.add(new JLabel("Nomclient :"));
		this.panelForm.add(this.txtNomclient);
		this.panelForm.add(new JLabel("Adresse :"));
		this.panelForm.add(this.txtAdresse);
		this.panelForm.add(new JLabel("Ville  :"));
		this.panelForm.add(this.txtVille);
		this.panelForm.add(new JLabel("Codepostal :"));
		this.panelForm.add(this.txtCodepostal);
		this.panelForm.add(new JLabel("Numtel :"));
		this.panelForm.add(this.txtNumtel);
		this.panelForm.add(new JLabel("Adressemail :"));
		this.panelForm.add(this.txtAdressemail);
		this.panelForm.add(new JLabel("Typeclient :"));
		this.panelForm.add(this.txtTypeclient);
		this.panelForm.add(new JLabel("siret :"));
		this.panelForm.add(this.txtSiret);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.setVisible(true);
		this.add(this.panelForm);
		// Définir la couleur du texte pour les composants dans panelForm
	    Component[] components = this.panelForm.getComponents();
	    Color textColor = Color.WHITE;
	    for (Component component : components) {
	        if (component instanceof JTextField || component instanceof JLabel) {
	            component.setForeground(textColor);
	        }
	    }
	    
		//construction de la table de clients
		String entetes [] = {"ID", "Nom ", "Adresse "," Ville "," Code postal "," Num tel" ," Adresse mail", "Type client", "Siret"};
		this.unTableau = new Tableau(entetes, this.remplirDonnees(""));
		
		this.tableClients = new JTable(this.unTableau);
		this.tableClients.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableClients);
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);
		
		//construction du panel filtre
		this.panelFiltre.setBounds(400, 30, 400, 30);
		this.panelFiltre.setBackground(new Color (255, 255, 255));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les clients par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(btFiltrer);
		this.add(this.panelFiltre);
		
		//rendre les boutons ecoutables
	    this.btAnnuler.addActionListener(this);
	    this.btEnregistrer.addActionListener(this);
	    this.btFiltrer.addActionListener(this);
	    
	  //placement du titre 
	    this.lbTitre.setBounds(200 , 330, 300, 20);
	    this.nbClients = this.unTableau.getRowCount();
	    this.lbTitre.setText("Nombre de clients : " + this.nbClients);
	    this.add(this.lbTitre);
	    
	  //remplir le type du client 
	    this.txtTypeclient.addItem("entreprise");
	    this.txtTypeclient.addItem("particulier");
	    
	    this.tableClients.addMouseListener(new MouseListener() {

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
	        int numClient;
	        if (e.getClickCount()>= 2) {
	        	numLigne = tableClients.getSelectedRow();
	        	numClient = Integer.parseInt(tableClients.getValueAt(numLigne, 0).toString());
	        	int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous confirmer la suppression?", "Suppression de l'etudiant", JOptionPane.YES_NO_OPTION);
	        	if (reponse == 0) {
	        		// confirmation de la suppresion dans la BDD
	        		Controleur.deleteClient(numClient);
	        		//confirmation de la suppression dans l'affichage des clients
	        		unTableau.supprimerLigne(numLigne);
	        		nbClients = unTableau.getRowCount();
	        		lbTitre.setText("Nombre de clients : " + nbClients);
	        	}
	        }
	        else if (e.getClickCount()==1) {
	        	numLigne = tableClients.getSelectedRow();
	        	txtNomclient.setText(tableClients.getValueAt(numLigne,1).toString());
	        	txtAdresse.setText(tableClients.getValueAt(numLigne,2).toString());
	        	txtVille.setText(tableClients.getValueAt(numLigne,3).toString());
	        	txtCodepostal.setText(tableClients.getValueAt(numLigne,4).toString());
	        	txtNumtel.setText(tableClients.getValueAt(numLigne,5).toString());
	        	txtAdressemail.setText(tableClients.getValueAt(numLigne,6).toString());
	        	//txttypeclient.setText(tableClients.getValueAt(numLigne,4).toString());
	        	txtSiret.setText(tableClients.getValueAt(numLigne,7).toString());
	        	btEnregistrer.setText("Modifier");
	        }
				
			}
		});

	  }
	
	public Object [][] remplirDonnees (String filtre){
		//cette méthode permet de convertire l'ArrayListe en une matrice de donnés.
		ArrayList<Client> lesClients = Controleur.selectAllClients(filtre);
		Object [][] matrice = new Object [lesClients.size()][9];
		int i =0;
		for (Client unClient: lesClients) {
			matrice [i][0] = unClient.getNumclient();
			matrice [i][1] = unClient.getNomclient();
			matrice [i][2] = unClient.getAdresse();
			matrice [i][3] = unClient.getVille();
			matrice [i][4] = unClient.getCodepostal();
			matrice [i][5] = unClient.getNumtel();
			matrice [i][6] = unClient.getAdressemail();
			matrice [i][7] = unClient.getTypeclient();
			matrice [i][8] = unClient.getSiret();
			
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtNomclient.setText("");
			this.txtAdresse.setText("");
			this.txtVille.setText("");			
			this.txtCodepostal.setText("");
			this.txtNumtel.setText("");
			this.txtAdressemail.setText("");
			//this.txtTypeclient.setText("");
			this.txtSiret.setText("");
			this.btEnregistrer.setText("Enregistrer");
			}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String nomclient = this.txtNomclient.getText();
			String adresse = this.txtAdresse.getText();
			String ville = this.txtVille.getText();
			int codepostal = Integer.parseInt(this.txtCodepostal.getText());			
			int numtel = Integer.parseInt(this.txtNumtel.getText());
			String adressemail = this.txtAdressemail.getText();
			String typeclient = this.txtTypeclient.getSelectedItem().toString();
			int siret = Integer.parseInt(this.txtSiret.getText());
			
			//instanciation d'un client
			
			Client unClient = new Client( nomclient, adresse, ville, codepostal , numtel, adressemail, typeclient, siret);

			//insertion dans la base de données
			Controleur.insertClient(unClient);
			JOptionPane.showMessageDialog(this, "Client ajouté avec succès");
			
			//recuperation de l'id du client  de la BDD
			unClient = Controleur.selectWhereClient (nomclient ,adressemail);
			
			//mettre à jour l'affichage
			Object ligne[]= {unClient.getNumclient(), nomclient, adresse, ville, codepostal, numtel, adressemail, typeclient, siret};
			this.unTableau.ajouterLigne(ligne);
			this.nbClients = unTableau.getRowCount();
			
			this.lbTitre.setText("Nombre de clients : " + this.nbClients);
			this.txtNomclient.setText("");
			this.txtAdresse.setText("");
			this.txtVille.setText("");		
			this.txtCodepostal.setText("");
			this.txtNumtel.setText("");
			this.txtAdressemail.setText("");
			//this.txtTypeclient.setText("");
			this.txtSiret.setText("");
		}
		
		else if (e.getSource()== this.btFiltrer) {
			String filtre = this.txtFiltre.getText();
			Object matrice[][] = this.remplirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
		}
		
		else if (e.getSource()== this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String nomclient = this.txtNomclient.getText();
			String adresse = this.txtAdresse.getText();
			String ville = this.txtVille.getText();			
			int codepostal = Integer.parseInt(this.txtCodepostal.getText());
			int numtel = Integer.parseInt(this.txtNumtel.getText());
			String adressemail = this.txtAdressemail.getText();
			String typeclient = this.txtTypeclient.getSelectedItem().toString();
			int siret = Integer.parseInt(this.txtSiret.getText());
			
			int numLigne = this.tableClients.getSelectedRow();
			int idLigne = Integer.parseInt(this.tableClients.getValueAt(numLigne, 0).toString());
			
			//instaciation du client 
			Client unClient = new Client(idLigne, nomclient, adresse, ville, codepostal, numtel, adressemail, typeclient, siret);
			
			//modification de la base de données :
			Controleur.updateClient(unClient);
			
			//modification de la table d'affichage
			Object ligne[] = {idLigne, nomclient, adresse, ville, codepostal, numtel, adressemail, typeclient};
			this.unTableau.modifierLigne(numLigne, ligne);
			
			//on vide le formulaire
			this.txtNomclient.setText("");
			this.txtAdresse.setText("");
			this.txtVille.setText("");			
			this.txtCodepostal.setText("");
			this.txtNumtel.setText("");
			this.txtAdressemail.setText("");
			//this.txtTypeclient.setText("");
			this.txtSiret.setText("");
			this.btEnregistrer.setText("Enregistrer");
		}
	 }
	}

