package ar.edu.ub.testing.consola.menu;

import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemDescripcionInvalidaException;
import ar.edu.ub.testing.consola.menu.exception.ConsolaMenuItemOpcionEnConsolaInvalidaException;
import ar.edu.ub.testing.util.StringUtils;

public class ConsolaMenuItem 
{
	private String descripcion; 
	private String opcionEnConsola; 
	private Object itemData;
	
	public ConsolaMenuItem( String descripcion, String opcionEnConsola, Object itemData)
	{
		setDescripcion(descripcion);
		setOpcionEnConsola(opcionEnConsola);
		setItemData(itemData);
	}
	public String getOpcionEnConsola() 
	{
		return opcionEnConsola;
	}
	private void setOpcionEnConsola(String opcionEnConsola) 
	{
		if( StringUtils.isEmpty(opcionEnConsola) )
			throw new ConsolaMenuItemOpcionEnConsolaInvalidaException();
		
		this.opcionEnConsola = opcionEnConsola;
	}
	public Object getItemData() 
	{
		return itemData;
	}
	private void setItemData(Object itemData) 
	{
		this.itemData = itemData;
	}
	public String getDescripcion() 
	{
		return descripcion;
	}
	private void setDescripcion(String descripcion) 
	{
		if( StringUtils.isEmpty(descripcion) )
			throw new ConsolaMenuItemDescripcionInvalidaException();
		
		this.descripcion = descripcion;
	}
	public boolean esLaOpcion(String opcionElegidaPorUsuario, boolean ignorarMayusculas) 
	{
		if( ignorarMayusculas )
			return opcionElegidaPorUsuario.compareToIgnoreCase( this.getOpcionEnConsola() ) == 0;
			
		return opcionElegidaPorUsuario.compareTo( this.getOpcionEnConsola() ) == 0;
	}
}
