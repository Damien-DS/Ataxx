package ataxx.jeu;
import ataxx.visuel.*;
import java.util.*;


/**
 * Class Jeu
 */
public class Jeu {

  //
  // Champs
  //

  private Plateau plateauDeJeu;
  private Joueur joueur[];
  private Joueur joueurAyantLaMain;
  private Joueur adversaire;
  static final private Scanner scan = new Scanner(System.in);
  static final private Hashtable<String,Couleur> StringVersCouleur = new Hashtable<String,Couleur>();;
  
  //
  // Constructeurs
  //

  /**
   * Constructeur par défaut
   */
  public Jeu () {
    plateauDeJeu = new Plateau(this);
    joueur = new Joueur[2];
    joueur[0] = new Joueur(Couleur.BLEU_BCK, "Joueur 1", plateauDeJeu, scan);
    joueur[1] = new Joueur(Couleur.ROUGE_BCK, "Joueur 2", plateauDeJeu ,scan);
    int indiceJoueur= (int)(Math.random()*2);
    System.out.println(" indice J1"+ indiceJoueur );
    joueurAyantLaMain = joueur[indiceJoueur];
    int indiceAdversaire = (indiceJoueur == 1) ? 0 : 1;
    System.out.println(" indice J2"+ indiceAdversaire );
    adversaire = joueur[indiceAdversaire];
    joueurAyantLaMain.ajouterNbPion(1);
    adversaire.ajouterNbPion(1);
    plateauDeJeu.initPlateau();
    Messages.joueurCourant(joueurAyantLaMain);
  }
  /**
   * Constructeur surchargé
   * @param coulJ1 Couleur du Joueur 1
   * @param nomJ1 nom du Joueur 1
   * @param coulJ2 Couleur du Joueur 2
   * @param nomJ2 nom du Joueur 2
   */
  public Jeu (String coulJ1, String nomJ1, String coulJ2, String nomJ2) {
    coulJ1 = coulJ1.toLowerCase();
    coulJ2 = coulJ2.toLowerCase();
    StringVersCouleur.put(new String("bleu"), Couleur.BLEU_BCK);
    StringVersCouleur.put(new String("normale"), Couleur.NORMALE_BCK);
    StringVersCouleur.put(new String("rouge"), Couleur.ROUGE_BCK);
    StringVersCouleur.put(new String("vert"), Couleur.VERT_BCK);
    StringVersCouleur.put(new String("jaune"), Couleur.JAUNE_BCK);
    StringVersCouleur.put(new String("rouge"), Couleur.ROUGE_BCK);
    StringVersCouleur.put(new String("gris"), Couleur.GRIS_BCK);
    plateauDeJeu = new Plateau(this);
    joueur = new Joueur[2];
    joueur[0] = new Joueur(StringVersCouleur.getOrDefault(coulJ1, Couleur.BLEU_BCK), nomJ1, plateauDeJeu, scan);
    joueur[1] = new Joueur(StringVersCouleur.getOrDefault(coulJ2, Couleur.ROUGE_BCK), nomJ2, plateauDeJeu, scan);
    int indiceJoueur= (int)(Math.random()*2);
    joueurAyantLaMain = joueur[indiceJoueur];
    int indiceAdversaire = (indiceJoueur == 1) ? 0 : 1;
    adversaire = joueur[indiceAdversaire];
    plateauDeJeu.initPlateau();
    Messages.joueurCourant(joueurAyantLaMain);
  }
  
  //
  // Methods
  //


  //
  // Méthodes accesseuses
  //

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

  

