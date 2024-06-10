package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.PPESOG;
import controleur.User;

public class vueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel panelConnexion = new JPanel();
	private JTextField txtEmail = new JTextField("a@gmail.com");
	private JPasswordField txtMdp = new JPasswordField("123");
	private JButton btSeconnecter = new JButton("Se connecter");
	private JButton btAnnuler = new JButton("Annuler");
	
	public vueConnexion() {
		this.setTitle("SOG");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0, 0, 130));
		this.setLayout(null);
		this.setBounds(200, 200, 600, 300);
		this.setResizable(false);
		
		//placemen du logo 
		ImageIcon uneImage = new ImageIcon ("");
		JLabel unLogo = new JLabel(uneImage);
		unLogo.setBounds(30, 20, 240, 290);
		this.add(unLogo);
		
		//placement du panel 
		this.panelConnexion.setBounds(300, 40, 250, 200);
		this.panelConnexion.setBackground(new Color(0, 0, 130));
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.add(new JLabel("Email :"));
		this.panelConnexion.add(this.txtEmail);
		this.panelConnexion.add(new JLabel("Mot de passe :"));
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeconnecter);
		this.panelConnexion.setVisible(true);
		this.add(this.panelConnexion);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btSeconnecter.addActionListener(this);
		
		//rendre les txtEMail et textMdp ecoutables
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource()==this.btSeconnecter) {
			this.traitement ();
		}
		
	}
	public void traitement () {
		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		//on verifie dans la base 
		User unUser = Controleur.selectWhereUSer(email, mdp);
		if (unUser != null) {
			JOptionPane.showMessageDialog(this, "Bienvenue"  + unUser.getNom() + " " + unUser.getPrenom());
			
			// on appelle la vue generale
			PPESOG.rendreVisibleGenerale(true, unUser);
			PPESOG.rendreVisibleConnexion(false);
		
		
		
	}else {
		JOptionPane.showMessageDialog(this, "veuillez vérifier vos identifiants");
	}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()== KeyEvent.VK_ENTER) {
			this.traitement();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
