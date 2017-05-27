
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
    private FileInputStream stream = null;
    private InputStreamReader streamReader = null;
    private BufferedReader reader = null;
    private  List<List<Estado>> tuplas = null;
    private List<String> alfabeto = null;
    private String nextLine = null;
    private String lineEA = null;
    private String lineAlf = null;
    private  int qtdEstados = 0;
    private  int qtdAlfabeto = 0;
    private char nextCaracter;
    
    
    //stream
    public Arquivo() throws FileNotFoundException {
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
    
    
    public void readArquivo() throws FileNotFoundException, IOException {
        BufferedReader reader = getBufferedReader();
        tuplas = new ArrayList<>();
        List<Estado> estados = new ArrayList<>();
        
        //iniciando a linha de qtd de estados e alfabeto
        createQtdEstadoAlfabeto();
        //pegando o alfabeto
        createListaAlfabeto();
        
        int i = 0;
        int j = 0;
        
        //cria
        for(int l = 0; l < qtdEstados; l++) {
	
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

                if( i == qtdAlfabeto ) {
                    System.out.println("\n");
                    i=0;
                    j++;
                    break;
                }
                //scanf("%d", &T);
            }
            
            tuplas.add(estados);
        }
        
        printTuplas();
    }
    
    //E - estado, A - alfabeto, C - comando
    private String ArrayEAC(int pos) throws IOException {
        String[] arr = lineEA.split(" ");
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
    
    private void createQtdEstadoAlfabeto() throws IOException {
        lineEA = getNextLine();
        String[] nl = lineEA.split(" ");
        qtdAlfabeto = Integer.parseInt(nl[1]);
        qtdEstados = Integer.parseInt(nl[0]);
    }
    
    private void createListaAlfabeto() throws IOException {
        lineAlf = getNextLine();
        alfabeto = new ArrayList<>();
        String[] alf = lineAlf.split(" ");
        
        for (int i = 0; i < alf.length; i++) {
            alfabeto.add(alf[i]);
        }
    }
    
    public int getQtdEstados() {
        return qtdEstados;
    }
    
    public int getQtdAlfabeto(){
        return qtdAlfabeto;
    }
    
    public List<List<Estado>> getTuplas() {
        return tuplas;
    }
    
    public List<String> getListaAlfabeto() {
        return alfabeto;
    }
    
    private void printTuplas() {
        List<List<Estado>> ctuplas = getTuplas();
        List<String> listaAlfa = getListaAlfabeto();
        
        System.out.println("Qtd Estado: " + qtdEstados);
        System.out.println("Qtd Alfabeto: " + qtdAlfabeto);
        
        
        for (int i = 0; i < listaAlfa.size(); i++) {
           System.out.print(listaAlfa.get(i) + "\t");
        }
        System.out.println("");
        
        
        for(int i = 0; i < ctuplas.size(); i++) {
            for(int z = 0; z < ctuplas.get(i).size(); z++) {
//                System.out.println("i: " + i + " z: " + z);
                System.out.print(ctuplas.get(i).get(z).getEstado() + ",");
                System.out.print(ctuplas.get(i).get(z).getAlfabeto() + ",");
                System.out.print(ctuplas.get(i).get(z).getComando() +"\t");
            } 
            System.out.println("");
        }
    }
}
