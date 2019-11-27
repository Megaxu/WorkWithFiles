import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    firstStep();     // Обычное чтение файлов
    secondStep();    // Через inputStream
    thirdStep();     // Через bufferedReader
    fourthStep();    // Через Files

  }

  private static void firstStep() {

    String path = "H:\\Projects\\FilesForProjects".replaceAll("\\\\", "/");
    // Читал, что если такие слэши, то убирается кроссплатформенность, поэтому заменил их
    File folder = new File(path);
    if (folder.isDirectory()) {
      File[] files = folder.listFiles();

      for (File file : files) {
        System.out.println(file);
      }

      File newFolder = new File(path + "/braveNewFolder");
      newFolder.mkdir();

      newFolder.delete();
    } else {
      System.out.println("This is not a folder");
    }
  }

  private static void secondStep() {

    StringBuilder builder = new StringBuilder();

    try {
      FileInputStream is = new FileInputStream("data/info.txt");
      for (; ; ) {
        int code = is.read();
        if (code < 0) {
          break;
        }
        char ch = (char)code;
        builder.append(ch);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(builder.toString());
  }

  private static void thirdStep() {

    StringBuilder builder = new StringBuilder();

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("data/info.txt"));
      for (; ; ) {
        String line = bufferedReader.readLine();
        if (line == null) {
          break;
        }
        builder.append(line + "\n");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(builder.toString());
  }

  private static void fourthStep() {

    StringBuilder builder = new StringBuilder();

    try {
      List<String> lines = Files.readAllLines(Paths.get("data/info.txt"));
      lines.forEach(line -> builder.append(line + "\n"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(builder.toString());
  }
}
