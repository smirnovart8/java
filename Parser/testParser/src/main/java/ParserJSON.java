
import com.google.gson.Gson;
import data.DataIn;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ParserJSON {

  public static ArrayList<DataIn> listJSON;

  public static void parser(String path) throws IOException {

    String line;
    DataIn data;
    listJSON = new ArrayList<>();
    BufferedReader myReader = new BufferedReader(new FileReader(path));

    while ((line = myReader.readLine()) != null) {
      data = new Gson().fromJson(line, DataIn.class);
      listJSON.add(data);
    }

  }

}


