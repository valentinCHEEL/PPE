package controleur;

import vue.VueGenerale;
import vue.vueConnexion;

public class PPESOG {
	private static vueConnexion uneVueConnexion ;
	private static VueGenerale uneVueGenerale ;
	

	public static void main(String[] args) {
		uneVueConnexion = new vueConnexion();
		
	}
	
	public static void rendreVisibleConnexion (boolean action) {
		uneVueConnexion.setVisible(action);
	}
	
	public static void rendreVisibleGenerale (boolean action, User unUser) {
		if(action == true) {
			uneVueGenerale = new VueGenerale(unUser);
			uneVueGenerale.setVisible(true);
		} else {
			uneVueGenerale.dispose();
		}
	}
}


