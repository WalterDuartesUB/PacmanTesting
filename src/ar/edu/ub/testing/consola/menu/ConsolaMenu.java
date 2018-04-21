package ar.edu.ub.testing.consola.menu;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.consola.exception.ConsolaEsNullException;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemsInvalidosException;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuTituloEsNullException;

public class ConsolaMenu 
{

	private String tituloMenu;
	private ConsolaMenuItem[] menuItem;
	private ConsolaMenuItem menuItemElegido;
	private boolean ignorarMayusculas;	
	private Consola consola;
	
	private ConsolaMenu( Consola consola, String tituloMenu, ConsolaMenuItem[] menuItem)
	{
		this.setConsola(consola);
		this.setTituloMenu(tituloMenu);
		this.setMenuItem(menuItem);		
		this.setIgnorarMayusculas( true );
	}
	
	public static ConsolaMenuItem mostrarMenu( Consola consola, String tituloMenu, ConsolaMenuItem[] menuItem)
	{
		ConsolaMenu menu = new ConsolaMenu( consola, tituloMenu, menuItem );		
		
		return menu.mostrarMenu();
	}

	public ConsolaMenuItem mostrarMenu() 
	{
		
		this.imprimir();
		this.elegirMenuItem();
		
		while( this.noEligioOpcion() )
		{		
			this.getConsola().limpiarPantalla();
			
			this.imprimir();			
			this.imprimirOpcionInvalida();
			this.elegirMenuItem();
		}
		
		return this.getMenuItemElegido();
	}

	private void imprimirOpcionInvalida() 
	{
		this.getConsola().println("(La opción ingresada no es valida. Por favor, ingrese otra.)");		
	}

	private void imprimir()
	{
		this.imprimirTitulo();
		this.imprimirOpciones();		
	}
	
	private boolean elegirMenuItem() 
	{
		String  opcionElegidaPorUsuario = this.getConsola().nextLine();
		boolean pudeElegirOpcion = this.existeMenuItemConOpcion( opcionElegidaPorUsuario );
				
		if( pudeElegirOpcion )
			this.elegirMenuItem( opcionElegidaPorUsuario );
		
		return pudeElegirOpcion;
	}

	private void elegirMenuItem(String opcionElegidaPorUsuario) 
	{
		boolean existeItem = false;
		
		for( int posicion = 0; posicion < this.getMenuItems().length && existeItem == false; posicion++ )
		{
			existeItem = this.getMenuItems()[posicion].esLaOpcion( opcionElegidaPorUsuario, this.getIgnorarMayusculas() );
			
			if( existeItem )
				this.setMenuItemElegido( this.getMenuItems()[posicion] );
		}
		
	}

	private boolean existeMenuItemConOpcion(String opcionElegidaPorUsuario) 
	{
		boolean existeItem = false;
		
		for( int posicion = 0; posicion < this.getMenuItems().length && existeItem == false; posicion++ )
			existeItem = this.getMenuItems()[posicion].esLaOpcion( opcionElegidaPorUsuario, this.getIgnorarMayusculas() );
			
		return existeItem;
	}

	private boolean noEligioOpcion() 
	{
		return this.getMenuItemElegido() == null;
	}

	private void imprimirOpciones() {
		for( int posicion = 0; posicion < this.getMenuItems().length; posicion++ )
			this.imprimir( this.getMenuItems()[posicion]);
		
	}

	private void imprimir(ConsolaMenuItem menuItem) 
	{
		this.getConsola().println( String.format("%3s - %-20s", menuItem.getOpcionEnConsola(), menuItem.getDescripcion() ) );
	}

	private void imprimirTitulo() 
	{
		if( !this.getTituloMenu().isEmpty() )
		{
			this.getConsola().println( this.getTituloMenu() );
			this.getConsola().println( String.format("%-" + new Integer( this.getTituloMenu().length( )).toString() + "s", " ").replace(" ", "-")  );
		}
	}

	private String getTituloMenu() 
	{
		return tituloMenu;
	}

	private void setTituloMenu(String tituloMenu) 
	{
		if( tituloMenu == null )
			throw new ConsolaMenuTituloEsNullException();
		
		this.tituloMenu = tituloMenu;
	}

	private ConsolaMenuItem[] getMenuItems() 
	{
		return this.menuItem;
	}

	private void setMenuItem(ConsolaMenuItem[] menuItem) 
	{
		if( !this.validarMenuItem( menuItem ) )
			throw new ConsolaMenuItemsInvalidosException();
		
		this.menuItem = menuItem;
	}

	private boolean validarMenuItem(ConsolaMenuItem[] menuItem)
	{
		if( menuItem == null || menuItem.length == 0)
			return false;
		
		Map<String, String> opcionesTeclado = new HashMap<String, String>();
		
		for( int posicion = 0; posicion < menuItem.length; posicion++)
		{ 
			if( menuItem[posicion] == null)
				return false;
			
			//Si ya existe la opcion en la lista, salgo por error
			if( opcionesTeclado.get( menuItem[posicion].getOpcionEnConsola() ) != null )
				return false;
			
			opcionesTeclado.put( menuItem[posicion].getOpcionEnConsola(), menuItem[posicion].getOpcionEnConsola() ); 
		}
		
		return true;
	}

	private ConsolaMenuItem getMenuItemElegido() 
	{
		return this.menuItemElegido;
	}

	private void setMenuItemElegido(ConsolaMenuItem menuItemElegido) 
	{
		this.menuItemElegido = menuItemElegido;
	}

	private boolean getIgnorarMayusculas() {
		return ignorarMayusculas;
	}

	private void setIgnorarMayusculas(boolean ignorarMayusculas) {
		this.ignorarMayusculas = ignorarMayusculas;
	}

	private Consola getConsola()
	{
		return consola;
	}

	private void setConsola(Consola consola)
	{		
		if( consola == null )
			throw new ConsolaEsNullException("No se puede asignar un Consola null a un ConsolaMenu.");
		
		this.consola = consola;
	}
	
}
