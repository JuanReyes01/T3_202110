package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Inicializar estructuras de datos");
			System.out.println("2. Cargar datos del archivo CSV");
			System.out.println("3. Obtener una muestra de los videos");
			System.out.println("4. Organizar el arreglo");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			String a="[";
			for(int i=1; i<=modelo.darTamano();i++)
				a+=modelo.darArreglo().getElement(i)+" ";
			a = a.trim();
			a+="]";
			System.out.println(a);
			// TODO implementar
		}
		
		public void printPrimerosYUltimos(Modelo modelo)
		{
			for(int i=1; i<=10; i++){
				System.out.println(modelo.darArreglo().getElement(i).darTitulo()+": "+modelo.darArreglo().getElement(i).darLikes());
			}
			System.out.println("===================================================================================");
			for(int i=modelo.darTamano();i>=(modelo.darTamano()-10);i--){
				System.out.println(modelo.darArreglo().getElement(i).darTitulo()+": "+modelo.darArreglo().getElement(i).darLikes());
			}
		}
}
