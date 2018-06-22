package scholae.codeforces;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class CodeForces {

    final static String apiUrl = "https://codeforces.com/api/";

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static Problem[] getProblems() {
        String url = apiUrl + "problemset.problems";
        String data = null;
        try {
            data = readUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        ProblemsetProblemsResponse response = gson.fromJson(data, ProblemsetProblemsResponse.class);
        return (response.result != null) ? response.result.problems : null;
    }

    public static String getProblemStatement(int contestId, String index) {
        try {
            Document document = Jsoup.connect("https://codeforces.com/problemset/problem/" + contestId + "/" + index + "?locale=ru").get();
            Elements page = document.getElementsByAttributeValue("class", "problem-statement");
            return page.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
