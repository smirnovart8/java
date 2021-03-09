

public class Main {

  public static final String FILE = "data/file1.csv";
  public static final String FILE1 = "data/file2.json";


  public static void main(String[] arg) {

    try {

      ParserCSV.parser(FILE);
      ParserJSON.parser(FILE1);

      ParserCSV.listCSV.forEach(System.out::println);
      ParserJSON.listJSON.forEach(System.out::println);

      Converter.convert(ParserCSV.listCSV).forEach(e-> System.out.println(e.toString()));
      Converter.convert(ParserJSON.listJSON).forEach(e-> System.out.println(e.toString()));



    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
