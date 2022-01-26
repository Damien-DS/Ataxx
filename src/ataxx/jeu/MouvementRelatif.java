package ataxx.jeu;
public class MouvementRelatif {
    int x;
    int y;
    final static int ABANDON = -100;
    final static int PASSER = -200;
    MouvementRelatif(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public static boolean estAbandon(MouvementRelatif mouvementATester) {
      if (mouvementATester.x == MouvementRelatif.ABANDON) {
        return true;
      }
      else {
        return false;
      }
    }
  
    public static boolean aPasser(MouvementRelatif mouvementATester) {
      if (mouvementATester.x == MouvementRelatif.PASSER) {
        return true;
      }
      else {
        return false;
      }
    }

 /**
   * Méthode redéfinie d'affichage (héritée de la classe "Object") 
   */
 @Override
 public String toString() {
        return "X : " + x + " Y : " + y;
    }
  } 