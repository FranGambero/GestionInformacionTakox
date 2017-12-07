//package amina;

import java.sql.*;
import java.util.*;

public class Aminoacido 
{
	private static String BD_SERVER = "localhost";
    private static String BD_NAME = "parcialMartes2013";
	
	private String CODIGO;
	private Base BASE;
	private String NOMBRE;
	private int LONGITUD_SECUENCIA;
	private String SECUENCIA;
	private String ESTADO;
	private String FUNCION;	
	
	public static List<Aminoacido> ListaAminoacidos()// Devuelve una Lista con todos los Aminoacidos almacenadas en la BD
	{
		List<Aminoacido> res = new ArrayList<Aminoacido>();
		// COMPLETAR		
		BD miBD = new BD(BD_SERVER, BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT cod_amino FROM AMINOACIDO;"))
		{
			res.add(new Aminoacido((String)tupla[0]));
		}
		
		return res;
	}
	public Aminoacido(String co)// Carga los atributos de la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		Object[] tupla = miBD.Select("SELECT * FROM AMINOACIDO WHERE cod_amino = '"+co+"';").get(0);
		
		CODIGO=(String) tupla[0];
		BASE= new Base((Integer) tupla[1]);
		NOMBRE = (String) tupla[2];
		LONGITUD_SECUENCIA = (Integer) tupla[3];
		SECUENCIA = (String) tupla[4];
		ESTADO = (String) tupla[5];
		FUNCION = (String) tupla[6];
		
	}
	
	public Aminoacido(String co, Base b, String n, int l, String s, String e, String f)// Carga los atributos e inserta la nueva Aminoacido en la BD	
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Insert("INSERT INTO AMINOACIDO values('"+co+"',"+b.getCODIGO()+",'"+n+"',"+l+",'"+s+"','"+e+"','"+f+"');");
		
		CODIGO=co;
		BASE= b;
		NOMBRE = n;
		LONGITUD_SECUENCIA = l;
		SECUENCIA = s;
		ESTADO = e;
		FUNCION = f;
		
	}
	
	public void setCODIGO(String c) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET cod_amino ='" + c +"' WHERE cod_amino = '" + this.CODIGO +"';");
		CODIGO = c;
	}

	public String getCODIGO() 
	{
		return CODIGO;
	}

	public void setBase(Base b) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET cod_base =" + b.getCODIGO() +" WHERE cod_amino = '" + this.CODIGO +"';");
		BASE = b;
	}

	public Base getBase() 
	{
		return BASE;
	}

	public void setNOMBRE(String n) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET nombre =" + n +" WHERE cod_amino = '" + this.CODIGO +"';");
		NOMBRE = n;
	}

	public String getNOMBRE() 
	{
		return NOMBRE;
	}
	
	public void setSECUENCIA(String s) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET secuencia ='" + s +"' WHERE cod_amino = '" + this.CODIGO +"';");
		SECUENCIA = s;
	}
	
	public String getSECUENCIA() 
	{
		return SECUENCIA;
	}
	
	public void setESTADO(String e) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET estado = '" + e +"' WHERE cod_amino = '" + this.CODIGO +"';");
		ESTADO = e;
	}
	
	public String getESTADO() 
	{
		return ESTADO;
	}
	
	public void setFUNCION(String f) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET funcion = '" + f +"' WHERE cod_amino = '" + this.CODIGO +"';");
		FUNCION = f;
	}
	
	public String getFUNCION() 
	{
		return FUNCION;
	}

	public void setLONGITUD_SECUENCIA(int l) //Actualiza el atributo y la BD
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Update("UPDATE AMINOACIDO SET longitudSecuencia = '" + l +"' WHERE cod_amino = '" + this.CODIGO +"';");
		LONGITUD_SECUENCIA = l;
	}

	public int getLONGITUD_SECUENCIA() 
	{
		return LONGITUD_SECUENCIA;
	}
	
	public void Delete() //Borra el objeto de la BD y deja el código a ""
	{
		BD miBD = new BD(BD_SERVER, BD_NAME);
		miBD.Delete("DELETE FROM AMINOACIDO WHERE cod_amino = '"+ this.CODIGO + "';");
		CODIGO=null;
		BASE= null;
		NOMBRE = null;
		LONGITUD_SECUENCIA = -1;
		SECUENCIA = null;
		ESTADO = null;
		FUNCION = null;
	}
	
	public String toString()
	{
		return CODIGO + ";"
			+ BASE.getCODIGO() + ";"
			+ NOMBRE + ";"
			+ LONGITUD_SECUENCIA + ";"
			+ SECUENCIA + ";"
			+ ESTADO  + ";"
			+ FUNCION  + ";";
	}

}
