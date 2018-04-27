package ar.edu.ub.testing.pacman.modelo.entity.ghost;

import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;

public interface GhostState
{

	public int compare(Ghost aGhost);

	public int compare(Pill aPill);

	public int compare(Pacman aPacman);

}
