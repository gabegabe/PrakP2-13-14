import java.io.FileWriter;
import java.io.IOException;
 
public class GenerateCsv
{
   public static void main(String [] args)
   {
	   generateCsvFile("c:\\test.csv"); 
   }
 
   private static void generateCsvFile(String sFileName)
   {
	try
	{
	    FileWriter writer = new FileWriter(sFileName);
 
	    writer.append("id");
	    writer.append(',');
	    writer.append("nim");
	    writer.append(',');
	    writer.append("nama");
	    writer.append(',');
	    writer.append("telp");
	    writer.append(',');
	    writer.append("angkatan");
	    writer.append(',');
	    writer.append("alamat");
	    writer.append('\n');
 
	    writer.append("1");
	    writer.append(',');
	    writer.append("1299991");
	    writer.append(',');
	    writer.append("Dadang");
	    writer.append(',');
	    writer.append("0812345678");
	    writer.append(',');
	    writer.append("2013");
	    writer.append(',');
	    writer.append("Jl Bangau Jaksel");
	    writer.append('\n');
		
		writer.append("2");
	    writer.append(',');
	    writer.append("1299992");
	    writer.append(',');
	    writer.append("Jimmy");
	    writer.append(',');
	    writer.append("0813456789");
	    writer.append(',');
	    writer.append("2012");
	    writer.append(',');
	    writer.append("Jl Merak Jaksel");
	    writer.append('\n');
		
		writer.append("3");
	    writer.append(',');
	    writer.append("1299993");
	    writer.append(',');
	    writer.append("Adi");
	    writer.append(',');
	    writer.append("0814567890");
	    writer.append(',');
	    writer.append("2011");
	    writer.append(',');
	    writer.append("Jl Perkutut Jaksel");
	    writer.append('\n');
		
		writer.append("4");
	    writer.append(',');
	    writer.append("1299994");
	    writer.append(',');
	    writer.append("Lukman");
	    writer.append(',');
	    writer.append("08145678901");
	    writer.append(',');
	    writer.append("2014");
	    writer.append(',');
	    writer.append("Jl Jaksa Jaksel");
	    writer.append('\n');
		
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
    }
}