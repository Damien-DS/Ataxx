# Ataxx
Projet d'école Polytech Sorbonne EI2I4

Pour faciliter la compilation, vous pouvez installer make avec la commande
```bash
sudo apt install make (Distribution basé sur debian)
```

Compilation :
Mettez vous dans le répertoire du repo
Si make installé :
    Pour compliler, utilisez la commande make compile
Sinon 
```bash
javac -cp bytecode -d bytecode src/ataxx/visuel/*.java
javac -cp bytecode -d bytecode src/ataxx/cases/*.java
javac -cp bytecode -d bytecode src/ataxx/jeu/*.java
javac -cp bytecode Ataxx.java
  ```

Execution : Si make installé
    Pour lancer le programme, utilisez la commande make run @arguments
Sinon
```bash
java -cp bytecode:. Ataxx @arguments
```

@arguments : si aucun alors par défaut les joueurs s'appeleront Joueur 1 Joueur 2 et auront respectivement les couleurs Bleu et Rouges

JAVADOC : 
Si make installé :
    Pour créer la javadoc de ce projet , utilisez la commande make javadoc
Sinon 
```bash
javadoc -cp bytecode:. -d MaDoc src/ataxx/*/*.java
```

