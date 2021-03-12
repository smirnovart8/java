import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  public static final String FILE = "data/file1.csv";
  public static final String FILE1 = "data/file2.json";
  private static final String CMD = "INCORRECT FORMAT";
  private static final String NOTFOUND = "FILES NOT FOUND";

  private static Logger logger = LogManager.getRootLogger();

  public static void main(String[] arg) {

    if (arg.length != 0) {

      for (int i = 0; i < arg.length; i++) {

        try {
          if (arg[i].endsWith(".csv")) {

            ParserCSV.parser(arg[i]);
            Converter.convert(ParserCSV.listCSV, arg[i])
                .forEach(e -> System.out.println(e.toString()));
            continue;
          } else if (arg[i].endsWith(".json")) {
            ParserJSON.parser(arg[i]);
            Converter.convert(ParserJSON.listJSON, arg[i])
                .forEach(e -> System.out.println(e.toString()));
            continue;
          } else {
            logger.info(arg[i] + "  " + CMD);
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } else {
      logger.error(NOTFOUND);
    }
  }

  /*public static void main(String[] arg) {


    try {

      ParserCSV.parser(FILE);
      ParserJSON.parser(FILE1);

      Converter.convert(ParserCSV.listCSV,"filename").forEach(e-> System.out.println(e.toString()));
      Converter.convert(ParserJSON.listJSON,"filename").forEach(e-> System.out.println(e.toString()));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }*/

}
