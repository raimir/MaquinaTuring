
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
    
    public String getTuplas() throws FileNotFoundException, IOException {
        BufferedReader reader = getReader();
        List<List<Estado>> tuplas = new ArrayList<>();
        List<Estado> estados = new ArrayList<>();
        
        T_estados = 4;
        for(int i = 0; i < T_estados; i++) {
		aux[i] = malloc(T_alfabeto * sizeof(tupla));
		if(aux[i] == NULL) {
			fprintf(stderr, "out of memory\n");
			exit(-1);
		}
	}
        
        
        int i = 0;
        int js = 0;
        
        //while (!feof(arq)) {
        while (reader.ready()) {
            
            //fscanf(arq,"%d,%c,%c\n",&aux[j][i].estado, &aux[j][i].alfa, &aux[j][i].comando);
            Estado estado = new Estado();
            estado.setEstado(readEstado());
            estado.setAlfabeto(readAlfabeto());
            estado.setComando(readComando());
            
            tuplas.add(
                new Estado(
                        
                )
            );
            printf("%2d,%2c,%2d\t",aux[j][i].estado, aux[j][i].alfa, aux[j][i].comando);

            i++;

            if( i == T_alfabeto ) {
                    printf("\n");
                    i=0;
                    j++;
            }

            //scanf("%d", &T);
	}
    }
    
    public int readEstado() throws IOException {
        char e = (char) reader.read();
        String ec = String.valueOf(e);
        return Integer.parseInt(ec);
    }
    
    public char readAlfabeto() throws IOException {
        char a = (char) reader.read();
        return a;
    }
    
    public char readComando() throws IOException {
        char c = (char) reader.read();
        return c;
    }
}
