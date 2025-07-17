package FileProcessing;

public class ImageFileProcessor extends  FileProcessor{

    public ImageFileProcessor() {
    }

    public ImageFileProcessor(String fileName) {
        super(fileName);
    }

    @Override
    void openFile() {
        System.out.println("Opening image file:"+super.getFileName());
    }

    @Override
    void readContent() {
        System.out.println("Loading pixel data from image file...");
    }

    @Override
    void closeFile() {
        System.out.println("Closing image file:"+super.getFileName());
    }

    @Override
    void printCustomProcessingInfo() {
        System.out.println("Image file compressed and saved");
    }
}
