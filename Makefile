# Nom du compilateur
JAVAC = javac

# Dossier de destination des .class
BIN = bin

# Fichiers sources
SRC = $(wildcard *.java)

# Classes à générer dans bin
CLASSES = $(SRC:.java=.class)

# Classes principales
CONSOLE = Console
INTERGRAPH = Interface

# Cible par défaut
all: $(BIN) $(CLASSES)

# Créer le dossier bin s'il n'existe pas
$(BIN):
	mkdir -p $(BIN)

# Compilation : mettre les .class dans bin
%.class: %.java
	$(JAVAC) -d $(BIN) $<

# Exécution en console
console: all
	java -cp $(BIN) $(CONSOLE)

# Exécution en interface graphique
interface: all
	java -cp $(BIN) $(INTERGRAPH)

# Nettoyage
clean:
	rm -rf $(BIN)
