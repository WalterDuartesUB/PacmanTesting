package ar.edu.ub.testing.consola.testcase;

import ar.edu.ub.testing.consola.menu.ConsolaMenuItem;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemDescripcionInvalidaException;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemOpcionEnConsolaInvalidaException;
import junit.framework.TestCase;

public class TestConsolaMenuItem extends TestCase
{
	public void testCrearSinDescripcion()
	{
		try
		{
			String descripcion = "";
			String opcionEnConsola = "X";
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemDescripcionInvalidaException e)
		{
			
		}
	}
	
	public void testCrearDescripcionVacia()
	{
		try
		{
			String descripcion = "";
			String opcionEnConsola = "X";
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemDescripcionInvalidaException e)
		{
		
		}
	}
	
	public void testCrearDescripcionNull()
	{
		try
		{
			String descripcion = null;
			String opcionEnConsola = "X";
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemDescripcionInvalidaException e)
		{
			
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public void testCrearSinOpcionEnConsola()
	{
		try
		{
			String descripcion = "descripcion";
			String opcionEnConsola = "";
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemOpcionEnConsolaInvalidaException e)
		{
			
		}
	}
	
	public void testCrearOpcionEnConsolaVacia()
	{
		try
		{
			String descripcion = "descripcion";
			String opcionEnConsola = " ";
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemOpcionEnConsolaInvalidaException e)
		{
		
		}
	}
	
	public void testCrearOpcionEnConsolaNull()
	{
		try
		{
			String descripcion = "descripcion";
			String opcionEnConsola = null;
			Object itemData = null;
			
			assertNull( new ConsolaMenuItem(descripcion, opcionEnConsola, itemData ));
			
		}
		catch (ConsolaMenuItemOpcionEnConsolaInvalidaException e)
		{
			
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public void testCrear()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
			
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertEquals(descripcion, menuItem.getDescripcion());
		assertEquals(opcionEnConsola, menuItem.getOpcionEnConsola() );
		assertEquals(itemData, menuItem.getItemData() );
	}	
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public void testEsOpcionIgnorandoMayusculas()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = true;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
				
		assertTrue( menuItem.esLaOpcion( opcionEnConsola, ignorarMayusculas ));
	}	
	
	public void testEsOpcionIgnorandoMayusculasToLower()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = true;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertTrue( menuItem.esLaOpcion( opcionEnConsola.toLowerCase(), ignorarMayusculas ));
	}	
	
	public void testEsOpcionIgnorandoMayusculasToUpper()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "x";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = true;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertTrue( menuItem.esLaOpcion( opcionEnConsola.toUpperCase(), ignorarMayusculas ));
	}	
	
	public void testNoEsOpcionIgnorandoMayusculas()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = true;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertFalse( menuItem.esLaOpcion( "Y", ignorarMayusculas ));
	}	
	
	public void testEsOpcionNoIgnorandoMayusculas()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = false;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertTrue( menuItem.esLaOpcion( opcionEnConsola, ignorarMayusculas ));
	}	
	
	public void testEsOpcionNoIgnorandoMayusculasToLower()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = false;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertFalse( menuItem.esLaOpcion( opcionEnConsola.toLowerCase(), ignorarMayusculas ));
	}	
	
	
	public void testEsOpcionNoIgnorandoMayusculasToUpper()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "x";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = false;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertFalse( menuItem.esLaOpcion( opcionEnConsola.toUpperCase(), ignorarMayusculas ));
	}	
	
	public void testNoEsOpcionNoIgnorandoMayusculas()
	{	
		String descripcion = "Avion";
		String opcionEnConsola = "X";
		Object itemData = new Integer(7);
		boolean ignorarMayusculas = false;
		
		ConsolaMenuItem menuItem = new ConsolaMenuItem(descripcion, opcionEnConsola, itemData );
		
		assertFalse( menuItem.esLaOpcion( "Y", ignorarMayusculas ));
	}	
}
