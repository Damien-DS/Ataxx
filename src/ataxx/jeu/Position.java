package ataxx.jeu;

public class Position {
    int x;
    int y;
    final static int ABANDON = -100;
    final static int PASSER = -200;
    boolean positionCorrecte;
    Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Méthode pour determiner si a la place de la position, une demande d'abandon a été faite
   * @param positionATester
   * @return
   */
  public static boolean estAbandon(Position positionATester) {
    if (positionATester.x == Position.ABANDON) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Méthode pour determiner si a la place de la position, une demande pour passer le tour à été faite
   * @param positionATester
   * @return
   */
  public static boolean aPasser(Position positionATester) {
    if (positionATester.x == Position.PASSER) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Méthode redéfinie (hériteé de la classe "Object") pour comparer deux position
   */
  @Override
  public boolean equals(Object o){
    if (o.getClass()!= Position.class){
      return false;
    }
    else {
      Position pos = (Position)o;
      if (x == pos.x && y == pos.y) {
        return true;
      }                   
      else {
        return false;
      }
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
