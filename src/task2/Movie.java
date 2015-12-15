package task2;

public class Movie
{
  public static final int REGULAR     = 0;
  public static final int NEW_RELEASE = 1;
  public static final int CHILDRENS   = 2;

  private static final PricePolicy REGULAR_PRICE_POLICY = new PricePolicy(2, 2, 1.5);
  private static final PricePolicy NEW_RELEASE_PRICE_POLICY = new PricePolicy(0, 0, 3);
  private static final PricePolicy CHILDRENS_PRICE_POLICY = new PricePolicy(1.5, 3, 1.5);

  private final String title;
  private int priceCode;

  public Movie (String title, int priceCode) {
      this.title = title;
      this.priceCode = priceCode;
  }

  public PricePolicy getPricePolicy() {
    switch (priceCode) {
      case REGULAR: return REGULAR_PRICE_POLICY;
      case NEW_RELEASE: return NEW_RELEASE_PRICE_POLICY;
      case CHILDRENS: return CHILDRENS_PRICE_POLICY;
    }
    return REGULAR_PRICE_POLICY;
  }

  public int getPriceCode () {
      return priceCode;
  }

  public void setPriceCode (int code) {
      priceCode = code;
  }

  public String getTitle () {
      return title;
  }

}
