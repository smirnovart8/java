package data;

public class DataOut {

  private int id;


  private double amount;

  private String commentary;

  private String filename;

  private int line;

  private String result;


  public DataOut(int id, double amount, String commentary, String filename,
      int line,
      String result) {
    this.id = id;
    this.amount = amount;
    this.commentary = commentary;
    this.filename = filename;
    this.line = line;
    this.result = result;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public String getCommentary() {
    return commentary;
  }

  public void setCommentary(String commentary) {
    this.commentary = commentary;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "DataOut{" +
        "id=" + id +
        ", amount=" + amount +
        ", commentary='" + commentary + '\'' +
        ", filename='" + filename + '\'' +
        ", line=" + line +
        ", result='" + result + '\'' +
        '}';
  }


}
