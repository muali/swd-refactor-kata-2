package task2;

/**
 * Created by Moskvitin Maxim.
 */
public class PricePolicy {

  private final double basePrice;
  private final int baseDays;
  private final double extraDaysPrice;

  public PricePolicy(double basePrice, int baseDays, double extraDaysPrice) {
    this.basePrice = basePrice;
    this.baseDays = baseDays;
    this.extraDaysPrice = extraDaysPrice;
  }

  public double estimatePrice(int days) {
    return basePrice + Math.max(0, days - baseDays) * extraDaysPrice;
  }

}
