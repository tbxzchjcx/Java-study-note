package test;
import java.io.*;
public class Task3 
{
	public static void main(String[] args)
	{
		String s="class FileOutIn{\n" +
	            "    private String name;\n" +
	            "    private int length;\n" +
	            "    public FileOutIn(String name, int length){\n" +
	            "        this.name = name;\n" +
	            "        this.length = length;\n" +
	            "    }\n" +
	            "}";
		File file=new File("src/test/dict.txt");
		try(FileWriter writer=new FileWriter(file))
		{
			writer.write(s);
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		try(BufferedReader reader=new BufferedReader(new FileReader(file)))
		{
			String line;
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}

	}
}
