//package amina;
import java.util.*;

public class Base 
{
	
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "parcialMartes2013";
	
	private int CODIGO;
	private String NOMBRE;	
	
	public static List<Base> ListaBases() // Devuelve una Lista con todos las Bases almacenados en la BD
	{
		List<Base> res = new ArrayList<Base>();
		// COMPLETAR
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT cod_base FROM BASE;"))
		{
			res.add(new Base((Integer)tupla[0]));
		}
		
		return res;
	}
	
	public Base(int id) // Carga los atributos de la BD
	{	
		BD miBD = new BD(BD_SERVER,BD_NAME);			
        Object[] tupla = miBD.Select("SELECT * FROM BASE WHERE cod_base = "+ id +";").get(0);

        CODIGO = (Integer)tupla[0];
        NOMBRE = (String)tupla[1];
	}
	
	public Base(int id, String nombre) // Carga los atributos e inserta el nuevo Base en la BD	
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Insert("INSERT INTO BASE VALUES ("+ id + ", '"+ nombre + "');");
		CODIGO = id;
		NOMBRE = nombre;

	}
	
	
	public String toString()
	{
		return 	CODIGO  + ";" + NOMBRE;
	}
	
	public void setCODIGO(int id) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE BASE SET cod_base = "+ id + " WHERE cod_base ="+ this.CODIGO +";");
		
		CODIGO = id;
	
	}

	public int getCODIGO() 
	{
		return CODIGO;
	}

	public void setNOMBRE(String nombre) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE BASE SET nombre = '"+ nombre + "' WHERE cod_base ="+ this.CODIGO +";");
		
		NOMBRE = nombre;
	}

	public String getNOMBRE() 
	{
		return NOMBRE;
	}
	
	public void Delete() //Borra el objeto de la BD y deja el código a -1
	{
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Delete("DELETE FROM BASE WHERE cod_base ="+ this.CODIGO + ";");
    	CODIGO = -1;
    	NOMBRE = null;
	
	}
}
