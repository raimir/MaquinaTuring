
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ParserFuncao {
    
    public String parser() {
        
        //Retorna um ponteiro de ponteiro e recebe um ponteiro de short
        //tupla **parser( short *alf ) {
        
        //abrir arquivo
        //FILE *arq;
        int i=0;
        int j=0;
        
        //ponteiro de ponteiro
        //tupla **aux;       
        String aux = "";
        //T = tamanho
        int T_alfabeto=3;
	int T_estados=0;
	char c;
        
        int T;
        
        // Abre um arquivo TEXTO para LEITURA
	//arq = fopen("config.txt", "r");
        
        Arquivo arquivo;
        BufferedReader reader;
        //abertura do arquivo
        try {
            arquivo = new Arquivo();
            reader = arquivo.getReader();
        } catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            return "";
        }
        
	// Se houve erro na abertura
//	if (arq == NULL) {
//		printf("Problemas na abertura do arquivo\n");
//		exit(-1);
//	}
 
//	fscanf(arq,"%d %d\n",&T_estados,&T_alfabeto);
//	printf("%d %d\n",T_alfabeto,T_estados);
//	printf("\n");
	
        String EA = null;
        try {
            EA = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ParserFuncao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String a[] = EA.split(" ");
        T_estados = Integer.parseInt(a[0]);
        T_alfabeto = Integer.parseInt(a[1]);
        System.out.println("Quantidade de Estado:" + T_estados);
        System.out.println("Quantidade de Alfabeto:" + T_alfabeto);
        
	do {
            //leu e armazenou em c
            fscanf(arq,"%c ",&c);
            //imprimiu c
            printf("%7c%9c",c,' ');
            
            alf[(int)c] = i;
            i++;

            if( i > T_alfabeto) {
                    printf("BRANCO DE FITA NÃO ENCONTRADO\n");
                    exit(-1);
            }
	}while(c != '~');
 
	aux = malloc(sizeof(tupla *) * T_estados);

	if(aux == NULL) {
		fprintf(stderr, "out of memory\n");
		exit(-1);
	}

	for(i = 0; i < T_estados; i++) {
		aux[i] = malloc(T_alfabeto * sizeof(tupla));
		if(aux[i] == NULL) {
			fprintf(stderr, "out of memory\n");
			exit(-1);
		}
	}
 
	i=0;
	printf("\n");

	while (!feof(arq)) {
            fscanf(arq,"%d,%c,%c\n",&aux[j][i].estado, &aux[j][i].alfa, &aux[j][i].comando);

            printf("%2d,%2c,%2d\t",aux[j][i].estado, aux[j][i].alfa, aux[j][i].comando);

            i++;

            if( i == T_alfabeto ) {
                    printf("\n");
                    i=0;
                    j++;
            }

            //scanf("%d", &T);
	}
 
	fclose(arq);
	//scanf("%d", &T);
	return aux;
        return "";
}
}
