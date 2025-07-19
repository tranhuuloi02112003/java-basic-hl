package FileProcessing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ImageFileProcessor i = new ImageFileProcessor("image.jpg");
        TextFileProcessor t = new TextFileProcessor("document.txt");

        i.process();
        t.process();

        ArrayList<FileProcessor> list = new ArrayList<>();
        list.add(i);
        list.add(t);

        System.out.println("-----ArrayList-----");
        for (FileProcessor f : list) {
            f.process();
        }
    }
}
