package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String _name;
  private List<Rental> _rentals = new ArrayList<Rental>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";

    for (Rental rental : _rentals) {
      Movie movie = rental.getMovie();
      double charge = rental.getCharge();
      result +=
        "" +
          "\t" + movie.getTitle() +
          "\t" + String.valueOf(charge) +
          "\n";
    }

    double totalAmount = getTotalCharge();
    int frequentRenterPoints = getTotalPoints();
    // add footer lines
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

    return result;
  }

  double getTotalCharge() {
    double res = 0;
    for (Rental rental : _rentals) {
      res += rental.getCharge();
    }
    return res;
  }


  int getTotalPoints() {
    int res = 0;
    for (Rental each : _rentals) {
      res += each.getFrequentRenterPoints();
    }
    return res;
  }

}
