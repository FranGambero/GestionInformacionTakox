import java.util.*;

//Clase realizada por Francisco Gambero Salinas, Ingeniería del Software

public class principal {

	private static String BD_SERVER = "localhost";
	private static String BD_NAME = "Viticultivos";
	
	public static void main(String[] args) 
	{
		// Uvas en el sistema
		for(Uva u: Uva.ListaUvas()) System.out.println(u);
		
		// Añado una nueva Uva
		Uva nueva = new Uva(999,"Moscatel nova");
		
		// Muestro la Nueva
		System.out.println("La Uva nueva es:" + nueva);
		
		// Borro la Nueva
		System.out.println("Borro " + nueva);
		nueva.Borrar();
				
		// Busco la Borrada
		try
		{
			nueva = new Uva(999);
			System.out.println("La Uva nueva es:" + nueva);
		}
		catch (Exception ex)
		{
			System.out.println("ERROR:" + ex.getMessage());
		}
				
		MuestraKilosUva(30000);
	}
	
	public static void MuestraKilosUva(int max) //Implementar
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		System.out.println("\nComienza MuestraKilosUva\n");
		ArrayList<String> fincasConsultadas = new ArrayList<String>();
		//uvasConsultadas = null;
		//uvasConsultadas.clear();
		
		for(Uva u : Uva.ListaUvas()){
			Object[] tupla = miBD.Select("SELECT * FROM VITICULTIVOS WHERE KILOS_PRODUCIDOS >" + max +";").get(0);
			if((int)tupla[5] > max && !fincasConsultadas.contains((String)tupla[0])){
			
			System.out.println("Uva tipo: "+ u.getVARIEDAD_UVA() + ".");
			String referenciaFinca = (String)tupla[0];
			String nombreFinca = (String)tupla[1];
			double superficieFinca = (double)tupla[4];
			int kilosProducidos = (int)tupla[5];
			fincasConsultadas.add(referenciaFinca);
			
			System.out.println("Nombre finca: " + nombreFinca + ", Superficie: "+ superficieFinca + ", Kilos producidos: "+ kilosProducidos +".");
			}
		}

		System.out.println("MuestraKilosUva terminado con éxito\n");
	}

}
