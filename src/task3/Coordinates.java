package task3;

import java.util.List;

public class Coordinates {
  public Point getX() {
    return xValue;
  }

  public Point getY() {
    return yValue;
  }

  public void setDirection(Direction value) {
    direction = value;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setObstacles(List<Obstacle> value) {
    obstacles = value;
  }

  public Coordinates(Point xValue,
                     Point yValue,
                     Direction directionValue,
                     List<Obstacle> obstaclesValue) {
    this.xValue = xValue;
    this.yValue = yValue;
    direction = directionValue;
    obstacles = obstaclesValue;
  }

  @Override
  public String toString() {
    return String.valueOf(xValue.getLocation()) + " X " + String.valueOf(yValue.getLocation()) + " " + direction.toString();
  }


  private final Point xValue;
  private final Point yValue;
  private Direction direction;
  private List<Obstacle> obstacles;
}