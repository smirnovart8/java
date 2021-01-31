import junit.framework.TestCase;

public class OperationTest extends TestCase {

  Operation operation = new Operation();

  @Override
  protected void setUp() throws Exception {

    operation.setOperationType("MUL");
    operation.setArg1(455);
    operation.setArg2(433);

  }

  public void testDataToCalcTest() {

    String actual = operation.dataToCalc();
    String expected = "455*433";
    assertEquals(expected, actual);

  }

  @Override
  protected void tearDown() throws Exception {

  }
}
