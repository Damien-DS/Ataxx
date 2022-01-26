package ataxx.cases;
import ataxx.visuel.*;

/**
 * Class Pion
 */
public class Pion {

  //
  // Champs
  //

  private Couleur couleur;
  
  //
  // Constructeurs
  //
  public Pion (Couleur c) {
    couleur = c;
  }
  
  //
  // Methodes :

  //
  // Methodes accesseures
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

  //
  // Autres méthodes
  //

 
 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    return "" + couleur + "  " + Couleur. NORMALE_BCK;
  }
}
