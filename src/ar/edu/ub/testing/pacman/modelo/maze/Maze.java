package ar.edu.ub.testing.pacman.modelo.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateDead;

public class Maze
{
	
    private static final String DATA_TXT_DIR = "C:\\Maze.txt";   // provisorio
    
    
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
		private Entity checkEntity()
		{
			return this.getEntity().get( 0 );
		}
		
		private void setEntity(LinkedList<Entity> entity)
		{
			this.entity = entity;
		}
		
		public void pacCheck(LinkedList<Entity> entity, Pacman pacman){
			for (int i = 0; i <= entity.size();i++) {
				pacman.compare(entity.get(i));
			}
		}
		
		@Override
		public String toString()
		{	
			//TODO buscar la entidad mas prioritaria y mostrarla
			//TODO provisoriamente, se muestra lo que este primero
			return this.getEntity().get( 0 ).getDibujo();
		}
	}

	private static String[] pruebas;	
	
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

	public static Maze construirMazeDefault() {
		Maze maze = new Maze();
		
		// MAPA DEFAULT (Deberia moverse eventualmente a una constante

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
	
	public static Maze construirMaze() throws FileNotFoundException, IOException 
	{
		// TODO Construyo el laberinto con la especificacion default
		Maze maze = new Maze();
		String mapaPersonalizado = leerTxt(DATA_TXT_DIR);	
		maze.loadFromBuffer( mapaPersonalizado);
		return maze;
	}
	
    public static String leerTxt(String archivo) throws FileNotFoundException, IOException{
    	FileReader f = new FileReader(archivo);
    	BufferedReader b = new BufferedReader(f);
    	int i = 0;
    	int cantidadLineas = obtenerCantidadLineas(archivo);
    	// Falta validar el tamaño del mapa personalizado
    	 String [] mapaProvisorio = new String[cantidadLineas];
    	for (String line = b.readLine(); line != null ; line = b.readLine()) {
    		mapaProvisorio[i] = line;
    		i++;
    	}
    	b.close();
    	String mapa = pasamanoProvisorio(mapaProvisorio);
    	return mapa;
    }
    
	public static int obtenerCantidadLineas(String archivo) throws IOException {
		
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		int cantidadLineas = 0;
		for (String line = b.readLine(); line != null ; line = b.readLine()) {
			cantidadLineas ++ ;
		}
		b.close();	
		return cantidadLineas;
	}
	
	public static String pasamanoProvisorio(String [] prueba) {
		String mapa = "";
		for (int i = 0; i <prueba.length ; i++) {
			mapa = mapa +prueba[i] +"\r\n";
		}
		return mapa;
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
				else if( caracter.compareTo("P") == 0 ) {
					
					this.setPacman( new Pacman(caracteres.toString().indexOf(caracter), lineas.toString().indexOf(linea)) );
					entity = this.getPacman();
				}
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
	
	public static Maze construirMazeDefault(String pendienteMenu) {
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
		return this.pacman;
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
		System.out.println(this.getPacman());
		if( !direccion.sonIguales( this.getPacman().getDirection() ) )
			this.getPacman().setDirection( direccion );
		else
		{
			if (!nextStepIsWall(this.getPacman())){
				this.getPacman().tick();
				normalizarStep(this.getPacman());
			}
		}
	}
	
	public boolean nextStepIsWall(Pacman entity){
		Pacman pacman = entity;
		pacman.getDirection().getStep();
		
		return this.mazeCells[pacman.getPosicion().getX()][pacman.getPosicion().getY()].checkEntity() instanceof Wall;
	}
	
	public boolean nextStepIsWall(Ghost entity){
		Ghost fantasma = entity;
		fantasma.getDirection().getStep();
		return this.mazeCells[fantasma.getPosicion().getX()][fantasma.getPosicion().getY()].checkEntity() instanceof Wall;
	}
	
	public void normalizarStep(Entity entity) {
		if (entity.getPosicion().getX() > this.mazeCells.length) {
			entity.getPosicion().setX(0);
		}
		if (entity.getPosicion().getY() > this.mazeCells[0].length) {
			entity.getPosicion().setY(0);
		}
		
	}
		
	public boolean isPacmanDead()
	{
		return this.pacman.getState() instanceof PacmanStateDead;
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
		return pills.length == 0;
	}
}
