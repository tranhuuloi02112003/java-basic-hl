package FileProcessing;

public abstract class FileProcessor {
    private String fileName;

    public FileProcessor() {}
    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public final void process() {
        openFile();
        readContent();
        closeFile();
        printCustomProcessingInfo();
    }

    abstract void openFile();
    abstract void readContent();
    abstract void closeFile();
    abstract void printCustomProcessingInfo();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
