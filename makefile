ALL = *
PATH_SRC = src/
CLASSPATH = bytecodes
ALLCLASSPATH = bytecodes/ataxx/jeu/:bytecodes/ataxx/visuel/:bytecodes/ataxx/positionnement/:bytecodes/ataxx/jeu/
MAIN = Jeu
MAINPATH = ataxx/jeu/Jeu
args = `arg="$(filter-out $@,$(MAKECMDGOALS))" && echo $${arg:-${1}}`

compile:
	javac -cp $(CLASSPATH) -d $(CLASSPATH) $(PATH_SRC)ataxx/visuel/*.java
	javac -cp $(CLASSPATH) -d $(CLASSPATH) $(PATH_SRC)ataxx/cases/*.java
	javac -cp $(CLASSPATH) -d $(CLASSPATH) $(PATH_SRC)ataxx/jeu/*.java
	javac -cp $(CLASSPATH) Ataxx.java

run:
	java -cp $(CLASSPATH):. Ataxx $(args)

clean:
	rm $(CLASSPATH)/ataxx/cases/*.class
	rm $(CLASSPATH)/ataxx/jeu/*.class
	rm $(CLASSPATH)/ataxx/visuel/*.class
javadoc:
	javadoc -cp $(CLASSPATH):. -d MaDoc src/ataxx/*/*.java

javadocRM:
	rm -dR MaDoc/*
