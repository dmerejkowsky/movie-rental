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

class HtmlReport extends Report {
  @Override
  String header(String customerName) {
    String h1 = String.format("<h1>Rental Record for <em>%s</em></h1>\n", customerName);
    return h1 + "<table>\n";
  }

  @Override
  String row(Rental rental) {
    Movie movie = rental.getMovie();
    String movieTitle = movie.getTitle();
    int daysRended = rental.getDaysRented();
    String row1 = String.format("<tr><td>Ran</td><td>%.1f</td></tr>\n", rental.getCharge());
    String row2 = String.format("<tr><td>%s</td><td>%d</td></tr>\n", movieTitle, daysRended);
    return row1 + row2;
  }

  @Override
  String footer(double totalAmount, int frequentRenterPoints) {
    String res = "</table>\n";
    res += String.format("<p>Amount owed is <em>%.1f</em></p>\n", totalAmount);
    res += String.format("<p>You earned <em>%d</em> frequent renter points</p>\n", frequentRenterPoints);
    return res;
  }
}