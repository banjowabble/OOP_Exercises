import java.io.*;

public class Utils {

    public static String readContentFromFile(String path) {
        StringBuilder st = new StringBuilder();
        try {
            FileReader reader = new FileReader(path);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                st.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.toString();
    }

    public static void writeContentToFile(String path) {
        try {
            FileWriter writer = new FileWriter(path, false);
            BufferedWriter out = new BufferedWriter(writer);
            PrintWriter printer = new PrintWriter(out);
            printer.println("Overridden!");
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendContentToFile(String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(writer);
            PrintWriter printer = new PrintWriter(out);
            printer.println(" Appended!");
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String string = readContentFromFile("D:\\JavaProjects\\OOPWeek13\\src\\Input.txt");
        System.out.println(string);

        writeContentToFile("D:\\JavaProjects\\OOPWeek13\\src\\OverrideOutput.txt");

        appendContentToFile("D:\\JavaProjects\\OOPWeek13\\src\\AppendOutput.txt");

        System.out.println(findFileByName("D:\\JavaProjects\\OOPWeek13\\src", "Input.txt"));
        System.out.println(findFileByName("D:\\JavaProjects\\OOPWeek13\\src", "Non_existent.txt"));
    }
}
