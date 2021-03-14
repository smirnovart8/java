import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
  
  private static final String CMD = "INCORRECT FORMAT";
  private static final String NOTFOUND = "FILES NOT FOUND";

  private static final Logger logger = LogManager.getRootLogger();

  public static void main(String[] arg) {
    if (arg.length != 0) {

      for (String s : arg) {

        try {
          if (s.endsWith(".csv")) {

            new ParserCSV(s).parser();
            Converter.convert(ParserCSV.listCSV, s)
                .forEach(e -> System.out.println(e.toString()));
          } else if (s.endsWith(".json")) {
            new ParserJSON(s).parser();
            Converter.convert(ParserJSON.listJSON, s)
                .forEach(e -> System.out.println(e.toString()));
          } else {
            logger.info(s + "  " + CMD);
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } else {
      logger.error(NOTFOUND);
    }
  }

}
