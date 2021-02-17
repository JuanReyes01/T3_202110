package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

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
					view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: *Deshabilitado*");
				    int capacidad = lector.nextInt();
				    modelo = new Modelo(); 
				    view.printMessage("Arreglo Dinamico creado");
				    view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					view.printMessage("--------- \nDar cadena (simple) a ingresar: *Deshabilitado*");
					dato = lector.next();
					//modelo.agregar(dato);
					view.printMessage("Dato agregado");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					view.printMessage("--------- \nDar cadena (simple) a buscar: *deshabilitado para YoutubeVideo*");
					dato = lector.next();
					//respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta.toString());
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					view.printMessage("--------- \nDar cadena (simple) a eliminar: *deshabilitado para YoutubeVideo*");
					dato = lector.next();
					//respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato eliminado "+ respuesta.toString());
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					view.printMessage("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
				
				case 6:
					view.printMessage("--------- \nInvertiendo Arreglo:*Deshabilitado*");
					//modelo.invertir();
					view.printModelo(modelo);
					break;
					
				case 8: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
				case 7:
				try {
					String r;
					try {
						r = modelo.cargarDatos();
					
					view.printMessage("------------------------------------------");
					view.printMessage(r);
					view.printMessage("Primer video: titulo: "+modelo.darArreglo().firstElement().darTitulo()+", canal: "+modelo.darArreglo().firstElement().darCanal()+" ,pa�s: "+modelo.darArreglo().firstElement().darPais());
					view.printMessage("Ultimo video: titulo: "+modelo.darArreglo().lastElement().darTitulo()+", canal: "+modelo.darArreglo().lastElement().darCanal()+" ,pa�s: "+modelo.darArreglo().lastElement().darPais());
					} catch (ParseException e) {						
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
