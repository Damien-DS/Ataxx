package ataxx.jeu;
import java.util.*;
import ataxx.cases.*;
import ataxx.visuel.*;

/**
 * Class Plateau
 */
public class Plateau {

  //
  // Champs
  //
  Hashtable<String, Position> positionCaseHachage;
  Hashtable<String, MouvementRelatif> mouvementRelatifHachage;
  
  private Case cases[][];
  private Jeu jeu;
  
  //
  // Constructeurs
  //
  public Plateau (Jeu j) {
    jeu = j;
    cases = new Case[7][7];
    positionCaseHachage = new Hashtable<String,Position>();
    mouvementRelatifHachage = new Hashtable<String,MouvementRelatif>();
    for (int i = 0; i < cases.length; i++) {
      for (int k = 0; k < cases.length; k++) {
        positionCaseHachage.put(""+ i + k, new Position(i, k));
      }
    }
    positionCaseHachage.put("quitter", new Position(Position.ABANDON, Position.ABANDON));
    positionCaseHachage.put("passer", new Position(Position.PASSER, Position.PASSER));
    mouvementRelatifHachage.put("57", new MouvementRelatif(-2, -2));
    mouvementRelatifHachage.put("587", new MouvementRelatif(-1, -2));
    mouvementRelatifHachage.put("58", new MouvementRelatif(0, -2));
    mouvementRelatifHachage.put("589", new MouvementRelatif(1, -2));
    mouvementRelatifHachage.put("59", new MouvementRelatif(2, -2));

    mouvementRelatifHachage.put("547", new MouvementRelatif(-2, -1));
    mouvementRelatifHachage.put("7", new MouvementRelatif(-1, -1));
    mouvementRelatifHachage.put("8", new MouvementRelatif(0, -1));
    mouvementRelatifHachage.put("9", new MouvementRelatif(1, -1));
    mouvementRelatifHachage.put("569", new MouvementRelatif(2, -1));

    mouvementRelatifHachage.put("54", new MouvementRelatif(-2, 0));
    mouvementRelatifHachage.put("4", new MouvementRelatif(-1, 0));
    
    mouvementRelatifHachage.put("6", new MouvementRelatif(1, 0));
    mouvementRelatifHachage.put("56", new MouvementRelatif(2, 0));

    mouvementRelatifHachage.put("541", new MouvementRelatif(-2, 1));
    mouvementRelatifHachage.put("1", new MouvementRelatif(-1, 1));
    mouvementRelatifHachage.put("2", new MouvementRelatif(0, 1));
    mouvementRelatifHachage.put("3", new MouvementRelatif(1, 1));
    mouvementRelatifHachage.put("563", new MouvementRelatif(2, 1));

    mouvementRelatifHachage.put("51", new MouvementRelatif(-2, 2));
    mouvementRelatifHachage.put("521", new MouvementRelatif(-1, 2));
    mouvementRelatifHachage.put("52", new MouvementRelatif(0, 2));
    mouvementRelatifHachage.put("523", new MouvementRelatif(1, 2));
    mouvementRelatifHachage.put("53", new MouvementRelatif(2, 2));
    mouvementRelatifHachage.put("quitter", new MouvementRelatif(MouvementRelatif.ABANDON, MouvementRelatif.ABANDON));
    mouvementRelatifHachage.put("passer", new MouvementRelatif(MouvementRelatif.PASSER, MouvementRelatif.PASSER));
  }
  
  //
  // Methods
  //


  //
  // Méthodes accesseuses
  //
   /**
   * Change la valeur du champ mouvementRelatifHachage
   * @param nouvelleValeur nouvelle valeur de mouvementRelatifHachage
   */
  public void changerMouvementRelatifHachage(Hashtable<String, MouvementRelatif> nouvelleValeur) {
      this.mouvementRelatifHachage = nouvelleValeur;
  }


  /**
   * Retourne la valeur du champ mouvementRelatifHachage
   * @return la valeur du champ mouvementRelatifHachage
   */
  public Hashtable<String, MouvementRelatif> retournerMouvementRelatifHachage() {
      return mouvementRelatifHachage;
  }

