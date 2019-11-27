import java.io.File;
import java.io.FileInputStream;

public class Main {

  public static void main(String[] args) {
    firstStep();     // Обычное чтение файлов
    secondStep();    // Через  inputStream
  }

  public static void firstStep() {
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

  public static void secondStep() {
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
}
