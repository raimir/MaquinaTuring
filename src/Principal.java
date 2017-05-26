
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Equipe
 */
public class Principal {
    
    
    
    public static void main (String [] args) throws IOException {
        
        Arquivo arquivo;
        BufferedReader reader;
        
//abertura do arquivo
        try {
            arquivo = new Arquivo();
            reader = arquivo.getBufferedReader();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return;
        }
        
        int qtEstado = 0;
        int qtAlfabeto = 0;
        char caracter = '~';
        ArrayList<Estado> estados = new ArrayList<>();
       
        int c = 1;
        String EA = arquivo.getNextLine();
        String a[] = EA.split(" ");
        qtEstado = Integer.parseInt(a[0]);
        qtAlfabeto = Integer.parseInt(a[1]);
        System.out.println("Quantidade de Estado:" + qtEstado);
        System.out.println("Quantidade de Alfabeto:" +qtAlfabeto);
        
        ArrayList<String> alf = new ArrayList<>();
        int i = 0;
        do {
            caracter = arquivo.getNextCaracter();
            if( !(caracter == ' ') ) {
                alf.add(String.valueOf(caracter));
            }    
        } while(caracter != '~');
        arquivo.getNextLine();
        
        List<List<Estado>> tuplas = arquivo.getTuplas();
        for( i = 0; i < tuplas.size(); i++) {
            for(int z = 0; z < tuplas.get(i).size(); z++) {
                System.out.print(tuplas.get(i).get(z).getEstado() + " ");
                System.out.print(tuplas.get(i).get(z).getAlfabeto() + " ");
                System.out.println(tuplas.get(i).get(z).getComando());
            }    
        }
        
    }
}
