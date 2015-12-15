package task2;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
  public Customer(String name) {
      this.name = name;
  }

  public void addRental(Rental rental) {
      rentals.add(rental);
  }

  public String getName() {
      return name;
  }

  public String statement () {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName () + "\n";

    for (Rental rental: rentals) {
      frequentRenterPoints += rental.getFrequentRenterPoints();

      double thisAmount = rental.getAmount();
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

    return result;
  }

  private String name;
  private List<Rental> rentals = new ArrayList<>();
}
