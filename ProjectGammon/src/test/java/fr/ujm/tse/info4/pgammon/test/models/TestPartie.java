package fr.ujm.tse.info4.pgammon.test.models;

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.NiveauAssistant;
import fr.ujm.tse.info4.pgammon.models.ParametreJeu;
import fr.ujm.tse.info4.pgammon.models.Partie;


public class TestPartie {

	/**
	 * Dans cette classe on va simuler l'interface graphique
	 * en appelant les méthode partie comme le ferais l'interface.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//comment récuperer ce que l'utilisateur saisie.
		//Scanner sc = new Scanner(System.in);
		//String str = sc.nextLine();
		
		System.out.println("Lancement du test de la Partie");
		
		// creation des parametre et joueur
		Joueur jBlanc = new Joueur(1, "ben", "beauGoss",
				NiveauAssistant.NON_UTILISE);
		Joueur jNoir = new Joueur(2, "JM", "null",
				NiveauAssistant.COMPLET);
		ParametreJeu param = new ParametreJeu(0, 3, true, jBlanc, jNoir);
		Partie p = new Partie(param);
		
		
		

	}

}
