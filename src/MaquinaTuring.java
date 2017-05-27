
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Equipe
 */
public class MaquinaTuring {
    public static final String COMANDO_R = "R";
    public static final String COMANDO_L = "L";
    public static final String COMANDO_P = "P";
    
    
    public static void main (String [] args) {
        try {
            MaquinaTuring maquina = new MaquinaTuring();
            maquina.executar();
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro na leitura do arquivo!");  
        }
        /*
        ENTRADA:    RESPOSTA:
        >0011~      RECONHECIDO
        >0000111~   ERROR
        >01~        RECONHECIDO
        >0~         ERROR
        */
    }    
    
    public void executar() throws FileNotFoundException, IOException {
        Arquivo arquivo;
        List<List<Estado>> tuplas;
        List<String> listAlfabeto;
                
        //abertura do arquivo
        arquivo = new Arquivo();
        
        //preenchendo as linhas colunas da maquina de turing
        arquivo.readArquivo();
        
        //pegando as linhas colunas da máquina
        tuplas = arquivo.getTuplas();
        
        //pegando a lista do alfabeto
        listAlfabeto = arquivo.getListaAlfabeto();
        
        System.out.println("Para parar o programa digite \"stop\"");
        System.out.print("Digite uma entrada: ");
        
        //recebendo a entrada
        Scanner sc = new Scanner(System.in);
        
        while ( sc.hasNext() ) {
            String entrada = sc.next();
            
            //verificando a condição de parada da máquina
            if ( entrada.equalsIgnoreCase("stop") ) {
                break;
            }
            
            //verificando se existe o caracter de parada
            if ( !entrada.contains("~") ) {
                entrada += "~";
            }
            
            System.out.println("Alfabeto inicial: " + entrada);
            
            List<String> arrayEntrada = StringToArrayString(entrada);
            
            int cabecote = 0;
            int estadoAtual = 0;
            String alfabetoAtual = "";
            String comandoAtual = "";
            
            
            do {
                alfabetoAtual = arrayEntrada.get(cabecote);
           
                List<Estado> estado = tuplas.get(estadoAtual);
                
                comandoAtual = estado.get(listAlfabeto.indexOf(alfabetoAtual)).getComando();
           
                arrayEntrada.set(cabecote, 
                        estado.get(listAlfabeto.indexOf(alfabetoAtual)).getAlfabeto()
                );
             
                switch( estado.get(listAlfabeto.indexOf(alfabetoAtual)).getComando() ) {
                      case (COMANDO_R):
                              cabecote++;
                              break;
                      case (COMANDO_L):
                              cabecote--;
                              break;
                      case (COMANDO_P):
                          comandoAtual = COMANDO_P;
                          System.out.println("RECONHECIDO ");
                          break;
                      default:
                          comandoAtual = COMANDO_P;
                          System.out.println("ERROR");
                          break;
                }
                
                estadoAtual = estado.get(listAlfabeto.indexOf(alfabetoAtual)).getEstado();
                
            } while(comandoAtual != COMANDO_P);
            
            //printando o valor final da entrada
            System.out.println("Valor Final da Entrada: " +arrayEntrada.toString());
            
            System.out.println("");
            System.out.println("Para parar o programa digite \"stop\"");
            System.out.print("Digite uma entrada");
	}
    }
    
    private static List<String> StringToArrayString(String entrada) {
        List<String> listEntrada = new ArrayList<>();
        
        for (int i = 0; i < entrada.length(); i++) {
            String e = entrada.substring(i, (i+1));
            listEntrada.add(e);
        }
        
        return listEntrada;
    }
}


