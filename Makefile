SRC = src
OUT = out
SOURCES = $(wildcard $(SRC)/*.java)
CLASSES = $(SOURCES:$(SRC)/%.java=$(OUT)/%.class)

all: $(CLASSES)

$(OUT)/%.class: $(SRC)/%.java
	@mkdir -p $(OUT)
	javac -d $(OUT) $(SRC)/*.java

clean:
	rm -rf $(OUT)/*
