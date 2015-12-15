package task3;

public enum Direction {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  @Override
  public String toString() {
    switch (this) {
      case NORTH: return "N";
      case EAST:  return "E";
      case SOUTH: return "S";
      case WEST:  return "W";
    }
    return "";
  }
}
