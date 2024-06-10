package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.PPESOG;
import controleur.Technicien;
import controleur.User;

public class VueGenerale extends JFrame implements ActionListener{
	private JPanel panelMenu = new JPanel();
	private JButton btClients = new JButton("Clients");
	private JButton btTechniciens = new JButton("Techniciens");
	private JButton btContrats= new JButton("Contrats");
	private JButton btInterventions = new JButton("Interventions");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btProfil = new JButton ("Profil");

	//instanciation des panels : 
	private PanelProfil unPanelProfil;
	private PanelClients unPanelClient = new PanelClients();
	private PanelTechniciens unPanelTechnicien = new PanelTechniciens();
	private PanelContrats unPanelContrat = new PanelContrats();
	private PanelInterventions unPanelIntervention= new PanelInterventions();

	public VueGenerale(User unUser) {
		this.setTitle("SOG");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 0, 130));
		this.setLayout(null);
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		
		//instanciation du panel profil
		this.unPanelProfil = new PanelProfil(unUser);
		
		//placement du menu
		this.panelMenu.setBounds(30, 10, 800, 30);
		this.panelMenu.setBackground(new Color(0, 0, 130));
		this.panelMenu.setLayout(new GridLayout(1, 7));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btTechniciens);
		this.panelMenu.add(this.btContrats);
		this.panelMenu.add(this.btInterventions);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		//rendre les boutons ecoutables
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.btContrats.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btProfil.addActionListener(this);
		
		//ajout des panels dans la fenetre 
		this.add(this.unPanelProfil);
		this.add(this.unPanelClient);
		this.add(this.unPanelTechnicien);
		this.add(this.unPanelContrat);
		this.add(this.unPanelIntervention);
		
		this.setVisible(true);
	}
	
	public void afficherPanel (int choix ) {
		this.unPanelClient.setVisible(false);
		this.unPanelTechnicien.setVisible(false);
		this.unPanelContrat.setVisible(false);
		this.unPanelIntervention.setVisible(false);
		this.unPanelProfil.setVisible(false);
		switch (choix) {
		case 1 : unPanelClient.setVisible(true); break;
		case 2 : unPanelTechnicien.setVisible(true); break;
		case 3 : unPanelContrat.setVisible(true); break;
		case 5 : unPanelIntervention.setVisible(true); break;
		case 6 : unPanelProfil.setVisible(true); break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btQuitter) {
			PPESOG.rendreVisibleGenerale(false, null);
			PPESOG.rendreVisibleConnexion(true);
		}
		else if (e.getSource()== this.btClients) {
			this.afficherPanel(1);
		}
		
		else if (e.getSource()== this.btTechniciens) {
			this.afficherPanel(2);
		}
		
		else if (e.getSource()== this.btContrats) {
			this.afficherPanel(3);
		}
	
		
		else if (e.getSource()== this.btInterventions) {
			this.afficherPanel(5);
		}
		
		else if (e.getSource()== this.btProfil) {
			this.afficherPanel(6);
		}
		
	}

}

