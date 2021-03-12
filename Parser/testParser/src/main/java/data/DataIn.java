package data;


public class DataIn {

  private int orderId;

  private double amount;

  private String currency;


  private String comment;


  public DataIn(int id, double amount, String currency, String comment) {
    this.orderId = id;
    this.amount = amount;
    this.currency = currency;
    this.comment = comment;
  }


  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int id) {
    this.orderId = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public String toString() {
    return "DataIn{" +
        "id='" + orderId + '\'' +
        ", amount='" + amount + '\'' +
        ", currency='" + currency + '\'' +
        ", comment='" + comment + '\'' +
        '}';
  }

}
