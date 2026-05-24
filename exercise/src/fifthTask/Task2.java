package fifthTask;

import java.io.*;

public class Task2 {
    public static void main(String[] args) 
    {
        String code = 
            "class FileOutIn{\n" +
            "    private String name;\n" +
            "    private int length;\n" +
            "    public FileOutIn(String name, int length){\n" +
            "        this.name = name;\n" +
            "        this.length = length;\n" +
            "    }\n" +
            "}";

        File file = new File("src/fifthTask/dict.txt");
        try (FileWriter writer = new FileWriter(file)) 
        {
            writer.write(code);
            System.out.println("已写入: " + file.getAbsolutePath());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        // 读取
        System.out.println("\n读取 dict.txt 内容：");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}