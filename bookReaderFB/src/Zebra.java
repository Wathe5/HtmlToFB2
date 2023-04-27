import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Zebra {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.novelcool.com/chapter/Shadow-Slave-Chapter-589/9790631/");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("authority", "www.novelcool.com");
        httpConn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        httpConn.setRequestProperty("accept-language", "ru-RU,ru;q=0.9");
        httpConn.setRequestProperty("cache-control", "max-age=0");
        httpConn.setRequestProperty("cookie", "PHPSESSID=s919i2dt0hmkc3sra0hl6kekq5; novelcool_juan_view9790631=993; novelcool_webp_valid=true; Hm_lvt_6f63e48f6b1d9c9f81c0c93e32f2423a=1682603134; __atuvc=2%7C17; __atuvs=644a7c7cd5a83afe001; __atssc=google%3B2; Hm_lpvt_6f63e48f6b1d9c9f81c0c93e32f2423a=1682603235");
        httpConn.setRequestProperty("referer", "https://www.google.com/");
        httpConn.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"112\", \"Google Chrome\";v=\"112\", \"Not:A-Brand\";v=\"99\"");
        httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
        httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
        httpConn.setRequestProperty("sec-fetch-dest", "document");
        httpConn.setRequestProperty("sec-fetch-mode", "navigate");
        httpConn.setRequestProperty("sec-fetch-site", "cross-site");
        httpConn.setRequestProperty("sec-fetch-user", "?1");
        httpConn.setRequestProperty("upgrade-insecure-requests", "1");
        httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);
    }
}