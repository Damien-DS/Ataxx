package ataxx.visuel;

/**
 * @author M. Marchetti
 * Voici une énumarétion permettant de colorer votre terminal de type GNU-Linux.
 * Je rappelle que l'environnement de programmation pour l'évaluation de votre
 * projet sera de type GNU-Linux.
 * 
 * Vous pourrez personnaliser cette énumaration en lui ajoutant d'autres méthodes
 * si besoin (ce qui était le cas de mon implémentation personnelle).
 * 
 * Enfin, comme le sujet vous le montre, le "gameplay" fait apparaître un
 * affichage sur-mesure pour aider les joueurs à visualiser les choix possibles
 * qui s'offrent à eux. Pour faire cela facilement (i.e. lisiblement au niveau de
 * votre code source), je vous suggère de définir une autre énumeration
 * permettant de définir un statut/marque/état pour vos différents éléments au
 * cours du temps (le / indiquant une liste de choix de vocabulaire selon vos
 * attentes/besoins).
*/
public enum Couleur {
    // FOR : foreground (couleur des caractères).
    // BCK : background (couleur du fond).
    BLEU_FOR, BLEU_BCK,
    ROUGE_FOR, ROUGE_BCK,
    VERT_FOR, VERT_BCK,
    JAUNE_FOR, JAUNE_BCK,
    MAGENTA_FOR, MAGENTA_BCK,
    GRIS_FOR, GRIS_BCK,
    NORMALE_FOR, NORMALE_BCK;
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   @Override
 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 public String toString() {
	String affichage = "";
        switch (this) {
	case BLEU_FOR :
	    affichage = "\u001B[94m";
	    break;
	case BLEU_BCK :
	    affichage = "\u001B[104m";
	    break;
	case ROUGE_FOR :
	    affichage = "\u001B[91m";
	    break;
	case ROUGE_BCK :
	    affichage = "\u001B[101m";
	    break;
	case VERT_FOR :
	    affichage = "\u001B[32m";
	    break;
	case VERT_BCK :
	    affichage = "\u001B[42m";
	    break;
	case JAUNE_FOR :
	    affichage = "\u001B[93m";
	    break;
	case JAUNE_BCK :
	    affichage = "\u001B[103m";
	    break;
	case MAGENTA_FOR :
	    affichage = "\u001B[95m";
	    break;
	case MAGENTA_BCK :
	    affichage = "\u001B[105m";
	    break;
	case GRIS_FOR :
	    affichage = "\u001B[37m";
	    break;
	case GRIS_BCK :
	    affichage = "\u001B[47m";
	    break;
	case NORMALE_FOR :
	    affichage = "\u001B[37m";
	    break;
	case NORMALE_BCK :
	    affichage = "\u001B[40m";
	    break;
	}
	return affichage;
    }

	/**
	 * Méthodes pour verifier si la couleur est identique à celle en paramètre
	 * @param coul
	 * @return
	 * Finalement un "==" fonctionne très bien pour cette énumération
	 */
	@Deprecated
	public boolean equals(Couleur coul) {
		if (toString().compareTo(coul.toString()) == 0){
			return true;
		}
		return false;
	}
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static void main(String args[]) {
	// Exemple (pas hyper joli du reste).
	System.out.println(Couleur.BLEU_FOR + "La " +
			   Couleur.NORMALE_FOR + " " + 
			   Couleur.ROUGE_FOR + "couleur, " +
			   " " + 
			   Couleur.VERT_BCK + "c'est " +
			   Couleur.NORMALE_BCK +
			   Couleur.JAUNE_FOR + "bien" +
			   Couleur.GRIS_FOR + "..." +
			   Couleur.NORMALE_FOR + "pratique !");
    }
}
