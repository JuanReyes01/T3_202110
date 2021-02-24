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
			System.out.println("1. Crear Estructura de datos");
			System.out.println("2. Subir datos del archivo data");
			System.out.println("3. Conseguir datos de los videos");
			System.out.println("4. Usar un metodo de ordenamiento para el arreglo");
			System.out.println("5. Imprimir el Arreglo");
			System.out.println("6. Exit");
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
}
