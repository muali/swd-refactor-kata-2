package task2;

public class Rental
{
  public Rental(Movie movie, int daysRented) {
      this.movie = movie;
      this.daysRented = daysRented;
  }

  public int getDaysRented () {
      return daysRented;
  }

  public Movie getMovie () {
      return movie;
  }

  public int getFrequentRenterPoints() {
    if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
      return 2;
    return 1;
  }

  public double getAmount() {
    return movie.getPricePolicy().estimatePrice(daysRented);
  }

  private Movie movie;
  private int daysRented;
}
