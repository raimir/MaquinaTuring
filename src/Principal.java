
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


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
            reader = arquivo.getReader();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return;
        }
        
        int qtEstado = 0;
        int qtAlfabeto = 0;
        char caracter = '~';
        ArrayList<Estado> estados = new ArrayList<>();
       
        int c = 1;
        String EA = reader.readLine();
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
        //}
            
//if()
//            printf("%7c%9c",c,' ');
//            alf[(int)c] = i;
//            i++;
//            if( i > T_alfabeto)
//            {
//            printf("BRANCO DE FITA NÃO ENCONTRADO\n");
//            exit(-1);
//}
                
        } while(caracter != '~');
        for (String af : alf) {
            System.out.println(af);
        }
    
        
    }
}
