import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Draft
{
    public static void main(String[] args)
    {
        StringBuilder text = new StringBuilder();

        File folder = new File("E:\\SupremacyGames"); // ваш путь папки

        String[] files = folder.list(new FilenameFilter()
                                    {
                                        @Override
                                        public boolean accept(File folder, String name)
                                        {
                                            return name.endsWith(".html"); // ищет конкретно нужный файл
                                        }
                                    });

        for(String name : files)
        {
            try(FileReader reader = new FileReader("G:\\SupremacyGames\\" + name))
            {
                // читаем посимвольно
                int c;
                while((c=reader.read())!=-1)
                {
                    text.append((char) c);
                }
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
    }
}
