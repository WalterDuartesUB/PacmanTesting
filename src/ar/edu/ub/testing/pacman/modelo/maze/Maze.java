package ar.edu.ub.testing.pacman.modelo.maze;

import java.util.LinkedList;
import java.util.Random;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.EntityClear;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;
import ar.edu.ub.testing.pacman.modelo.entity.PillNormal;
import ar.edu.ub.testing.pacman.modelo.entity.PillSpecial;
import ar.edu.ub.testing.pacman.modelo.entity.Wall;
import ar.edu.ub.testing.pacman.modelo.entity.direction.DirectionEntity;

public class Maze
{
	class MazeCell {
		private LinkedList<Entity> entity;
		
		public MazeCell() {
			this.setEntity( new LinkedList<Entity>() );
		}
		
		public MazeCell( Entity entity ) {
			this();
			
			this.addEntity( entity );
		}
		
		public void addEntity(Entity entity)
		{
			this.getEntity().add(entity);			
		}

		private LinkedList<Entity> getEntity()
		{
			return entity;
		}
		private void setEntity(LinkedList<Entity> entity)
		{
			this.entity = entity;
		}
		
		@Override
		public String toString()
		{	
			//TODO buscar la entidad mas prioritaria y mostrarla
			//TODO provisoriamente, se muestra lo que este primero
			return this.getEntity().get( 0 ).getDibujo();
		}
	}	
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private Pacman       pacman = null;
	private Ghost[]      fantasmas = null;
	private Pill[]       pills = new Pill[0];
	private MazeCell[][] mazeCells = new MazeCell[0][0];
	
	///////////////////////////////////////////////////////////////////////////
	//
	
	private Maze() {
		
	}
		
	public void imprimir(Consola consola)
	{	
		consola.limpiarPantalla();
		
		for( MazeCell[] filas : this.getMazeCells() )
		{
			for( MazeCell celda : filas )
				consola.print( celda.toString() );
			
			consola.println();
		}
	}

	public static Maze construirMaze()
	{
		// TODO Construyo el laberinto con la especificacion default
		Maze maze = new Maze();
		
		// MAPA DEFAULT (Deberia moverse eventualmente a una constante)
		String mapaDefault = "WWWWWWWWWWWWWWWWWWWWWWWWWWWW\r\n" +
							 "W............WW............W\r\n" +
							 "W.WWWW.WWWWW.WW.WWWWW.WWWW.W\r\n" +
							 "W*W__W.W___W.WW.W___W.W__W*W\r\n" +
							 "W.WWWW.WWWWW.WW.WWWWW.WWWW.W\r\n" +
							 "W..........................W\r\n" +
							 "W.WWWW.WW.WWWWWWWW.WW.WWWW.W\r\n" +
							 "W.WWWW.WW.WWWWWWWW.WW.WWWW.W\r\n" +
							 "W......WW....WW....WW......W\r\n" +
							 "WWWWWW.WWWWW_WW_WWWWW.WWWWWW\r\n" +
							 "_____W.WW____________.W_____\r\n" +
							 "_____W.WW_WWW__WWW_WW.W_____\r\n" +
							 "_____W.WW_W______W_WW.W_____\r\n" +
							 "WWWWWW.WW_W______W_WW.WWWWWW\r\n" +
							 "______.___W__G___W___.______\r\n" +
							 "WWWWWW.WW_W______W_WW.WWWWWW\r\n" +
							 "_____W.WW_W______W_WW.W_____\r\n" +
							 "_____W.WW_WWWWWWWW_WW.W_____\r\n" +
							 "_____W.WW____P_____WW.W_____\r\n" +
							 "WWWWWW.WW_WWWWWWWW_WW.WWWWWW\r\n" +
							 "W............WW............W\r\n" +
							 "W.WWWW.WWWWW.WW.WWWWW.WWWW.W\r\n" +
							 "W.WWWW.WWWWW.WW.WWWWW.WWWW.W\r\n" +
							 "W*..WW....__________....WW*W\r\n" +
							 "WWW.WW.WW.WWWWWWWWWW.WW.WW.W\r\n" +
							 "WWW.WW.WW.WWWWWWWWWW.WW.WW.W\r\n" +
							 "W......WW.....WW.....WW....W\r\n" +
							 "W.WWWWWWWWWWW.WW.WWWWWWWWW.W\r\n" +
							 "W.WWWWWWWWWWW.WW.WWWWWWWWW.W\r\n" +
							 "W..........................W\r\n" +
							 "WWWWWWWWWWWWWWWWWWWWWWWWWWWW\r\n"; 
		
		maze.loadFromBuffer( mapaDefault );
		
		return maze;
	}

	/**
	 * Dado un string, crea un mapa
	 * @param buffer un String con el mapa para jugar
	 */

	private void loadFromBuffer(String buffer)
	{

		// TODO hacer las validaciones pertinentes para que se respete el formato
		
		/*
		 * Reglas: 
		 * a) todas las lineas tienen que tener la misma cantidad de caracteres
		 * b) Solo pueden existir los caracteres validos
		 * 
		 */
		
		String[] lineas = buffer.split( "\r\n" );
		
		LinkedList<MazeCell[]> mapa = new LinkedList<MazeCell[]> ();
		int cantidadColumnas = -1;
		int cantidadFilas = lineas.length;
		
		for( String linea : lineas )
		{
			//Me guardo una vez la cantidad de caracteres del mapa
			if( cantidadColumnas == -1)
				cantidadColumnas = linea.length() - 2;
			
			String[]             caracteres = linea.split("");
			LinkedList<MazeCell> filaMapa = new LinkedList<MazeCell> (); 
			
			for( String caracter : caracteres )
			{
				Entity entity = null;
				
				// TODO Esto DEBE ser refactorizado
				if( caracter.compareTo("W") == 0 )
					entity = new Wall();
				else if( caracter.compareTo(".") == 0 )
					entity = new PillNormal();
				else if( caracter.compareTo("*") == 0 )
					entity = new PillSpecial();			
				else if( caracter.compareTo("P") == 0 )
					entity = new Pacman();
				else if( caracter.compareTo("G") == 0 )
					entity = new Ghost();
				else if( caracter.compareTo("_") == 0 )
					entity = new EntityClear();
					
				//Agrego a mi fila la celda que acabo de crear
				filaMapa.add( this.new MazeCell( entity ) );
			}
			
			//Me guardo la fila que acabo de crear
			mapa.add( filaMapa.toArray( new MazeCell[cantidadColumnas] ) );
		}

		//Coloco el mapa en mi estructura
		this.setMazeCells( mapa.toArray( new MazeCell[cantidadFilas][cantidadColumnas] ) );
		
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

	private MazeCell[][] getMazeCells()
	{
		return mazeCells;
	}

	private void setMazeCells(MazeCell[][] mazeCells)
	{
		this.mazeCells = mazeCells;
	}

	public boolean seAcabaronLasPildoras()
	{
		//return this.getPills().length > 0;
		return false;
	}
}
