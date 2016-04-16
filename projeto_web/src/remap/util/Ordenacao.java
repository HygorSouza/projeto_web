package remap.util;

import remap.model.Model;

public class Ordenacao {

	public void insertSort( Model vetor[] ) {

		for (int i = 1; i < vetor.length; i++) {

			Model menor = vetor[i];
			int indece = i - 1;

			while (indece >= 0 && menor.identificador() < vetor[indece].identificador() ) {
				vetor[indece + 1] = vetor[indece];
				indece--;
			}

			vetor[indece + 1] = menor;

		}
	}
	
	// inicio -- metodos para ordenacao Quick Sort
	public void quickSort( Model vetor [] ){
		quickSort( vetor, 0 , vetor.length - 1);
	}
	
	private void quickSort( Model [] vetor, int baixo , int alto ){
		Model pivo = vetor[baixo];
		int baixoInicial = baixo;
		int altoInicial  = alto;
		
		while( baixo < alto ){
			while( vetor[alto].identificador() >= pivo.identificador() && baixo < alto ){
				alto--;
			}
			if( alto != baixo ){
				vetor[baixo] = vetor[alto];
				baixo++;
			}
			
			while( vetor[baixo].identificador() <= pivo.identificador() && baixo < alto ){
				baixo++;
			}
			if( baixo != alto){
				vetor[alto] = vetor[baixo];
				alto--;
			}
		}
		vetor[baixo] = pivo;
		
		if( baixo > baixoInicial )
			quickSort(vetor, baixoInicial , baixo - 1 );
		if( alto < altoInicial )
			quickSort(vetor, alto + 1 , altoInicial );
	}
	// fim  -- metodos para ordenacao Quick Sort
		
}