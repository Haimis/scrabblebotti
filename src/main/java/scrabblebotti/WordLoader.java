package scrabblebotti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordLoader {
    BufferedReader br;
    
    public void openFile() throws FileNotFoundException {
        br = new BufferedReader(new FileReader("sanalista.txt"));

        
        
    }
    
    public List<String> readFile() throws IOException {
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;


    }
    
    public void closeFile() throws IOException {
        br.close();
    }

}
