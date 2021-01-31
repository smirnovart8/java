import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class FIleProcess {

  private String xmlFile;
  private String outXmlFile;

  private List<Double> outLines = new ArrayList<>();

  private List<Operation> operations = new ArrayList<>();

  public FIleProcess(String xmlFile, String outXmlFile) {
    this.xmlFile = xmlFile;
    this.outXmlFile = outXmlFile;
  }

  private void readXML() throws ParserConfigurationException, IOException, SAXException {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File(xmlFile));

    NodeList operationNodeList = document.getElementsByTagName("operation");

    for (int i = 0; i < operationNodeList.getLength(); i++) {
      if (operationNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
        Element operationElement = (Element) operationNodeList.item(i);

        Operation operation = new Operation();
        operation.setOperationType(operationElement.getAttribute("OperationType"));

        NodeList childNodes = operationElement.getChildNodes();

        for (int j = 0; j < childNodes.getLength(); j++) {
          if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
            Element childElement = (Element) childNodes.item(j);
            switch (childElement.getNodeName()) {

              case "arg1":
                operation.setArg1(Integer.valueOf(childElement.getTextContent()));
                break;
              case "arg2":
                operation.setArg2(Integer.valueOf(childElement.getTextContent()));
                break;
            }

          }
        }
        operations.add(operation);
      }
    }

  }

  private void generateXML()
      throws ParserConfigurationException, TransformerException, FileNotFoundException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();

    Element calculator = document.createElement("SimpleCalculator");
    Element results = document.createElement("results");

    document.appendChild(calculator);
    calculator.appendChild(results);

    outLines.forEach(line -> {
      Element result = document.createElement("result");
      results.appendChild(result);
      Text text = document.createTextNode(line.toString());
      result.appendChild(text);
    });

    Transformer t = TransformerFactory.newInstance().newTransformer();
    t.setOutputProperty(OutputKeys.INDENT, "yes");
    t.transform((new DOMSource(document)), new StreamResult(new FileOutputStream(outXmlFile)));


  }

  public void calculate()
      throws IOException, SAXException, ParserConfigurationException, TransformerException {
    readXML();
    operations.forEach(o -> outLines.add(new Calculator(o.dataToCalc()).process()));
    generateXML();


  }


}



