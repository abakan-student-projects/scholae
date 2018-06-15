import java.net.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*import java.io.FileWriter;
import java.io.File;*/

public class Pr_list{

    public static void main(String[] args) throws Exception {

        URL code = new URL("http://codeforces.com/api/problemset.problems");
        URLConnection connect = code.openConnection();
        BufferedReader data = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        //String inputdata;
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(data);

        for (Object ob : jsonArray){
            JSONObject problem = (JSONObject) ob;
            String name = (String) problem.get("name");
            System.out.print(name);
        }
        /*
        inputdata = data.readLine();
        File file_csv = new File("data.csv");
        file_csv.createNewFile();
        FileWriter filewrite=null;
        filewrite=new FileWriter(file_csv);
        filewrite.write(inputdata);*/
    }
}
