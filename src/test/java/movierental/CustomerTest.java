package movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

  @Test
  public void testTextReport() {
    Customer customer = new Customer("Bob");
    customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
    customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
    customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
    customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
    customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
    customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

    String expected = "" +
      "Rental Record for Bob\n" +
      "\tJaws\t2.0\n" +
      "\tGolden Eye\t3.5\n" +
      "\tShort New\t3.0\n" +
      "\tLong New\t6.0\n" +
      "\tBambi\t1.5\n" +
      "\tToy Story\t3.0\n" +
      "Amount owed is 19.0\n" +
      "You earned 7 frequent renter points";

    assertEquals(expected, customer.statement(new TextReport()));
  }

  @Test
  public void testHtmlRecord() {
    Customer customer = new Customer("Bob");
    customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));

    String expected = """
      <h1>Rental Record for <em>Bob</em></h1>
      <table>
      <tr><td>Ran</td><td>2.000000</td></tr>
      <tr><td>Jaws</td><td>2</td></tr>
      </table>
      <p>Amount owed is <em>2.000000</em></p>
      <p>You earned <em>1</em> frequent renter points</p>
      """;

    assertEquals(expected, customer.statement(new HtmlReport()));
  }
}