import java.io.File;

public class Main {

  public static void main(String[] args) {

    String path = "H:\\Projects\\FilesForProjects".replaceAll("\\\\", "/");
    // Читал, что если такие слэши, то убирается кроссплатформенность, поэтому заменил их
    File folder = new File(path);
    if(folder.isDirectory()) {
      File[] files = folder.listFiles();

      for(File file : files) {
        System.out.println(file);
      }

      File newFolder = new File(path + "/braveNewFolder");
      newFolder.mkdir();

      newFolder.delete();
    }
    else {
      System.out.println("This is not a folder");
    }


  }
}
