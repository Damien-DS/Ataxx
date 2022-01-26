package ataxx.cases;
import ataxx.visuel.*;
/**
 * Class Case_Obstacle
 */
public class Case_Obstacle extends Case {

  //
  // Champs
  //
  private Couleur couleurObstacle;
  
  //
  // Constructeurs
  //
  public Case_Obstacle (Couleur c) {
    super(c);
    couleurObstacle = Couleur.GRIS_BCK;
  }
  
  //
  // Methods
  //


  //
  // Méthodes accesseuses
  //
  /**
   * Change la valeur du champ couleurObstacle
   * @param nouvelleValeur nouvelle valeur de couleurObstacle
   */
  public void changerCouleurObstacle (Couleur nouvelleValeur) {
    couleurObstacle = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ couleurObstacle
   * @return la valeur du champ couleurObstacle
   */
  public Couleur retournerCouleurObstacle () {
    return couleurObstacle;
  }

  //
  // Autres méthodes
  //
 
 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    return "" + "["  + retournerCouleur() + couleurObstacle + "  " + Couleur.NORMALE_BCK + "]" + Couleur.NORMALE_FOR;
  }
}
