

public class Main {

  //public static final String FILE = "data/file1.csv";
  //public static final String FILE1 = "data/file2.json";
  private static final String CMD = "INCORRECT COMMAND";

  public static void main(String[] arg) {



    if (arg.length !=0) {

      for (int i=0; i < arg.length; i++) {

        try {
          if (arg[i].endsWith(".csv")) {

            ParserCSV.parser(arg[i]);
            //ParserCSV.listCSV.forEach(System.out::println);
            Converter.convert(ParserCSV.listCSV).forEach(e -> System.out.println(e.toString()));
            continue;
          }
          else if (arg[i].endsWith(".json")) {
            ParserJSON.parser(arg[i]);
           // ParserJSON.listJSON.forEach(System.out::println);
            Converter.convert(ParserJSON.listJSON).forEach(e -> System.out.println(e.toString()));
            continue;
          }
          else {
            System.out.println(arg[i] + "  " + CMD);
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    else
      System.out.println(CMD);
  }


}
