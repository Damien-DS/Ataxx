package ataxx.cases;
import ataxx.visuel.*;
/**
 * Class Case
 */
public class Case {

  //
  // Champs
  //

  private Couleur couleur;
  
  //
  // Constructeurs
  //
  public Case() {
    couleur = Couleur.GRIS_FOR;
  }
  public Case (Couleur c) {
    couleur = c;
  }
  
  //
  // Methods
  //


  //
  // Méthodes accesseuses
  //  

    /**
   * Change la valeur du champ couleur
   * @param nouvelleValeur nouvelle valeur de couleur
   */
  public void changerCouleur (Couleur nouvelleValeur) {
    couleur = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ couleur
   * @return la valeur du champ couleur
   */
  public Couleur retournerCouleur () {
    return couleur;
  }

   /**
   * Méthode pour changer la couleur de la case
   * @param        couleurDeLaCase
   */
  public void changerCouleurCase(Couleur couleurDeLaCase) {
    couleur = couleurDeLaCase;
  }

  //
  // Autres méthodes
  //

 
 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    return "" + couleur + "[  ]" + Couleur.NORMALE_FOR;
  }
}
