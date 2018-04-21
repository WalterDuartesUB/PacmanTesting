package ar.edu.ub.testing.pacman.modelo;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.consola.ConsolaTeclado;
import ar.edu.ub.testing.consola.menu.ConsolaMenu;
import ar.edu.ub.testing.consola.menu.ConsolaMenuItem;
import ar.edu.ub.testing.pacman.modelo.maze.Maze;

public class Juego
{

	private Consola consola;
	
	public Juego()
	{
		 this.setConsola( ConsolaTeclado.getConsola() );
	}
	
	public void jugar()
	{
		/**
		 * Debe implementarse un metodo que tenga un menu donde se permita al 
		 * usuario elegir el mapa que desea cargar, o usar uno por defecto 
		 */
		
		boolean continuar_jugando = true;
		
		while( continuar_jugando )
		{
			
			Maze           maze = this.obtenerLaberinto();		
			Partida        partida = new Partida( maze, getConsola() );		
			ResultadoJuego resultado = partida.jugar();
			
			//Informo lo que ocurrio
			this.mostrarResultadoJuego( partida, resultado );
		
			//Pregunto si quiere continuar jugando
			continuar_jugando = this.preguntarSiQuiereSeguirJugando();
		}
	}

	private Maze obtenerLaberinto()
	{
		Maze   maze = Maze.construirMaze();
		
		if( this.preguntarSiQuiereMapaPropio() )
			maze = this.obtenerLaberintoUsuario();
		
		return maze;
	}

	private Boolean preguntarSiQuiereMapaPropio()
	{
		return (Boolean) ConsolaMenu.mostrarMenu( 
				getConsola(), "Quiere cargar un mapa propio?", 
				new ConsolaMenuItem[] {
						new ConsolaMenuItem("Cargar un mapa propio desde un archivo", "S", new Boolean( true ) ),
						new ConsolaMenuItem("Usar el mapa por defecto", "N", new Boolean( false ) )
				}).getItemData();
	}

	private Maze obtenerLaberintoUsuario()
	{
		// TODO Pedir al usuario que ingrese el path
		// TODO Si ingresa un path incorrecto, alertarlo y preguntarle
		// TODO si quiere ingresar otro path o jugar con el mapa default
		
		Maze   maze = null;
		
		Maze.construirMaze( this.getConsola().nextLine() );
		
		return maze;
	}

	private Boolean preguntarSiQuiereSeguirJugando()
	{
		return (Boolean) ConsolaMenu.mostrarMenu( 
					getConsola(), "Desea volver a jugar?", 
					new ConsolaMenuItem[] {
							new ConsolaMenuItem("Jugar una nueva partida", "S", new Boolean( true ) ),
							new ConsolaMenuItem("Salir de la aplicacion", "N", new Boolean( false ) )
					}).getItemData();
	}

	private void mostrarResultadoJuego(Partida partida, ResultadoJuego resultado)
	{
		// TODO Mostrar al usuario el resultado de la partida
		
	}

	private Consola getConsola()
	{
		return consola;
	}

	private void setConsola(Consola consola)
	{
		this.consola = consola;
	}

}
