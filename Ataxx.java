import ataxx.jeu.*;
import ataxx.visuel.*;
import ataxx.cases.*;

public class Ataxx {
    public static void main(String[] args) {
        if (args.length == 4) {
            Jeu jeu = new Jeu(args[0],args[1],args[2],args[3]); 
            jeu.lancerJeu();   
        }
        else if (args.length != 0) {
            System.out.println("Veuillez donner aucun argument ou \"Couleur_J1 Nom_J1 Couleur_J2 Nom_J2\" ");        }
        else {
            Jeu jeu = new Jeu();
            jeu.lancerJeu();
        }
        
    }
}