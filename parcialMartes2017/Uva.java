import java.util.*;

//Clase realizada por Francisco Gambero Salinas, Ingeniería del Software

public class Uva {
	
	private static String BD_SERVER = "localhost";
	private static String BD_NAME = "Viticultivos";
	
	private int ID;
	private String VARIEDAD_UVA;
	
	public static List<Uva> ListaUvas(){
	//Retorna una lista con todos los objetos de la clase almacenados en la base de datos.
		ArrayList<Uva> lista = new ArrayList<Uva>();
		BD miBD = new BD(BD_SERVER, BD_NAME);
		
		for(Object[] tupla : miBD.Select("SELECT ID FROM TIPOS_UVA;")){
			lista.add(new Uva((int)tupla[0]));
		}
		return lista;
	}
	
	public Uva(int id){ //Crea el objeto cargando sus valores de la base de datos.
		
		BD miBD = new BD(BD_SERVER, BD_NAME);
		Object[] tupla = miBD.Select("SELECT * FROM TIPOS_UVA WHERE ID ="+id+";").get(0);
		ID = (int)tupla[0];
		VARIEDAD_UVA = (String)tupla[1];
	}
	
	public Uva(int id, String variedad){ //Crea el objeto y lo inserta en la base de datos.

		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Insert("INSERT INTO TIPOS_UVA VALUES("+id+", '"+ variedad +"');");
		this.ID =id;
		this.VARIEDAD_UVA = variedad;
		
	}
	
	public int getID(){ //retorna el ID de la Uva.
		return this.ID;
	}
	
	public void setID(int id){ // actualiza el ID de la Uva en memoria y en la base de datos.
		
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Insert("UPDATE TIPOS_UVA SET ID="+id+";");
		this.ID=id;
		
	}
	
	public String getVARIEDAD_UVA(){ //retorna el nombre de la VARIEDAD_UVA de la Uva.
		return VARIEDAD_UVA;
	}
	
	public void setVARIEDAD_UVA (String value){ //actualiza el nombre de la VARIEDAD_UVA de la Uva en memoria y en la base de datos
		
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Insert("UPDATE TIPOS_UVA SET VARIEDAD_UVA = '"+ value +"';");
		VARIEDAD_UVA = value;
	}
	
	public void Borrar(){ //borra la Uva en la base de datos y deja sus atributos a -1 y null.
		
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Delete("DELETE FROM TIPOS_UVA WHERE ID ="+ this.ID + ";");
		ID = -1;
		VARIEDAD_UVA = null;
	}

	public boolean equals(Object p) {
		return p instanceof Uva && ((Uva) p).ID==this.ID;
	}
	
	public int compareTo(Uva arg0) {
		// TODO Auto-generated method stub
		return ((Integer)(this.ID)).compareTo((Integer)arg0.ID);
	}
		
	public int hashCode() {
		return ((Integer)ID).hashCode();
	}
		
	public String toString() {
		return this.ID + "\t" + this.VARIEDAD_UVA;
	}

	
	
}
