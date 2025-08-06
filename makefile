JAVAC = javac
JAVA = java
SRC_DIR = ./src
CLASS_DIR = ./class
SRC = $(wildcard $(SRC_DIR)/*.java)
MAIN = Main

all:
	@mkdir -p $(CLASS_DIR)
	$(JAVAC) -d $(CLASS_DIR) $(SRC)

run: all
	$(JAVA) -cp $(CLASS_DIR) $(MAIN)

clean:
	rm -rf $(CLASS_DIR)/*.class
