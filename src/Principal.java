
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
	int count = 1;
        
        Arquivo arquivo;
        BufferedReader reader;
        Scanner sc = new Scanner(System.in);
        
        //abertura do arquivo
        try {
            arquivo = new Arquivo();
            arquivo.readArquivo();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return;
        }
        
//        while(true){
//            String s = sc.next();
//            for (int i = 0; i < s.length(); i++) {
//                String a = s.substring(i, i+1);
                
                //switch( tuplas[ estAtual ][ alfabeto[alfaAtual] ].comando ) {
//                int x = 10;
//                switch(cabecote) {
//                    case Comando.R.getValor():
//                        cabecote++;
//                        break;
//                    case Comando.L.getValor():
//                        cabecote--;
//                        break;
//                    case Comando.P.getValor():
//                        comandoAtual = Comando.P.getValor();
//                        System.out.println("RECONHECIDO ");
//                        break;
//                    default:
//                        comandoAtual = Comando.P.getValor();
//                        System.out.println("ERROR");
//                        break;
//                    }
//                }
//            }

            if(true) return;
    }
}


