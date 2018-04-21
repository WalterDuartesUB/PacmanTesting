package ar.edu.ub.testing.consola.testcase;

import ar.edu.ub.testing.consola.exception.ConsolaEsNullException;
import ar.edu.ub.testing.consola.menu.ConsolaMenu;
import ar.edu.ub.testing.consola.menu.ConsolaMenuItem;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemsInvalidosException;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuTituloEsNullException;
import ar.edu.ub.testing.consola.testingutil.ConsolaTecladoEmulada;
import junit.framework.TestCase;

public class TestConsolaMenu extends TestCase
{
	public void testConsolaNull()
	{
		try
		{
			ConsolaMenuItem[] 	menuItems = new ConsolaMenuItem[] { new ConsolaMenuItem("descripcion", "opcionEnConsola", null) };
			String				titulo = "titulo";
			ConsolaTecladoEmulada consola = null;
			
			ConsolaMenu.mostrarMenu(consola, titulo, menuItems );
			assertTrue(false);
		}
		catch (ConsolaEsNullException e)
		{
		}
	}
	
	public void testTituloNull()
	{
		try
		{
			ConsolaMenuItem[] 	menuItems = new ConsolaMenuItem[] { new ConsolaMenuItem("descripcion", "opcionEnConsola", null) };
			String				titulo = null;
			ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "asd" } );
			
			ConsolaMenu.mostrarMenu( consola, titulo, menuItems);
			assertTrue(false);
		}
		catch (ConsolaMenuTituloEsNullException e)
		{
		}
	}
	
	public void testTituloVacio()
	{

		ConsolaMenuItem[] 	menuItems = new ConsolaMenuItem[] { new ConsolaMenuItem("descripcion", "X", null) };
		String				titulo = "";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "X" } );
		
		assertEquals( menuItems[0], ConsolaMenu.mostrarMenu( consola, titulo, menuItems) );
		
	}
	
	public void testMenuItemsNull()
	{
		try
		{
			ConsolaMenuItem[] 	menuItems = null;
			String				titulo = "titulo";
			ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "asd" } );
			
			ConsolaMenu.mostrarMenu( consola, titulo, menuItems);
			assertTrue(false);
		}
		catch (ConsolaMenuItemsInvalidosException e)
		{
		}
	}
	
	public void testMenuItemsVacio()
	{
		try
		{
			ConsolaMenuItem[] 	menuItems = new ConsolaMenuItem[] {};
			String				titulo = "titulo";
			ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "asd" } );
			
			ConsolaMenu.mostrarMenu( consola, titulo, menuItems);
			assertTrue(false);
		}
		catch (ConsolaMenuItemsInvalidosException e)
		{
		}
	}
	
	public void testMenuItemsAlgunNull()
	{
		try
		{
			ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { new ConsolaMenuItem("descripcion", "X", null), null };
			String				titulo = "titulo";
			ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "asd" } );
			
			ConsolaMenu.mostrarMenu( consola, titulo, menuItems);
			assertTrue(false);
		}
		catch (ConsolaMenuItemsInvalidosException e)
		{
		}
	}
	
	public void testMenuItemsRepetidos()
	{
		try
		{
			ConsolaMenuItem		item = new ConsolaMenuItem("descripcion", "X", null);
			ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { item, item };
			String				titulo = "titulo";
			ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "asd" } );
			
			ConsolaMenu.mostrarMenu( consola, titulo, menuItems);
			assertTrue(false);
		}
		catch (ConsolaMenuItemsInvalidosException e)
		{
		}
	}
	
	public void testMenuItemsDiferentes1()
	{
	
		ConsolaMenuItem		item = new ConsolaMenuItem("descripcion X", "X", null);
		ConsolaMenuItem		item2 = new ConsolaMenuItem("descripcion Y", "Y", null);
		ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { item, item2 };
		String				titulo = "titulo";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "Y" } );
		
		assertEquals( item2, ConsolaMenu.mostrarMenu( consola, titulo, menuItems) );
	}
	
	public void testMenuItemsDiferentes2()
	{
		ConsolaMenuItem		item = new ConsolaMenuItem("descripcion X", "X", null);
		ConsolaMenuItem		item2 = new ConsolaMenuItem("descripcion Y", "Y", null);
		ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { item, item2 };
		String				titulo = "titulo";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { "123", "456", "Y" } );
		
		assertEquals( menuItems[1], ConsolaMenu.mostrarMenu( consola, titulo, menuItems) );
	}
	
	public void testMenuItemsItemDataElegido()
	{
		String				itemData = "DZ";
		String				opcionConsola = "X";
		ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { new ConsolaMenuItem("descripcion X", opcionConsola, itemData)  };
		String				titulo = "titulo";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { opcionConsola } );
		
		assertEquals( itemData, ConsolaMenu.mostrarMenu( consola, titulo, menuItems).getItemData() );
	}	
	
	public void testMenuItemsDescripcionElegida()
	{
		String				itemData = "DZ";
		String				descripcion = "descripcion X";
		String				opcionConsola = "X";
		ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { new ConsolaMenuItem(descripcion, opcionConsola, itemData)  };
		String				titulo = "titulo";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { opcionConsola } );
		
		assertEquals( descripcion, ConsolaMenu.mostrarMenu( consola, titulo, menuItems).getDescripcion() );
	}	
	
	public void testMenuItemsOpcionConsolaElegida()
	{
		String				itemData = "DZ";
		String				descripcion = "descripcion X";
		String				opcionConsola = "X";
		ConsolaMenuItem[] 	menuItems =  new ConsolaMenuItem[] { new ConsolaMenuItem(descripcion, opcionConsola, itemData)  };
		String				titulo = "titulo";
		ConsolaTecladoEmulada consola = new ConsolaTecladoEmulada( new String[] { opcionConsola } );
		
		assertEquals( opcionConsola, ConsolaMenu.mostrarMenu( consola, titulo, menuItems).getOpcionEnConsola() );
	}	
}
