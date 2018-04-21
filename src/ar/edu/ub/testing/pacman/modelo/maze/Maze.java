package ar.edu.ub.testing.pacman.modelo.maze;

import java.util.Random;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;
import ar.edu.ub.testing.pacman.modelo.entity.direction.DirectionEntity;

public class Maze
{
	private Pacman pacman = null;
	private Ghost[] fantasmas = null;
	private Pill[]  pills = null;
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private Maze() {
		
	}
		
	public void imprimir(Consola consola)
	{
		// Muestra por consola el estado del laberinto
		// VER LA DOCUMENTACION DE LA CLASE Consola
		
	}

	public static Maze construirMaze()
	{
		// TODO Construyo el laberinto con la especificacion default
		return null;
	}


	public static Maze construirMaze(String pathMapaUsuario)
	{
		// TODO Si no puede crear el laberinto por formato invalido, debe dar una excepcion
		return null;
	}


	public Ghost[] getFantasmas()
	{
		return this.fantasmas;
	}


	public Pill[] getPills()
	{
		return this.pills;
	}

	public boolean existe(Pill pill)
	{
		return false;
	}

	public Pacman getPacman()
	{
		return this.getPacman();
	}

	private void setPacman(Pacman pacman)
	{
		this.pacman = pacman;
	}

	private void setFantasmas(Ghost[] fantasmas)
	{
		this.fantasmas = fantasmas;
	}

	private void setPills(Pill[] pills)
	{
		this.pills = pills;
	}

	public void quitar(Entity entity)
	{
		
	}

	public void tick(Ghost fantasma)
	{
		// TODO Si mi proximo paso es pared, pido todas las direcciones que no sean pared y me cambio de orientacion		
		fantasma.tick();
		
		fantasma.setDirection( this.obtenerDireccionFantasma() );
				
		this.actualizarEstadoMaze();
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private DirectionEntity obtenerDireccionFantasma() {	
		
		DirectionEntity[] direcciones = DirectionEntity.NONE.getOtherDirections();
		
		return direcciones[ new Random().nextInt() % 4 ];
	}

	public void actualizarEstadoMaze()
	{
		// TODO Este metodo debe quitar las pildoras, si se hubiese comido una
		// TODO Este metodo debe poner en invisible a los fantasmas, de haber sido comidos
		// TODO Este metodo debe matar a pacman, de haber sido comido				
	}

	public void tickPacman(DirectionEntity direccion)
	{
		// TODO hace que pacman camine
		//Si cambio de direccion, giro el pacman
		if( !direccion.sonIguales( this.getPacman().getDirection() ) )
			this.getPacman().setDirection( direccion );
		else
		{
			// TODO hago que camine
		}
	}

	public boolean isPacmanDead()
	{
		// TODO devuelve true si el pacman se murio
		return false;
	}
}
