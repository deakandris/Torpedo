package com.epam.cleancode.torpedo.util;

import com.epam.cleancode.torpedo.ship.Ship;

/**
 * Class representing a 1�1 size part of the {@link Ship}.
 * @author Andras_Deak
 *
 */
public class ShipPart {

	private final Position position;
	private boolean damaged;
	
	/** Creates a new ship part object from relative coordinates.
	 * @param x the row index of the position
	 * @param y the column index of the position
	 */
	public ShipPart(int x, int y) {
		position = new Position(x, y);
	}

	/** Creates a new ship part object from a {@link Position}.
	 * @param position the relative position of the part in the {@link Ship}
	 */
	public ShipPart(Position position) {
		this.position = position;
	}

	/**
	 * @return the relative position of the part in the {@link Ship}
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Returns {@code true} if the parameter is adjacent to this ship part, including the trivial case of equivalence.
	 * @param position to check
	 * @return whether the given position is next to or equal to the ship part
	 * @see Position#isAdjacent(Position)
	 */
	public boolean isAdjacent(Position position) {
		return this.position.isAdjacent(position);
	}
	
	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged() {
		damaged = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (damaged ? 1231 : 1237);
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipPart other = (ShipPart) obj;
		if (damaged != other.damaged)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + position + ", " + (damaged ? "X" : "O") + "]";
	}
	
}
