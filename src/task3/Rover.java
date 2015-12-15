package task3;

public class Rover {
  public Rover(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void receiveSingleCommand(char command) {
    command = Character.toUpperCase(command);
    switch (command) {
      case 'F': move(1); break;
      case 'B': move(-1); break;
      case 'L': turnLeft(); break;
      case 'R': turnRight(); break;
      default: throw new RuntimeException("Unknown command");
    }
  }

  public void receiveCommands(String commands) {
    for (int i = 0; i < commands.length(); i++)
      receiveSingleCommand(commands.charAt(i));
  }

  public String getPosition() {
    return coordinates.toString();
  }

  private void move(int step) {
    int dx = 0;
    int dy = 0;
    switch (coordinates.getDirection()) {
      case NORTH: dy = step; break;
      case SOUTH: dy = -step; break;
      case EAST:  dx = step; break;
      case WEST:  dx = -step; break;
    }
    doMove(coordinates.getX(), dx);
    doMove(coordinates.getY(), dy);
  }

  private static void doMove(Point point, int delta) {
    int newLocation = point.getLocation() + delta;
    if (newLocation < 0)
      newLocation += point.getMaxLocation() + 1;
    if (newLocation > point.getMaxLocation())
      newLocation -= point.getMaxLocation() + 1;
    point.setLocation(newLocation);
  }

  private void turnLeft() {
    switch (coordinates.getDirection()) {
      case NORTH: coordinates.setDirection(Direction.WEST);  break;
      case WEST:  coordinates.setDirection(Direction.SOUTH); break;
      case SOUTH: coordinates.setDirection(Direction.EAST);  break;
      case EAST:  coordinates.setDirection(Direction.NORTH); break;
    }
  }

  private void turnRight() {
    switch (coordinates.getDirection()) {
      case NORTH: coordinates.setDirection(Direction.EAST);  break;
      case WEST:  coordinates.setDirection(Direction.NORTH); break;
      case SOUTH: coordinates.setDirection(Direction.WEST);  break;
      case EAST:  coordinates.setDirection(Direction.SOUTH); break;
    }
  }

  private final Coordinates coordinates;
}
