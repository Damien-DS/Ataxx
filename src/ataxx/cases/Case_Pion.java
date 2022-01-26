package ataxx.cases;
import ataxx.visuel.*;
/**
 * Class Case_Pion
 */
public class Case_Pion extends Case {

  //
  // Champs
  //

  private Pion pionDansLaCase;
  
  //
  // Constructeurs
  //
  public Case_Pion(Couleur couleurPion) {
    super();
    pionDansLaCase = new Pion(couleurPion);
  }
  public Case_Pion (Couleur c, Couleur couleurPion) {
    super(c);
    pionDansLaCase = new Pion(couleurPion);
  }
  
  //
  // Methods
  //


  //
  // Méthodes accesseuses
  //

  /**
   * Change la valeur du champ PionDansLaCase
   * @param nouvelleValeur nouvelle valeur de PionDansLaCase
   */
  public void changerPionDansLaCase (Pion nouvelleValeur) {
    pionDansLaCase = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ PionDansLaCase
   * @return la valeur du champ PionDansLaCase
   */
  public Pion retournerPionDansLaCase () {
    return pionDansLaCase;
  }

  //
  // Autres méthodes
  //

 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    return "" + retournerCouleur() + "["+ pionDansLaCase + "]" + Couleur.NORMALE_FOR;
  }
}