  /**
   * Change la valeur du champ joueur[] (tableau contenant les 2 joueurs)
   * @param nouvelleValeur nouvelle valeur de joueur[] (tableau contenant les 2 joueurs)
   */
  public void changerJoueur (Joueur[] nouvelleValeur) {
    joueur = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ joueur[] (tableau contenant les 2 joueurs)
   * @return la valeur du champ joueur[] (tableau contenant les 2 joueurs)
   */
  public Joueur[] retournerJoueur () {
    return joueur;
  }

  /**
   * Change la valeur du champ joueurAyantLaMain
   * @param nouvelleValeur nouvelle valeur de joueurAyantLaMain
   */
  public void changerJoueurAyantLaMain (Joueur nouvelleValeur) {
    joueurAyantLaMain = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ joueurAyantLaMain
   * @return la valeur du champ joueurAyantLaMain
   */
  public Joueur retournerJoueurAyantLaMain () {
    return joueurAyantLaMain;
  }

    /**
   * Change la valeur du champ adversaire
   * @param nouvelleValeur nouvelle valeur de adversaire
   */
  public void changerAdversaire (Joueur nouvelleValeur) {
    adversaire = nouvelleValeur;
  }

  /**
   * Retourne la valeur du champ adversaire
   * @return la valeur du champ adversaire
   */
  public Joueur retournerAdversaire () {
    return adversaire;
  }

  //
  // Autres méthodes
  //

  /**
   * Méthode pour afficher le plateau
   */
  public void afficherPlateau() {
    System.out.println(plateauDeJeu);
  }

  /**
   * Méthode pour que le joueur courant choisisse 
   * une position correcte ou passe ou abandonne
   * @return        la position choisie
   */
  public Position choixPosition(){
    Messages.afficherMessage(Messages.SAISIR_PION);
    Position pos = joueurAyantLaMain.lirePionChoisi();
    while (!plateauDeJeu.estPositionCorrecte(pos, joueurAyantLaMain)) {
      if (Position.estAbandon(pos)) {
        return pos;
      }
      else if (Position.aPasser(pos)) {
        return pos;
      }
      if (plateauDeJeu.estUnePositionDeLaTableDeHachage(pos)) {
        Messages.afficherMessage(Messages.PION_ADVERSE);
      }
      else {
        Messages.afficherMessage(Messages.PION_INCORRECT);
      }
      afficherPlateau();
      Messages.afficherMessage(Messages.SAISIR_PION);
      pos = joueurAyantLaMain.lirePionChoisi();
    }
    plateauDeJeu.colorerSelection(pos);
    plateauDeJeu.colorerVoisins(pos);
    afficherPlateau();
    return pos;
  }

  /**
   * Méthode pour que le joueur courant choisisse 
   * un mouvement correcte ou passe ou abandonne
   * @return le mouvement choisi
   */
  public MouvementRelatif choixMouvementRelatif(Position pos) {
    Messages.afficherMessage(Messages.SAISIR_MOUVEMENT);
    MouvementRelatif mouv = joueurAyantLaMain.lireAction();
    while (!plateauDeJeu.estMouvementAutorise(pos, mouv)) {
      if (MouvementRelatif.estAbandon(mouv)) {
        return mouv;
      }
      else if (MouvementRelatif.aPasser(mouv)) {
        return mouv;
      }
      if (!plateauDeJeu.estDansPlateauDeJeu(pos, mouv)) {
        Messages.afficherMessage(Messages.MOUVEMENT_HORS_PLATEAU);
      }      
      else if (!plateauDeJeu.estLibre(plateauDeJeu.caseAPositionXY(pos,mouv))) {
        Messages.afficherMessage(Messages.CASE_OCCUPE);
      }
      else {
        Messages.afficherMessage(Messages.MOUVEMENT_INCORRECT);
      } 
      afficherPlateau() ;
      Messages.afficherMessage(Messages.SAISIR_MOUVEMENT);
      mouv = joueurAyantLaMain.lireAction();   
    }
    afficherPlateau();
    return mouv;
  }

  /**
   * Méthode pour réaliser un mouvement et tous ce que cela implique
   * (infection, pert/gain de pion,...)
   * @param pos position de la case source
   * @param mouv mouvement a réaliser
   */
  public void mouvement(Position pos , MouvementRelatif mouv) {
    int nbDePionGagner = 0;
    int nbDePionVole = 0;
    joueurAyantLaMain.ajouterMouvementAHistorique(new Position(pos.x+mouv.x, pos.y+mouv.y));
    nbDePionGagner += plateauDeJeu.bougerPion(pos, mouv);
    nbDePionVole += plateauDeJeu.infection(new Position(pos.x+mouv.x, pos.y+mouv.y));
    nbDePionGagner += nbDePionVole;
    joueurAyantLaMain.ajouterNbPion(nbDePionGagner);
    adversaire.retirerNbPion(nbDePionVole);
    afficherPlateau();
    if (nbDePionVole > 0){
      Messages.afficherMessage(Messages.INFECTE_LADVERSAIRE);
    }   
  }

  /**
   * Méthode pour réaliser verifier si le joueur n'essaie pas de bloquer le jeu
   * (3 répétition des mêmes aller-retour)
   */
  public boolean antiJeu() {
    ArrayList<Position> historiqueMouv = joueurAyantLaMain.retournerHistoriqueDeMouvement(); 
    int lastIndex = historiqueMouv.size()-1;
    if (historiqueMouv.isEmpty()) {
      return false;
    }
    else if(historiqueMouv.size() < 3) {
      return false;
    }
    else if (!historiqueMouv.get(lastIndex).equals(historiqueMouv.get(lastIndex-2))) {
        joueurAyantLaMain.reinitialiserHistorique();
    }
    else if (historiqueMouv.size() < 6){
      System.out.println(""+ historiqueMouv.get(lastIndex));
      return false;
    }
    else {
      return true;
    }
    return false;
  }

  /**
   * Méthode pour déterminer si le jeu est terminé
   * (Abandon, anti-jeu, plus de place sur le plateu)
   * @return 1 si le joueur ayant la main gagne
   * @return -1 si le joueur adverse gagne
   * @return 0 si le jeu continue
   */
  public int jeuEstIlTermine() {
    if (plateauDeJeu.estPlein() || adversaire.retournerNombreDePion() == 0) {
      Messages.afficherMessage(Messages.A_GAGNE,joueurAyantLaMain);
      return 1; //joueurAyantLaMainAgagne<
    }
    else if (joueurAyantLaMain.retournerAbandon()) {
      Messages.afficherMessage(Messages.ABANDON,joueurAyantLaMain);
      Messages.afficherMessage(Messages.A_GAGNE,adversaire);
      return -1;
    }
    else if (antiJeu()) {
      Messages.afficherMessage(Messages.A_GAGNE,adversaire);
      return -1; //adversaire a gagne
    }
    return 0; //Jeu pas termine
  }

  /**
   * Lance le jeu
   */
  public void lancerJeu(){
    int jeuEnCours = 0;
    while(jeuEnCours == 0) {
      tourJoueur();
      jeuEnCours = jeuEstIlTermine();
      changementJoueur();
    }
    scan.close();
  }

  /**
   * Méthode pour intervertir le joueur ayant la main et son adversaire
   */
  public void changementJoueur() {
    Joueur swap;
    swap = joueurAyantLaMain;
    joueurAyantLaMain = adversaire;
    adversaire = swap;
    Messages.joueurCourant(joueurAyantLaMain);
  }
  
  
  /**
   * Méthode trairant le tour d'un joueur
   */
  public void tourJoueur() {
    Position pos;
    MouvementRelatif mouv;
    afficherPlateau();
    pos = choixPosition();
    if (Position.estAbandon(pos)) {
      joueurAyantLaMain.abandonner();
      return;
    }
    else if (Position.aPasser(pos)) {
      Messages.afficherMessage(Messages.A_PASSE);
      return;
    }
    mouv = choixMouvementRelatif(pos);
    if (MouvementRelatif.estAbandon(mouv)) {
      plateauDeJeu.decolorerVoisins(pos);
      joueurAyantLaMain.abandonner();
      return;
    }
    else if (MouvementRelatif.aPasser(mouv)) {
      plateauDeJeu.decolorerVoisins(pos);
      return;
    }
    plateauDeJeu.decolorerVoisins(pos);
    mouvement(pos, mouv);
  }
  
  public static void main(String[] args) {
    Jeu jeu = new Jeu();
    jeu.lancerJeu();
  }

enum Messages {
  SAISIR_PION,
  PION_INCORRECT,
  PION_ADVERSE,
  PION_HORS_PLATEAU,
  SAISIR_MOUVEMENT,
  MOUVEMENT_INCORRECT,
  CASE_OCCUPE,
  MOUVEMENT_HORS_PLATEAU,
  INFECTE_LADVERSAIRE,
  PASSE_SON_TOUR,
  ABANDON,
  A_PASSE,
  A_GAGNE;

  private static Joueur joueurCourant;

  public static void joueurCourant(Joueur joueur) {
    joueurCourant = joueur;
  }

  public static void afficherMessage(Messages mes) {
    System.out.println(mes);
  }
  public static void afficherMessage(Messages mes,Joueur joueur) {
    System.out.println(mes.toString(joueur));
  }

 @Override
 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 public String toString() {
      String affichage = "" + joueurCourant.retournerCouleur() + "[" + joueurCourant.retournerNom() + "]" + Couleur.NORMALE_BCK + " : " ;
          switch (this) {
      case SAISIR_PION :
          affichage = affichage + "Saisir la case du pion à jouer : (saisir \"quitter\" pour quitter ou \"passer\") ";
          break;
      case PION_INCORRECT :
          affichage = affichage + "Saisie incorrecte de la case du pion !\n";
          break;
      case PION_ADVERSE :
          affichage = affichage + "Cette case ne contient pas un des Pions du joueur !\n";
          break;
      case PION_HORS_PLATEAU :
          affichage = affichage + "La case saisie n'est pas dans le plateau de jeu !\n";
          break;
      case SAISIR_MOUVEMENT :
          affichage = affichage + "Saisir le mouvement à réaliser : (saisir \"quitter\" pour quitter ou \"passer\") ";
          break;
      case MOUVEMENT_INCORRECT :
          affichage = affichage + "Saisie du mouvement incorrecte ! \n";
          break;
      case MOUVEMENT_HORS_PLATEAU :
          affichage = affichage + "Le mouvement saisie est en dehors du plateau !\n";
          break;
      case INFECTE_LADVERSAIRE :
          affichage = affichage + "INFECTION !!\n";
          break;
      case PASSE_SON_TOUR :
          affichage = affichage + "Passe son tour";
          break;
      case CASE_OCCUPE : 
          affichage = affichage + "La case est déja occupée";
          break;
      case A_GAGNE : 
          affichage = affichage + " a gagné !!!";
          break;
      case A_PASSE : 
          affichage = affichage + " a passé le tour";
          break;
      case ABANDON : 
          affichage = affichage + " a abandoné :`(";
          break;
      }
      return affichage;
    }
  public String toString(Joueur joueur) {
    String affichage = "" + joueur.retournerCouleur() + "[" + joueur.retournerNom() + "]" + Couleur.NORMALE_BCK + " : " ;
        switch (this) {
    case SAISIR_PION :
        affichage = affichage + "Saisir la case du pion à jouer : (saisir \"quitter\" pour quitter ou \"passer\") ";
        break;
    case PION_INCORRECT :
        affichage = affichage + "Saisie incorrecte de la case du pion !\n";
        break;
    case PION_ADVERSE :
        affichage = affichage + "Cette case ne contient pas un des Pions du joueur !\n";
        break;
    case PION_HORS_PLATEAU :
        affichage = affichage + "La case saisie n'est pas dans le plateau de jeu !\n";
        break;
    case SAISIR_MOUVEMENT :
        affichage = affichage + "Saisir le mouvement à réaliser : (saisir \"quitter\" pour quitter ou \"passer\") ";
        break;
    case MOUVEMENT_INCORRECT :
        affichage = affichage + "Saisie du mouvement incorrecte ! \n";
        break;
    case MOUVEMENT_HORS_PLATEAU :
        affichage = affichage + "Le mouvement saisie est en dehors du plateau !\n";
        break;
    case INFECTE_LADVERSAIRE :
        affichage = affichage + "INFECTION !!\n";
        break;
    case PASSE_SON_TOUR :
        affichage = affichage + "Passe son tour";
        break;
    case CASE_OCCUPE : 
        affichage = affichage + "La case est déja occupée";
        break;
    case A_GAGNE : 
        affichage = affichage + " a gagné !!!";
        break;
    case A_PASSE : 
        affichage = affichage + " a passé le tour";
        break;
    case ABANDON : 
        affichage = affichage + " a abandoné :`(";
        break;
    }
    return affichage;
  }
}}
    
