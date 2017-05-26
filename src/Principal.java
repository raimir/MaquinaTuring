
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Equipe
 */
public class Principal {
    
    public static void main (String [] args) throws IOException {
        int cabecote;
	int estAtual;
	int alfaAtual;
	int comandoAtual;
	//char entrada[255];
        String values[] = new String[99]; 
        int qtEstado = 0;
        int qtAlfabeto = 0;
        char caracter = '~';
        ArrayList<Estado> estados = new ArrayList<>();
        int count = 1;
        
        Arquivo arquivo;
        BufferedReader reader;
        Scanner sc = new Scanner(System.in);
//        while(true){
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                String a = s.substring(i, i+1);
                
            }
            
            
            
//            if(s.equals("~")){                
//                break;
//            } else{
//                values[count] = s;
//            }
//            count++;
//        }
        
        if(true) return;
        
        //abertura do arquivo
        try {
            arquivo = new Arquivo();
            arquivo.readArquivo();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return;
        }
        
        while(true){
            String s = sc.next();
            
            if(s.equals("~")){                
                break;
            } else{
                values[count] = s;
            }
            count++;
        }
        
        //switch( tuplas[ estAtual ][ alfabeto[alfaAtual] ].comando ) {
        int x = 10;
        switch(x) {
            case (Comando.R.getValor()):
                cabecote++;
                break;
            case (Comando.L.getValor()):
                cabecote--;
                break;
            case (Comando.P.getValor()):
                comandoAtual = P;
                System.out.println("RECONHECIDO ");
                break;
            default:
                comandoAtual = P;
                System.out.println("ERROR");
                break;
            }
        }
}


