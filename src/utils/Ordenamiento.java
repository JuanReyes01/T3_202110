package utils;

import java.util.Comparator;

import model.data_structures.ILista;
import model.logic.YoutubeVideo;

public final class Ordenamiento<T extends Comparable<T>> {

	public Ordenamiento() {
	/*	ILista<YoutubeVideo> subListaVideos = (ILista<YoutubeVideo>) lista.sublista(100000);
		Comparator<YoutubeVideo> comparadorXLikes = new YoutubeVideo.ComparadorXLikes();
		Ordenamiento<YoutubeVideo> algsOrdenamientoVideos = new Ordenamiento<YoutubeVideo>();
		Ordenamiento.ordenarInsercion(subListaVideos, comparadorXLikes, true);
	*/}
	long start_time = System.currentTimeMillis(); // tiempo de referencia inicial (mseg)
	public void ordenarInsercion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
			{
			 {
		
		 int n = lista.size();
		    for (int i = 1+1; i <= n; i++)
		     {
		        boolean enPosicion = false;
		           for (int j = i; j > 1 && !enPosicion; j -= 1)
		     {
		   int factorComparacion = (ascendente?1:-1) * criterio.compare(lista.getElement(j), lista.getElement(j-1));
		   if (factorComparacion < 0){
		        lista.exchange(j, j-1);
		   }
		   else
		   {
		     enPosicion = true;
		   }
		     }
		     }

			}
			}
	long stop_time = System.currentTimeMillis(); // tiempo de referencia final (mseg)
	long elapsed_time = stop_time - start_time;
	
			public void ordenarShell(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
			{
			// implementación del algoritmo de Ordenamiento Shell
				int n = lista.size();
				int h = 1;
				 while (h < n/3){
				     h = 3 * h + 1;
				       while (h >=1){
				 // generalizacion del alg. Insertion sort con un valor h >= 1
			              for (int i = h+1; i <= n; i++){
				               boolean enPosicion = false;
				               for (int j = i; j > h && !enPosicion; j -= h){
				               int factorComparacion = (ascendente?1:-1) *
				                   criterio.compare(lista.getElement(j), lista.getElement(j-h));
				                 if (factorComparacion < 0){
			                         lista.exchange(j, j-h);
				                 }
				                 else{
				                      enPosicion = true;
				                     }
				                                                            }
				               h /= 3;
				                                        }
				                    }
			
			                   }
			}  
	 public final void ordenarMergeSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	 {
           int size = lista.size();
		    if(size > 1) {
			int mid = size/2;
			//Se divide la lista original en dos partes, izquierda y derecha, desde el punto mid.
			ILista<T> leftList = lista.sublista( mid);
			ILista<T> rightList = lista.sublista( size - mid+1);
			//Se hace el llamado recursivo con la lista izquierda y derecha.
			ordenarMergeSort(leftList, criterio, ascendente);
			ordenarMergeSort(rightList, criterio, ascendente);
		    //i recorre la lista de la izquierda, j la derecha y k la lista original.
			 int i,j,k;
			 i=j=k= 1;
			 int leftelements = leftList.size();
			 int rightelements = rightList.size();
			 while(i <= leftelements && j <= rightelements) {
			 T elemi = leftList.getElement(i);
			 T elemj = rightList.getElement(j);
			 //Compara y ordena los elementos
			 int factorComparacion = (ascendente?1:-1) * criterio.compare(elemi,elemj);
			          if(factorComparacion <= 0){
			lista.changeInfo(k, elemi);
			i++;
			 }
			 else
			 {
				 lista.changeInfo(k, elemj);
			j++;
			 }
			 k++;
			 }
			 //Agrega los elementos que no se compararon y están ordenados
			  while(i <= leftelements)
		      {
			  lista.changeInfo(k, leftList.getElement(i));
			 i++;
			 k++;
			 }
			 while(j <= rightelements)
			  {
			  lista.changeInfo(k, rightList.getElement(j));
			 j++;
			 k++;
			 }
			 }
			}
}
