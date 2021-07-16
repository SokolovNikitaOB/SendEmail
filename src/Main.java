import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /**
         * Для демонастрации работы метода созданы и заполенены две хэш таблицы
         */
        HashMap<String, String> sitesToday = new HashMap<>();
        HashMap<String, String> sitesYesterday = new HashMap<>();

        sitesToday.put("vk.com", "HTML_1");
        sitesToday.put("youtube.com", "HTML_2");
        sitesToday.put("nsu.ru", "HTML_3");

        sitesYesterday.put("vk.com", "HTML_1*");
        sitesYesterday.put("youtube.com", "HTML_2");
        sitesYesterday.put("yandex.ru", "HTML_3");
        sitesYesterday.put("google.com", "HTML_4");

        System.out.println(SendEmail.createEmail(sitesToday, sitesYesterday,"Olya"));

    }


}


