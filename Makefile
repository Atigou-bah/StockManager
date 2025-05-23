# Nom du compilateur
JAVAC = javac

# Fichiers sources
SRC = $(wildcard *.java)

# Fichiers objets (fichiers compilés)
CLASSES = $(SRC:.java=.class)

# Classe contenant la méthode main
MAIN = Main

# Cible par défaut
all: $(CLASSES)

# Compilation des fichiers .java en .class
%.class: %.java
	$(JAVAC) $<

# Exécution du programme principal
run: all
	java $(MAIN)

# Nettoyage des fichiers .class
clean:
	rm -f *.class
