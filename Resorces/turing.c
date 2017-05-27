#include <stdlib.h>
#include <stdio.h>
#define R 82
#define L 76
#define P 80

typedef struct {
	int estado;
	char alfa;
	char comando;
} tupla;

tupla **parser( short *alf ) {
 
	FILE *arq;
	int i=0;
	int j=0;
	tupla **aux;
	int T_alfabeto=3;
	int T_estados=0;
	char c;
	 
	int T;
	 
	// Abre um arquivo TEXTO para LEITURA
	arq = fopen("config.txt", "r");

	// Se houve erro na abertura
	if (arq == NULL) {
		printf("Problemas na abertura do arquivo\n");
		exit(-1);
	}
 
	fscanf(arq,"%d %d\n",&T_estados,&T_alfabeto);
	printf("%d %d\n",T_alfabeto,T_estados);
	printf("\n");
	
	do {
		fscanf(arq,"%c ",&c);
		printf("%7c%9c",c,' ');
		//?? ainda não entendi esse alfabeto
                alf[(int)c] = i;
		i++;
		
		if( i > T_alfabeto) {
			printf("BRANCO DE FITA NÃO ENCONTRADO\n");
			exit(-1);
		}
	}while(c != '~');
 
	aux = malloc(T_estados * sizeof(tupla *));
        
        //falta de memória
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
}

int main() {
	int cabecote;
	int estAtual;
	int alfaAtual;
	int comandoAtual;
	char entrada[255];
	 
	short alfabeto[127];
	tupla **tuplas=NULL;
	tuplas = parser(alfabeto);
 
	if (tuplas == 0) {
		printf("ERRO\n");
		exit(1);
	}
 
	printf("INICIO: %s\n", entrada);
	while(scanf("%s", &entrada) != EOF) {
		cabecote = 0;
		estAtual = 0;
		alfaAtual = 0;
		comandoAtual = 0;
		
		do {
			alfaAtual = entrada[ cabecote ];
			comandoAtual = tuplas[ estAtual ][ alfabeto[alfaAtual] ].comando;
			entrada[cabecote] = tuplas[ estAtual ][ alfabeto[alfaAtual] ].alfa;
			 
			/*printf( "\nCABEÇOTE\tESTADO\tALFABETO\tCOMANDO\n"
			"%d\t\t%d\t%c\t\t%d\n", cabecote, estAtual, alfaAtual, comandoAtual
			);*/
		 
			switch( tuplas[ estAtual ][ alfabeto[alfaAtual] ].comando ) {
				case (R):
					cabecote++;
					break;
				case (L):
					cabecote--;
					break;
				case (P):
					comandoAtual = P;
					printf("RECONHECIDO ");
					break;
				default:
					comandoAtual = P;
					printf("ERROR");
					break;
			}
			estAtual = tuplas[ estAtual ][ alfabeto[alfaAtual] ].estado;
		 
			printf("%s\n", entrada);
			//scanf("%d", &i);
		} while(comandoAtual != P);
	}
	free(tuplas);
	return 0;
}


//https://gutodisse.wordpress.com/2015/10/26/maquina-de-turing-em-c/
//exemplo de entradas