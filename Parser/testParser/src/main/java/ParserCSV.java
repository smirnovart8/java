import data.DataIn;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParserCSV {

  public static ArrayList<DataIn> listCSV = new ArrayList<>();
  private static Logger logger = LogManager.getRootLogger();
  private String path;

  public ParserCSV(String path) {
    this.path = path;
  }

////////
  public void parser() {
    try {
      List<String> lines = Files.readAllLines(Paths.get(this.path));
      for (String line : lines) {
        String[] fragments = line.split(",", 4);
        if (fragments.length != 4) {
          logger.error("Wrong line!" + line);
          continue;
        }
        listCSV.add(new DataIn(
            Integer.parseInt(fragments[0]),
            Double.parseDouble(fragments[1]), fragments[2], fragments[3])
        );
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }






 /* private ArrayList<DataIn> loadFromFile(String path) {
    ArrayList<DataIn> dataInList = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      for (String line : lines) {
        String[] fragments = line.split(",", 4);
        if (fragments.length != 4) {
          logger.error("Wrong line!" + line);
          continue;
        }
        dataInList.add(new DataIn(
            Integer.parseInt(fragments[0]),
            Double.parseDouble(fragments[1]), fragments[2], fragments[3])
        );
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return dataInList;
  }*/


}
