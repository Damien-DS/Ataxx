package ataxx.jeu;
import ataxx.visuel.*;
import java.util.*;
/**
 * Class Joueur
 */
public class Joueur {

  //
  // Champs
  //

  private Couleur couleur;
  private String Nom;
  private int nombreDePion = 0;
  private Plateau plateauDeJeu;
  private Scanner scan;
  private boolean abandon = false;
  private ArrayList<Position> historiqueDeMouvement;
  
  //
  // Constructeurs
  //

  public Joueur (Couleur c, String Nom, Plateau pJ, Scanner scan) {
    couleur = c;
    this.Nom= Nom;
    plateauDeJeu = pJ; 
    this.scan = scan;
    historiqueDeMouvement = new ArrayList<Position>();
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
   * Change la valeur du champ Nom
   * @param nouvelleValeur nouvelle valeur de Nom
   */
  public void changerNom (String nouvelleValeur) {
    Nom = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ Nom
   * @return la valeur du champ Nom
   */
  public String retournerNom () {
    return Nom;
  }

  /**
   * Change la valeur du champ nombreDePion
   * @param nouvelleValeur nouvelle valeur de nombreDePion
   */
  public void changerNombreDePion (int nouvelleValeur) {
    nombreDePion = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ nombreDePion
   * @return la valeur du champ nombreDePion
   */
  public int retournerNombreDePion () {
    return nombreDePion;
  }

  /**
   * Change la valeur du champ plateauDeJeu
   * @param nouvelleValeur nouvelle valeur de plateauDeJeu
   */
  public void changerPlateauDeJeu (Plateau nouvelleValeur) {
    plateauDeJeu = nouvelleValeur;
  }


  /**
   * Retourne la valeur du champ plateauDeJeu
   * @return la valeur du champ plateauDeJeu
   */
  public Plateau retournerPlateauDeJeu () {
    return plateauDeJeu;
  }


  public void changerHistoriqueDeMouvement( ArrayList<Position> nouvelleValeur) {
    historiqueDeMouvement = nouvelleValeur;
  }

  /**
   * /**
   * Retourne la valeur du champ historiqueDeMouvement
   * @return la valeur du champ historiqueDeMouvement;
   */
  public ArrayList<Position> retournerHistoriqueDeMouvement() {
    return historiqueDeMouvement;  
  }
  public boolean retournerAbandon() {
    return abandon;
  }

  //
  // Autres méthodes
  //

  /**
   * Méthode pour ajouter une postition après un mouvement à l'historique
   * @param positionApresMouvement position à ajouter à l'historique
   */
  public void ajouterMouvementAHistorique(Position positionApresMouvement) {
    historiqueDeMouvement.add(positionApresMouvement);
  }

  /**
   * Méthode pour reinitialiser l'historique
   */
  public void reinitialiserHistorique() {
    historiqueDeMouvement.clear();
  }
  /**
   * Méthode pour ajouter le compte de Pion gagné
   */
  public void ajouterNbPion(int nbPion) {
    nombreDePion += nbPion;
  }

   /**
   * Méthode pour retirer le compte de Pion perdu
   */
  public void retirerNbPion(int nbPion) {
    nombreDePion -= nbPion;
  }

  /**
   * Méthode pour changer le champ abandon et le passé a true (le joueur abandonne)
   */
  public void abandonner() {
    abandon = true;  
  }

  /**
   * Méthode pour passer un tour
   */
  public void passer() {
  }
  
  /**
   * Méthode pour lire le mouvement relatif souhaité dans le terminal
   * @return       MouvementRelatif
   */
  public MouvementRelatif lireAction() {
    String retour;
    retour = scan.next();   
    return plateauDeJeu.retournerMouvementRelatifHachage().getOrDefault(retour, new MouvementRelatif(100, 100));
  }


  /**
   * Méthode pour lire la position du pion choisi dans le terminal
   * @return       Position
   */
  public Position lirePionChoisi() {
    String retour;
    retour = scan.next(); 
    return plateauDeJeu.retournerPositionCaseHachage().getOrDefault(retour, new Position(100, 100));    
  }


 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    return "Nom : " + Nom + ", Couleur : " + couleur + Couleur.NORMALE_FOR;
  }
}