   /**
   * Change la valeur du champ positionCaseHachage
   * @param nouvelleValeur nouvelle valeur de positionCaseHachage
   */
  public void changerPositionCaseHachage(Hashtable<String, Position> nouvelleValeur) {
      this.positionCaseHachage = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ positionCaseHachage
   * @return la valeur du champ positionCaseHachage
   */
  public Hashtable<String, Position> retournerPositionCaseHachage() {
      return positionCaseHachage;
  }

  /**
   * Change la valeur du champ Cases[][]
   * @param nouvelleValeur nouvelle valeur de Cases[][]
   */
  public void changerCases(Case[][] nouvelleValeur) {
    cases = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ Cases[][]
   * @return la valeur du champ Cases[][]
   */
  public Case[][] retournerCases() {
    return cases;
  }

  /**
   * Change la valeur du champ jeu
   * @param nouvelleValeur nouvelle valeur de jeu
   */
  public void changerJeu (Jeu nouvelleValeur) {
    jeu = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ jeu
   * @return la valeur du champ jeu
   */
  public Jeu retournerJeu () {
    return jeu;
  }

  //
  // Autres méthodes
  //

  public Case caseAPositionXY(Position pos) {
    return cases[pos.x][pos.y];
  }

  public Case caseAPositionXY(Position pos, MouvementRelatif mR) {
    return cases[pos.x+mR.x][pos.y+mR.y];
  }

  /**
   * Méthode d'initialisation du plateau
   */
  public void initPlateau() {
    for (int i = 0; i < cases.length; i++) {
      for (int j = 0; j < cases.length; j++) {
        if (i == 0 && j == 0) {
          cases[i][j] = new Case_Pion(jeu.retournerJoueurAyantLaMain().retournerCouleur());
        }
        else if (i == 6 && j == 6) {
          cases[i][j] = new Case_Pion(jeu.retournerAdversaire().retournerCouleur());
        }
        else if ((i == 2 || i == 4) && (j == 2 || j == 4))
        {
          cases[i][j] = new Case_Obstacle(Couleur.NORMALE_FOR);
        }
        else
        {
          cases[i][j] = new Case_Vide();
        }
        
      }
    }
  }


 

  /**
   * Méthode pour colorer les voisin de la case a la position en paramètre
   * @param        positionCase
   */
  public void colorerVoisins(Position positionCase) {
    for (int i = -2; i <= 2; i++) {
      for (int j = -2; j <= 2; j++) {
        if (positionCase.x+i <= 6 && positionCase.y+j <= 6 && positionCase.x+i >= 0 && positionCase.y+j >= 0)
        {
          if ((i > -2 && i < 2) && (j > -2 && j < 2) && !(i == 0 && j == 0) ) {
            cases[positionCase.x+i][positionCase.y+j].changerCouleurCase(Couleur.VERT_FOR);
          }
          else if (!(j == 0 && i ==0 )) {
            cases[positionCase.x+i][positionCase.y+j].changerCouleurCase(Couleur.MAGENTA_FOR);
          }
        }
      }
    }    
  }
  /**
   * Méthode pour colorer la case a la position en paramètre
   * @param        pos
   */
  public void colorerSelection(Position pos) {
    cases[pos.x][pos.y].changerCouleurCase(Couleur.JAUNE_FOR);
  }

  /**
   * Méthode pour décolorer les voisin de la case a la position en paramètre
   * @param        positionCase
   */
  public void decolorerVoisins(Position positionCase) {
    for (int i = -2; i <= 2; i++) {
      for (int j = -2; j <= 2; j++) {
        if (positionCase.x+i <= 6 && positionCase.y+j <= 6 && positionCase.x+i >= 0 && positionCase.y+j >= 0)
        {
          cases[positionCase.x+i][positionCase.y+j].changerCouleurCase(Couleur.NORMALE_FOR);
        }
      }
    }   
  }


  /**
   * Méthode pour déterminer si la case en paramètre est Libre
   * @return      booléen
   * @param       caseATester
   */
  public boolean estLibre(Case caseATester) {
    if (estObstacle(caseATester) || estAdversaire(caseATester)) {
      return false;
    }
    return true;
  }

   /**
   * Méthode pour déterminer si la case en paramètre contient un Obstacle
   * @return      booléen
   * @param       caseATester
   */
  public boolean estObstacle(Case caseATester) {
    return caseATester.getClass() == Case_Obstacle.class;
  }

   /**
   * Méthode pour déterminer si la case en paramètre contient un Pion
   * @return      booléen
   * @param       caseATester
   */
  public boolean contientPion(Case caseATester) {
    return caseATester.getClass() == Case_Pion.class;
  }

  /**
   * Méthode pour déterminer si le Pion que contient la case en paramètre (si elle en contient un)
   * est a l'adversaire
   * @return      booléen
   * @param       caseATester
   */
  public boolean estAdversaire(Case caseATester) {
    Case_Pion caseAvecPion;
    if (caseATester.getClass() == Case_Pion.class) {
      caseAvecPion = (Case_Pion)caseATester;
      if (caseAvecPion.retournerPionDansLaCase().retournerCouleur() == 
          jeu.retournerAdversaire().retournerCouleur()) {
        return true;  
      }
    }
    return false;
  }
  /**
   * Méthode pour déterminer si le Pion que contient la case en paramètre (si elle en contient un)
   * est au joueur ayant la main
   * @return      booléen
   * @param       pos positon de la case à tester
   * @param       j joueur pour la vérification
   */
  public boolean estUneCaseAvecUnPionDuJoueur(Position pos, Joueur j) {
    if (contientPion(cases[pos.x][pos.y])) {
      Case_Pion casePion = (Case_Pion)cases[pos.x][pos.y];
      if (casePion.retournerPionDansLaCase().retournerCouleur() == j.retournerCouleur()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Méthode pour déterminer si la case à la position en paramètre est à l'interieur du plateau
   * @return      booléen
   * @param       pos positon de la case à tester
   */
  public boolean estDansPlateauDeJeu(Position pos) {
    if (((pos.x) <= 6 && (pos.x) >= 0) && ((pos.y) <= 6 && (pos.y) >= 0)) {
      return true;
    }
    return false;
  }
 /**
   * Méthode surchargée pour déterminer si la case à la position (avec mouvement) en paramètre est à l'interieur du plateau
   * @return      booléen
   * @param       pos positon de la case à tester
   */
  public boolean estDansPlateauDeJeu(Position pos, MouvementRelatif mR) {
    if (((pos.x+mR.x) <= 6 && (pos.x+mR.x) >= 0) && ((pos.y+mR.y) <= 6 && (pos.y+mR.y) >= 0)) {
      return true;
    }
    return false;
  }
  
  /**
   * Méthode pour déterminer si la position en paramètre 
   * est une position contenue dans la table de hachage
   * @return      booléen
   * @param       pos positon de la case à tester
   */

  public boolean estUnePositionDeLaTableDeHachage(Position pos) {
    if (positionCaseHachage.contains(pos)) {
      return true;
    }
    return false;
  }

  /**
   * Méthode pour déterminer si la position en paramètre est utilisable pour le jeu
   * @return      booléen
   * @param       pos positon de la case à tester
   * @param       j joueur ayant fait l'action
   */
  public boolean estPositionCorrecte(Position pos, Joueur j) {
    if (estUnePositionDeLaTableDeHachage(pos) && !(Position.estAbandon(pos)|| Position.aPasser(pos))) {
      if (estUneCaseAvecUnPionDuJoueur(pos, j)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Méthode pour déterminer si le mouvement et la position en paramètre sont correctes
   * et donnent une position dans le plateau
   * @param       pos positon de la case à tester
   * @param       mR mouvement relatif a faire
   */
  public boolean estMouvementAutorise(Position pos, MouvementRelatif mR) {
    if (mouvementRelatifHachage.contains(mR) && !(MouvementRelatif.estAbandon(mR)|| MouvementRelatif.aPasser(mR))) {
      if (estDansPlateauDeJeu(pos,mR))
        if (estLibre(caseAPositionXY(pos, mR))) {
         {
          return true;
        }
      }      
    }
    return false;
  }

   /**
   * Méthode pour savoir si le plateau est plein (fin du jeu)
   * @return      booléen
   */
  public boolean estPlein() {
    for (int i = 0; i < cases.length; i++) {
      for (int j = 0; j < cases.length; j++) {
        if (cases[i][j].getClass()== Case_Vide.class) {
          return false;
        }
      }
    }
    return true;
  }

   /**
   * Méthodes pour cloner un Pion
   * @param        positionPion
   * @param        mR
   */
  public void clonerBougerPion(Position positionPion, MouvementRelatif mR) {
    cases[positionPion.x+mR.x][positionPion.y+mR.y] = new Case_Pion(jeu.retournerJoueurAyantLaMain().retournerCouleur());
  }


  /**
   * Méthodes pour déplacer un Pion
   * @param        positionPion
   * @param        mR
   */
  public void deplacerPion(Position positionPion, MouvementRelatif mR) {
    Case swap;
    swap = cases[positionPion.x][positionPion.y];
    cases[positionPion.x][positionPion.y] = cases[positionPion.x+mR.x][positionPion.y+mR.y];
    cases[positionPion.x+mR.x][positionPion.y+mR.y] = swap;
  }

   /**
    * Méthode pour faire un mouvement de Pion (deplacer ou clonage)
   * @return       booléen
   * @param        positionPion
   * @param        mR
   */
  public int bougerPion(Position positionPion, MouvementRelatif mR) {
    if ((mR.x > 1 || mR.x < -1 ) || (mR.y > 1 || mR.y < -1 )) {
      deplacerPion(positionPion, mR);
      return 0;
    }
    else {
      clonerBougerPion(positionPion, mR);
      return 1;
    }
  }


  /**
   * Méthode pour placer un Pion du joueur
   * @param        positionPion
   * @param        joueur
   */
  public void placerPion(Position positionPion, Joueur joueur) {
    cases[positionPion.x][positionPion.y] = new Case_Pion(joueur.retournerCouleur());
  }


  /**
   * Méthode pour infecter les cases de l'adveraire situés
   * à coté de la case à la position en paramètre
   * @param        positionPion
   */
  public int infection(Position positionPion) {
    int retour = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        Position posActuelle = new Position(positionPion.x+i, positionPion.y+j);
        if (estDansPlateauDeJeu(posActuelle)) {
          if (estAdversaire(caseAPositionXY(posActuelle))) {
            cases[positionPion.x+i][positionPion.y+j] = new Case_Pion(jeu.retournerJoueurAyantLaMain().retournerCouleur());
            retour++;
          }
        }
      }
    }
    if (retour > 0) {
      jeu.afficherPlateau();
      try {
        Thread.sleep(1000);    
      } catch (Exception e) {
      }
    }
    return retour;
  }


  /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
    StringBuffer plateauString = new StringBuffer();
    plateauString.insert(0, '\n');
    for (int i = cases.length-1 ; i >= 0; i--) {
      plateauString.insert(0, " " + i + " ");
      for (int j = cases.length-1 ; j >= 0; j--) {
      plateauString.insert(0, cases[j][i]);
      }
      plateauString.insert(0, '\n');
    }
    for (int i = cases.length-1 ; i >= 0; i--) {
      plateauString.insert(0, "  ");
      plateauString.insert(0, "" + i);
      plateauString.insert(0, " ");
    }
    plateauString.insert(0, '\n');
    return plateauString.toString();
  }

  public static void main(String[] args) {
    Plateau plat = new Plateau(new Jeu());
    plat.initPlateau();
    plat.retournerCases()[0][0].changerCouleurCase(Couleur.BLEU_FOR);
    System.out.println(plat);
    plat.colorerVoisins(new Position(4, 5));
    System.out.println(plat);
    plat.decolorerVoisins(new Position(4, 5));
    System.out.println(plat);
    plat.colorerVoisins(new Position(0, 0));
    System.out.println(plat);
    plat.decolorerVoisins(new Position(0, 0));
    System.out.println(plat);
  }
}