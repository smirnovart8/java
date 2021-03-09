import data.DataIn;
import data.DataOut;
import java.util.ArrayList;

public class Converter {

  public static ArrayList<DataOut> outData = new ArrayList<>();

  public static ArrayList<DataOut> convert (ArrayList<DataIn> list) {

   for (int i = 0; i < list.size(); i++) {
    outData.add(new DataOut(list.get(i).getOrderId(),list.get(i).getAmount(), list.get(i).getComment(), "undefined", i, "OK" ));
   }

   return outData;

  }

}
