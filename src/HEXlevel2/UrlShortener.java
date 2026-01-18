package HEXlevel2;

import java.util.*;

class UrlService {

    private Map<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "short.ly/";

    public String shortenUrl(String longUrl) {
        String shortCode = generateShortCode();
        urlMap.put(shortCode, longUrl);
        return BASE_URL + shortCode;
    }

    public void redirect(String shortUrl) {
        String shortCode = shortUrl.replace(BASE_URL, "");

        if (urlMap.containsKey(shortCode)) {
            System.out.println("Redirecting to: " + urlMap.get(shortCode));
        } else {
            System.out.println("Short URL not found.");
        }
    }

    private String generateShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(r.nextInt(chars.length())));
        }
        return code.toString();
    }
}

public class UrlShortener {

    public static void main(String[] args) {

        UrlService service = new UrlService();

        String sUrl1 = service.shortenUrl("https://www.example.com/java/file-handling-guide");
        String sUrl2 = service.shortenUrl("https://www.google.com/research");

        System.out.println("Short URL 1: " + sUrl1);
        System.out.println("Short URL 2: " + sUrl2);

        System.out.println();
        service.redirect(sUrl1);
        service.redirect("short.ly/xxxxxx"); 
    }
}
