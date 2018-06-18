package scholae.codeforces;

import com.google.gson.Gson;

public class CodeForces {

    final static String apiUrl = "https://codeforces.com/api/";

    public static Problem[] getProblems() {
        String url = apiUrl + "problemset.problems";
        Gson gson = new Gson();
        ProblemsetProblemsResponse response = gson.fromJson(url, ProblemsetProblemsResponse.class);

        return (response.result != null) ? response.result.problems : null;
    }
}
