package movierental;

import java.util.List;


public abstract class Report {
  abstract String header(String customerName);

  abstract String row(Rental rental);

  abstract String footer(double totalAmount, int frequentRenterPoints);

  public String generate(List<Rental> rentals, String customerName, double totalAmount, int frequentPoints) {
    String res = "";
    res += header(customerName);
    for (Rental rental : rentals) {
      res += row(rental);
    }
    res += footer(totalAmount, frequentPoints);
    return res;
  }


}

class TextReport extends Report {
  @Override
  String header(String customerName) {
    return "Rental Record for " + customerName + "\n";
  }

  @Override
  String row(Rental rental) {
    Movie movie = rental.getMovie();
    double charge = rental.getCharge();
    return
      "" +
        "\t" + movie.getTitle() +
        "\t" + String.valueOf(charge) +
        "\n";
  }


  @Override
  String footer(double totalAmount, int frequentRenterPoints) {
    String result = "";
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    return result;
  }
}

