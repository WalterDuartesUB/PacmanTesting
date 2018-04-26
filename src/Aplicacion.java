import java.io.FileNotFoundException;
import java.io.IOException;

import ar.edu.ub.testing.pacman.modelo.Juego;

public class Aplicacion
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Juego juego = new Juego();
		
		juego.jugar();
	}
}
