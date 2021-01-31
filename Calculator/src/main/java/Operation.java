public class Operation {

  private String operationType;
  private int arg1;
  private int arg2;

  public String getOperationType() {
    return operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public int getArg1() {
    return arg1;
  }

  public void setArg1(int arg1) {
    this.arg1 = arg1;
  }

  public int getArg2() {
    return arg2;
  }

  public void setArg2(int arg2) {
    this.arg2 = arg2;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "operationType='" + operationType + '\'' +
        ", arg1=" + arg1 +
        ", arg2=" + arg2 +
        '}';
  }

  public String dataToCalc() {

    String forCalc = null;

    switch (this.operationType) {
      case "SUM":
        forCalc = arg1 + "+" + arg2;
        break;
      case "SUB":
        forCalc = arg1 + "-" + arg2;
        break;
      case "DIV":
        forCalc = arg1 + "/" + arg2;
        break;
      case "MUL":
        forCalc = arg1 + "*" + arg2;
        break;
    }
    return forCalc;

  }

}
