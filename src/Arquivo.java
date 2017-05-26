
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    private String nextLine;
    private char nextCaracter;
    
    
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
    
    public BufferedReader getBufferedReader() throws FileNotFoundException {
        return reader;
    }
    
    public String getNextLine() throws IOException {
        nextLine = reader.readLine();
        return nextLine;
    }
    
    public char getNextCaracter() throws IOException {
        nextCaracter = (char) reader.read();
        return nextCaracter;
    }
    
    public boolean hasNextLine() throws IOException {
        return reader.ready();
    }
    
    
    public List<List<Estado>> getTuplas() throws FileNotFoundException, IOException {
        BufferedReader reader = getBufferedReader();
        List<List<Estado>> tuplas = new ArrayList<>();
        List<Estado> estados = new ArrayList<>();
        
        int T_estados = 4;
        int T_alfabeto = 6;
        
        int i = 0;
        int j = 0;
        
        //cria
        for(int l = 0; l < T_estados; l++) {
	
            //while (!feof(arq)) {
            while ( hasNextLine() ) {
                
                //pegando a proxima linha
                getNextLine();
                
                //fscanf(arq,"%d,%c,%c\n",&aux[j][i].estado, &aux[j][i].alfa, &aux[j][i].comando);
                Estado estado = new Estado();
                estado.setEstado(getEstado());
                estado.setAlfabeto(getAlfabeto());
                estado.setComando(getComando());
                
                estados.add(estado);

                //printf("%2d,%2c,%2d\t",aux[j][i].estado, aux[j][i].alfa, aux[j][i].comando);

                i++;

                if( i == T_alfabeto ) {
                    System.out.println("\n");
                    //printf("\n");
                    i=0;
                    j++;
                }

                //scanf("%d", &T);
            }
            
            tuplas.add(estados);
        }
        return tuplas;
    }
    
    //E - estado, A - alfabeto, C - comando
    private String ArrayEAC(int pos) throws IOException {
        String[] arr = nextLine.split(",");
        return arr[pos];
    }
    
    public int getEstado() throws IOException {
        String a = ArrayEAC(0);
        int e = Integer.parseInt(ArrayEAC(0));
        return e;
    }
    
    public char getAlfabeto() throws IOException {
        char[] e =  ArrayEAC(1).toCharArray();
        return e[0];
    }
    
    public char getComando() throws IOException {
        char[] e = ArrayEAC(2).toCharArray();
        return e[0];
    }
}
