import data.DataIn;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParserCSV {

  public static ArrayList<DataIn> listCSV;


  public static void parser (String path) {

    listCSV = loadFromFile(path);

    //listCSV.forEach(element->System.out.println(element.toString()));

  }


  private static ArrayList<DataIn> loadFromFile(String path) {
    ArrayList<DataIn> dataInList = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      for (String line : lines) {
        String[] fragments = line.split(",", 4);
        if (fragments.length != 4) {
          System.out.println("Wrong line: " + line);
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
  }



}
