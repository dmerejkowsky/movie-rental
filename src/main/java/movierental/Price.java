package movierental;

public abstract interface Price {
  abstract int getPriceCode();

  abstract double getCharge(int daysRented);

  abstract int getFrequentRenterPoints(int daysRented);
}

class ChildrenPrice implements Price {
  @Override
  public int getPriceCode() {
    return Movie.CHILDRENS;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3)
      result += (daysRented - 3) * 1.5;
    return result;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}

class NewReleasePrice implements Price {
  @Override
  public int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    if (daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}

class RegularPrice implements Price {
  @Override
  public int getPriceCode() {
    return Movie.REGULAR;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2)
      result += (daysRented - 2) * 1.5;
    return result;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
