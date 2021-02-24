package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import model.data_structures.ILista;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}


	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		Object respuesta = null;

		

	while( !fin ){
		view.printMenu();

		int option = lector.nextInt();
		switch(option){
			case 1:
				view.printMessage("------- \n=>Ingresa 0 si se quiere utilizar un arreglo dinamico\n=>Ingresa 1 si se quiere utilizar una lista encadenada");
				dato = lector.next();
				modelo.crearEstructura(Integer.parseInt(dato));
				view.printMessage("Se inicialicio una estructa del tipo: "+ (dato.equals("0")?"ArregloDinamico":"ListaEncadenada")+"\n-------");
				break;

			case 2:
				view.printMessage("------- \nCargando datos...");
				try {
					String r;
					r = modelo.cargarDatos();							
					view.printMessage("------------------------------------------");
					view.printMessage(r);
					view.printMessage("Primer video: titulo: "+modelo.darArreglo().firstElement().darTitulo()+", canal: "+modelo.darArreglo().firstElement().darCanal()+" ,país: "+modelo.darArreglo().firstElement().darPais());
					view.printMessage("Ultimo video: titulo: "+modelo.darArreglo().lastElement().darTitulo()+", canal: "+modelo.darArreglo().lastElement().darCanal()+" ,país: "+modelo.darArreglo().lastElement().darPais());
					view.printMessage("-------");
					} 
				catch (IOException e) {						
					e.printStackTrace();
					}
				catch(ParseException e){
					e.printStackTrace();
				}
				catch(Exception e){
					view.printMessage("Error: no hay una estructura de datos inicilizada");
				}
			break;

			case 3:
				view.printMessage("--------- \nDar tamaño de la nueva sublista:");
				dato = lector.next();
				ILista nuevo = modelo.subLista(Integer.parseInt(dato));
				view.printMessage("Copia exitosa. \nTamaño de la nueva lista: "+nuevo.size()+"\n---------");
				break;

			case 4:
				view.printMessage("--------- \nSeleccione cual tipo de algoritmo quiere utilizar");
				view.printMessage("=>1. Insertion sort\n=>2. Shell Sort\n=>3.Merge Sort\n=>4.Quick Sort");
				dato = lector.next();
				view.printMessage("Algoritmo seleccionado: "+ (dato.equals("1")?"Insertion sort":
															 (dato.equals("2")?"Shell sort":
															 (dato.equals("3")?"Merge sort":
															  "Quick sort"))));
				int tiempo = modelo.organizarLista(Integer.parseInt(dato));
				view.printMessage("Lista Ordenada!");
				view.printMessage("Tiempo de ejecución total: " + tiempo+ " milisegundos");
				//Faltan los 10 primeros/ultimos videos
				break;

			case 5: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;				
			
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
		}
}
	}
}
