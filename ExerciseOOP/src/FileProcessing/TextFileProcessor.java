package FileProcessing;

public class TextFileProcessor extends FileProcessor{
    public TextFileProcessor(String fileName) {
        super(fileName);
    }

    @Override
    void openFile() {
        System.out.println("Opening text file:"+super.getFileName());
    }

    @Override
    void readContent() {
        System.out.println("Welcome to Java OOP");
    }

    @Override
    void closeFile() {
        System.out.println("Closing text file"+super.getFileName());
    }

    @Override
    void printCustomProcessingInfo() {
        System.out.println("Text file processed");
    }
}
