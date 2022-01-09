package movierental;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private String _title;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case Movie.REGULAR: {
        _price = new RegularPrice();
        break;
      }
      case Movie.CHILDRENS: {
        _price = new ChildrenPrice();
        break;
      }
      case Movie.NEW_RELEASE: {
        _price = new NewReleasePrice();
        break;
      }
      default: {
        throw new IllegalArgumentException("Invalid price code");
      }

    }
  }

  public String getTitle() {
    return _title;
  }


  //determine amounts for each line
  double getCharge(int daysRented) {
    return _price.getCharge(daysRented);

  }

  int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }

}
