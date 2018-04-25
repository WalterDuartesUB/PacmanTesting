package ar.edu.ub.testing.pacman.modelo;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.consola.menu.ConsolaMenu;
import ar.edu.ub.testing.consola.menu.ConsolaMenuItem;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.direction.DirectionEntity;
import ar.edu.ub.testing.pacman.modelo.maze.Maze;

/**
 * La clase Partida es la que conoce las reglas de como jugar al Pacman
 * Se encarga de gestionar los turnos y las acciones que ocurren en los mismos
 * 
 * Por turno, el jugador puede elegir pasar el turno, o cambiar la direccion del
 * Pacman. Si elige cambiar la direccion a una distinta, gira y no avanza. Si mantiene
 * la misma direccion, avanza una posicion en el laberinto en esa direccion
 * 
 * Luego, si no se alcanza la condicion de victoria o derrota, se mueven los fantasmas.
 * 
 * 
 * @author Walter Duartes
 * 
 */
public class Partida
{
	///////////////////////////////////////////////////////////////////////////
	//
	
	private Maze 	maze = null;
	private Consola consola = null;	
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public Partida( Maze maze, Consola consola)
	{
		this.setMaze(maze);
		this.setConsola(consola);
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	public ResultadoJuego jugar()
	{	
				
		while( this.continuarPartida() )
		{			
			
			//Imprimo el tablero
			this.getMaze().imprimir( this.getConsola() );
			
			//Muevo el pacman en la direccion que quiera el usuario
			this.moverPacman();			
			
			//Solo muevo los fantasmas si sigue la partida
			/*if( this.continuarPartida() )			
				this.moverFantasmas();	*/	
		}				
		
		return this.obtenerResultadoJuego();
		
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private ResultadoJuego obtenerResultadoJuego() {
		return this.seAcabaronLasPildoras() ? ResultadoJuego.VICTORIA : ResultadoJuego.DERROTA;
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	/*private void moverFantasmas() {
		
		Ghost[] fantasmas = this.getMaze().getFantasmas();
				
		for( Ghost fantasma : fantasmas )	
			this.getMaze().tick( fantasma );
	}*/

	/////////////////////////////////////////////////////////////////////////
	//
	
	private void moverPacman() {
					
		//Giro el pacman a donde corresponda
		DirectionEntity direccion = this.obtenerDireccionPacman();
		// Muevo el pacman en la direccion del usuario
		this.getMaze().tickPacman( direccion );	
	}

	/////////////////////////////////////////////////////////////////////////
	//
	
	private DirectionEntity obtenerDireccionPacman() {
		return (DirectionEntity) ConsolaMenu.mostrarMenu( 
								getConsola(), "Hacia donde quiere mover al pacman?", 
								new ConsolaMenuItem[] {
										new ConsolaMenuItem("girar hacia arriba", "W", DirectionEntity.UP ),
										new ConsolaMenuItem("girar hacia abajo", "S", DirectionEntity.DOWN ),
										new ConsolaMenuItem("girar a la izquierda", "A", DirectionEntity.LEFT ),
										new ConsolaMenuItem("girar a la derecha", "D", DirectionEntity.RIGHT ),
										new ConsolaMenuItem("quedarse en el lugar", "Q", DirectionEntity.NONE )
								}).getItemData();
	}

	/////////////////////////////////////////////////////////////////////////
	//
	
	private boolean continuarPartida() {		
		return !this.seMurioPacman() && !this.seAcabaronLasPildoras();
	}

	/////////////////////////////////////////////////////////////////////////
	//
	
	private boolean seMurioPacman() {
		return this.getMaze().isPacmanDead();
	}

	/////////////////////////////////////////////////////////////////////////
	//
	
	private boolean seAcabaronLasPildoras() {
		return this.getMaze().seAcabaronLasPildoras();
	}

	/////////////////////////////////////////////////////////////////////////
	//
	
	private Maze getMaze() {
		return maze;
	}

	private void setMaze(Maze maze) {
		this.maze = maze;
	}

	private Consola getConsola() {
		return consola;
	}

	private void setConsola(Consola consola) {
		this.consola = consola;
	}	
}
