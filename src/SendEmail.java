import java.util.ArrayList;
import java.util.HashMap;


public class SendEmail {

    /**
     * Этот метод предназначен для выявления исчезнувших сайтов.
     * В качестве аргументов передаются хэш таблицы сайтов сегодня и вчера.
     * Возвращается список исчезнувших сайтов.
     */
    public static ArrayList<String> checkMissingSites (HashMap<String, String> sitesToday,
                                                       HashMap<String, String> sitesYesterday){
        ArrayList<String> missingSites = new ArrayList<>();
        for(String siteYesterday : sitesYesterday.keySet()){
            if(!sitesToday.containsKey(siteYesterday)) missingSites.add(siteYesterday);
        }
        return missingSites;
    }

    /**
     * Этот метод предназначен для выявления появившихся сайтов.
     * В качестве аргументов передаются хэш таблицы сайтов сегодня и вчера.
     * Возвращается список появившихся сайтов.
     */
    public static ArrayList<String> checkAppearingSites  (HashMap<String, String> sitesToday,
                                                          HashMap<String, String> sitesYesterday){
        ArrayList<String> appearingSites = new ArrayList<>();
        for(String siteToday : sitesToday.keySet()){
            if(!sitesYesterday.containsKey(siteToday)) appearingSites.add(siteToday);
        }
        return appearingSites;
    }

    /**
     * Этот метод предназначен для выявления изменившихся сайтов.
     * В качестве аргументов передаются хэш таблицы сайтов сегодня и вчера.
     * Возвращается список изменившихся сайтов.
     */
    public static ArrayList<String> checkChangingSites (HashMap<String, String> sitesToday,
                                                        HashMap<String, String> sitesYesterday){
        ArrayList<String> changingSites = new ArrayList<>();
        for(String siteToday : sitesToday.keySet()){
            if(sitesYesterday.containsKey(siteToday)){
                if(sitesYesterday.get(siteToday).compareTo(sitesToday.get(siteToday)) != 0) changingSites.add(siteToday);
            }
        }
        return changingSites;
    }

    /**
     * Этот метод предназначен для составления письма.
     * В качестве аргументов передаются хэш таблицы сайтов сегодня и вчера и имя секретаря.
     * Письмо составляется с помощью экземпляра класса StringBuilder.
     */
    public static StringBuilder createEmail (HashMap<String, String> sitesToday,
                                             HashMap<String, String> sitesYesterday, String nameSecretary){
        StringBuilder email = new StringBuilder();

        email.append("Здравствуйте, дорогая " + nameSecretary +
                "\nЗа последние сутки во вверенных Вам сайтах произошли следующие изменения:");

        email.append("\nИсчезли следующие страницы:");
        for(String s : checkMissingSites(sitesToday, sitesYesterday)){
            email.append("\n " + s);
        }

        email.append("\nПоявились следующие новые страницы:");
        for(String s : checkAppearingSites(sitesToday, sitesYesterday)){
            email.append("\n " + s);
        }

        email.append("\nИзменились следующие страницыЖ");
        for(String s : checkChangingSites(sitesToday, sitesYesterday)){
            email.append("\n " + s);
        }

        email.append("\nС уважением, автоматизированная система мониторинга.");

        return email;
    }
}
