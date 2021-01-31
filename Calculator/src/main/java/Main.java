import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Main {


  public static void main (String[] args)
      throws IOException, SAXException, ParserConfigurationException, TransformerException {

    FIleProcess file = new FIleProcess("data/SimpleCalculatorSrc.xml", "data/SimpleCalculatorDst.xml");
    file.calculate();

  }
}
