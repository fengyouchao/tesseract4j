# tesseract4j
A Java API for Tesseract-ocr

# How to use
String text = Tesseract.loadImage(new File("a.png")).setLanguage(Language.English).ocr();