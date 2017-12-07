//package amina;

import java.io.*;
import java.util.*;

public class principal 
{

	public static void main(String[] args) 
	{
		for(Aminoacido a: Aminoacido.ListaAminoacidos()) a.Delete();
		for(Base b: Base.ListaBases()) b.Delete();
		
		//CargarBases("BASE.txt");
		//CargarAminoacidos("Aminoacido.txt");
		//CargarBases("C:\GI\Febrero2013\parcialmartes2013\src\BASE.txt");
		
		CargarBases("C:\\GI\\Febrero2013\\parcialmartes2013\\src\\BASE.txt");
		CargarAminoacidos("C:\\GI\\Febrero2013\\parcialmartes2013\\src\\Aminoacido.txt");
		
		System.out.println("Bases");
		System.out.println("=====");
		for(Base b: Base.ListaBases()) System.out.println(b.toString());
		
		System.out.println("AMINOACIDO");
		System.out.println("========");
		for(Aminoacido a: Aminoacido.ListaAminoacidos()) System.out.println(a.toString());
		
		Consulta_A();
		Consulta_B();
		Consulta_C();
		
		System.out.println("Ejecución Finalizada");
	}
	
	public static void CargarBases(String FileName)
	{
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(FileName));
			String línea = bfr.readLine();
			while (línea != null) 
			{
				StringTokenizer líneaPalabras = new StringTokenizer(línea,";");
				int id = Integer.parseInt(líneaPalabras.nextToken());
				String n = líneaPalabras.nextToken();
				// COMPLETAR	
				Base b = new Base(id,n); //añadido esto
				línea = bfr.readLine();
			}
			bfr.close();
		}
		catch (Exception e)
		{
			System.out.println("Error en CargarBases." + e.getMessage());
		}
	}
	
	public static void CargarAminoacidos(String FileName)
	{
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(FileName));
			String línea = bfr.readLine();
			while (línea != null) 
			{
				StringTokenizer líneaPalabras = new StringTokenizer(línea,";");
				String c = líneaPalabras.nextToken();
				Base b = new Base(Integer.parseInt(líneaPalabras.nextToken()));
				String n = líneaPalabras.nextToken();
				int l = Integer.parseInt(líneaPalabras.nextToken());
				String s = líneaPalabras.nextToken();
				String e = líneaPalabras.nextToken();
				String f = líneaPalabras.nextToken();
				
				// COMPLETAR
				Aminoacido amino = new Aminoacido(c,b,n,l,s,e,f);
				línea = bfr.readLine();
			}
			bfr.close();
		}
		catch (Exception e)
		{
			System.out.println("Error en CargarAminoacidos." + e.getMessage());
		}
	}
	
	public static void Consulta_A()
	{
		System.out.println("AMINOACIDOS QUE COMIENZAN POR MAF");
		System.out.println("==============================");
		// COMPLETAR	
		for(Aminoacido p : Aminoacido.ListaAminoacidos()){
			if(p.getSECUENCIA().substring(0, 3).equalsIgnoreCase("MAF")){
				System.out.println("Coincidencia encontrada!");
				System.out.println(p.getCODIGO() + ";" + p.getBase().getCODIGO() +";" + p.getNOMBRE() + ";" + p.getLONGITUD_SECUENCIA() + ";" + p.getSECUENCIA() + ";" + p.getESTADO() + ";" + p.getFUNCION());	
			}
		}
		System.out.println("\n");
	}

	public static void Consulta_B()
	{
		System.out.println("AMINOACIDOS/Base CON SECUENCIAS > 200");
		System.out.println("=================================");
		// COMPLETAR	
		for(Aminoacido p : Aminoacido.ListaAminoacidos()){
			if(p.getLONGITUD_SECUENCIA() > 200){
				System.out.println("Coincidencia encontrada!");
				System.out.println(p.getCODIGO() + ";" + p.getBase().getCODIGO() +";" + p.getNOMBRE() + ";" + p.getLONGITUD_SECUENCIA() + ";" + p.getSECUENCIA() + ";" + p.getESTADO() + ";" + p.getFUNCION());	
			}
		}
		System.out.println("\n");
	}
	
	public static void Consulta_C()
	{
		System.out.println("AminoacidoS EN Bases");
		System.out.println("=================================");
		// COMPLETAR			
		for(Aminoacido a : Aminoacido.ListaAminoacidos()){
			
		}
	}
		
}
