
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonatan
 */
public class Arquivo {
    private FileInputStream stream;
    private InputStreamReader streamReader;
    private BufferedReader reader;
    
    
    //stream
    public Arquivo() throws FileNotFoundException{
        try {
            stream = new FileInputStream(".\\Resorces\\arq.txt");
            streamReader = new InputStreamReader(stream);
            reader = new BufferedReader(streamReader);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Ocorreu um erro ou o arquivo não foi encontrado!");
        }
    }    
    
    public BufferedReader getReader() throws FileNotFoundException {
        return reader;
    }
    
    public String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    public char getNextCaracter() throws IOException {
        return (char) reader.read();
    }
}
