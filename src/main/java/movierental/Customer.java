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

  public String statement(Report report) {
    double totalAmount = getTotalCharge();
    int frequentRenterPoints = getTotalPoints();
    String customerName = getName();
    
    return report.generate(_rentals, customerName, totalAmount, frequentRenterPoints);
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
