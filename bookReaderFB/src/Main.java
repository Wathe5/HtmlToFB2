import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException
    {
        Integer num = 13;
        Scanner in = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        /*
        System.out.println("Insert:\n");
        text.append(in.nextLine());
        try(FileReader reader = new FileReader("G:\\SupremacyGames\\ch318.html"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                text.append((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<FictionBook xmlns=\"http://www.gribuser.ru/xml/fictionbook/2.0\"\n" +
                "  xmlns:l=\"http://www.w3.org/1999/xlink\">\n" +
                "   <description>\n" +
                "    <title-info>\n" +
                "     <genre>science</genre>\n" +
                "     <author>\n" +
                "      <first-name>GuiltyTree</first-name>\n" +
                "     </author>\n" +
                "     <book-title>Shadow Slave</book-title>\n" +
                "     <lang>en</lang>\n" +
                "     <src-lang>en</src-lang>\n" +
                "    </title-info>\n" +
                "    <document-info>\n" +
                "     <author>\n" +
                "      <nickname></nickname>\n" +
                "      <email></email>\n" +
                "     </author>\n" +
                "    </document-info>\n" +
                "    <publish-info>\n" +
                "     <book-name>Shadow Slave</book-name>\n" +
                "     <publisher>NOne</publisher>\n" +
                "     <city>None</city>\n" +
                "     <year>2020</year>\n" +
                "    </publish-info>\n" +
                "   </description>\n" +
                "  <body>";
        try (FileWriter writer = new FileWriter("E://SupremacyGames/ShadowSlave294.fb2"))
        {
            writer.write(str);
            //for (int i = num; i < 32; i++) //764
            //{
                str = "";
                str += Cleaner1(FileParser());
                //str += Cleaner2(new StringBuffer(Parser("https://www.novelmt.com/novel/shadow-slave_" + i + ".html")));
                //Тестерstr = "<title><p>" + i + "</p></title>";
                writer.write(str);
                //System.out.println("Chapter " + i + " downloaded.\n");
                //Thread.sleep(3000);
            //}
            str = "  </body>\n" +
                    "</FictionBook>";
            writer.write(str);
            writer.flush();
        }
    }

    public static String Cleaner1(StringBuilder[] __text)
    {
        StringBuffer newText = new StringBuffer();
        for (StringBuilder _text : __text)
        {
            if (_text != null)
            {
                System.out.println(_text.substring(0, 256));
                newText.append("<section>\n<title><p>");
                int j = _text.indexOf("<title>") + 7;
                int jEnd = _text.indexOf("|");
                if (j != -1)
                    while (j < jEnd)
                    {
                        newText.append(_text.charAt(j));
                        j++;
                    }
                newText.append("</p></title>\n");

                StringBuffer chapter = new StringBuffer(_text.substring(_text.indexOf("<p>"), _text.indexOf("</div", _text.indexOf("<p>"))));
                while(chapter.toString().contains("<script"))
                    chapter.replace(chapter.indexOf("<script"), chapter.indexOf("</script>") + 9, "");
                while(chapter.toString().contains("<ins"))
                    chapter.replace(chapter.indexOf("<ins"), chapter.indexOf("</ins>") + 7, "");
                chapter.append("</section>\n");
                newText.append(chapter);
                /*int i = 0, end = 0;
                for (int q = 0; q < 2; q++)
                {
                    i = _text.indexOf("<p>", end);
                    end = _text.indexOf("<script", i);
                    if (i != -1)
                        while (i < end)
                        {
                            newText.append(_text.charAt(i));
                            i++;
                        }
                }
                i = _text.indexOf("<p>", end);
                end = _text.indexOf("</div", i);
                if (i != -1)
                    while (i < end)
                    {
                        newText.append(_text.charAt(i));
                        i++;
                    }
                newText.append("</section>\n");*/
            }
            else
            {
                System.out.println("\n\nWOW\n\n");
            }
        }
        return newText.toString();
    }
    public static String Cleaner2(StringBuffer _text)
    {
        StringBuffer newText = new StringBuffer("<section>\n<title><p>");
        Integer j = _text.indexOf("<h2>") + 4;
        Integer jEnd = _text.indexOf("</h2>");
        while(j < jEnd)
        {
            newText.append(_text.charAt(j));
            j++;
        }
        newText.append("</p></title>\n");
        int i = _text.indexOf("<p>");
        int end = _text.indexOf("<div", i);
        while (i < end)
        {
            newText.append(_text.charAt(i));
            i++;
        }

        newText.append("</section>\n");
        System.out.println(newText);
        return newText.toString();
    }

    public static String Parser(String address) throws IOException
    {
        URL url = new URL(address);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("authority", "www.novelmt.com");
        httpConn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        httpConn.setRequestProperty("accept-language", "ru-RU,ru;q=0.9");
        httpConn.setRequestProperty("cookie", "nightmode=0; _ga=GA1.2.1188595302.1679423434; _gid=GA1.2.655028324.1679423434; _gat_gtag_UA_41950902_2=1; __cf_bm=egKdHgkWmuw_eBOUEcTCOhAbzGK3qDefgrevEUWQKAQ-1679423436-0-AZFmkoABwdApCpwvD8oTIf2VuuQOHXW+1ia4xyOijLp0wB+ZmI+YK2mRBZozptXRYbdo/z2vP2OSz+L0YqB04Luv+MUGCR186JKDYaKMXYAmRm03wFm6ZeeZmHqW2ra5sw==; __atuvc=2%7C12; __atuvs=6419f7caf8bb14a7001");
        httpConn.setRequestProperty("referer", "https://www.novelmt.com/novel/shadow-slave.html");
        httpConn.setRequestProperty("sec-ch-ua", "\"Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111\"");
        httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
        httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
        httpConn.setRequestProperty("sec-fetch-dest", "document");
        httpConn.setRequestProperty("sec-fetch-mode", "navigate");
        httpConn.setRequestProperty("sec-fetch-site", "same-origin");
        httpConn.setRequestProperty("sec-fetch-user", "?1");
        httpConn.setRequestProperty("upgrade-insecure-requests", "1");
        httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        return response;
    }

    public static StringBuilder[] FileParser()
    {
        StringBuilder[] text = new StringBuilder[1000];

        File folder = new File("C:\\Users\\pusto\\OneDrive\\Рабочий стол\\Новая папка (2)"); // ваш путь папки

        String[] files = folder.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File folder, String name)
            {
                return name.endsWith(".html"); // ищет конкретно нужный файл
            }
        });

        int i = 0;
        for(String name : files)
        {
            try(FileReader reader = new FileReader("C:\\Users\\pusto\\OneDrive\\Рабочий стол\\Новая папка (2)\\" + name))
            {
                // читаем посимвольно
                int c;
                text[i] = new StringBuilder();
                while((c=reader.read())!=-1)
                {
                    text[i].append((char) c);
                }
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            i++;
            System.out.println(i);
        }
        return text;
    }

}