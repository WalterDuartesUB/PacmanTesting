package ar.edu.ub.testing.pacman.modelo.entity;

public class Posicion
{

	private Integer x;
	private Integer y;
	
	public Posicion(Integer x, Integer y)
	{
		this.setX(x);
		this.setY(y);
	}

	public Integer getY()
	{
		return y;
	}
	
	public void setY(Integer y)
	{
		this.y = y;
	}
	public Integer getX()
	{
		return x;
	}
	public void setX(Integer x)
	{
		this.x = x;
	}
	
	public boolean sonIguales( Posicion otraPosicion )
	{
		return this.getX() == otraPosicion.getX() && this.getY() == otraPosicion.getY();
	}

	public Posicion add(Posicion posicion)
	{
		return new Posicion( this.getX() + posicion.getX(), this.getY() + posicion.getY() );
	}
}
