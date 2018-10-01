import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file coppy:");
        String fileCoppiedPath = new Scanner(System.in).next();
        readFile(fileCoppiedPath);
        String content = readFile(fileCoppiedPath);
        System.out.println("Nhập đường dẫn file đích:");
        String fileTargetPath = new Scanner(System.in).next();
        coppyFile(content, fileTargetPath );
        readFile(fileTargetPath);
    }

    public static String readFile(String filePath) {
        String content = "";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại!");
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                content += line + "\n";
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return content;
    }

    public static void coppyFile(String content, String pathFile) {
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException("File không tồn tại!");
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\n" + content);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
