import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NovelTrimer
{
    public static void main(String[] args)
    {
        StringBuffer text = new StringBuffer("");
        try(FileReader reader = new FileReader("E:\\SupremacyGames\\ShadowSlave294.fb2"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                text.append((char) c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        text = new StringBuffer(text.toString().replaceAll("&lt;/novelbiin&gt;", ""));
        try (FileWriter writer = new FileWriter("E://SupremacyGames/ShadowSlave294.fb2"))
        {
            writer.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
