package ar.edu.ub.testing.pacman.modelo.entity.ghost;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;

public interface GhostState
{

	public Entity compare(Ghost aGhost);

	public Entity compare(Pill aPill);

	public Entity compare(Pacman aPacman);

}
