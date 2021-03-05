import java.util.Enumeration;

public abstract class Statement {

  protected abstract String getResultPrologue(Customer aCustomer);
  protected abstract String getRentalFigures(Rental aRental);
  protected abstract String getResultEpilogue(Customer aCustomer);

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = getResultPrologue(aCustomer);

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // show figures for this rental
      result += getRentalFigures(each);
    }

    // add footer lines
    result += getResultEpilogue(aCustomer);
    return result;
  }
}