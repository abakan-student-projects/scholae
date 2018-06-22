package scholae.codeforces;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CodeForcesTest {

  static String readFile(String path, Charset encoding) {
    try {
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      return new String(encoded, encoding);
    } catch (IOException e) {
      return null;
    }
  }

  @Test
  public void testGetProblemStatement() {
    Document document = Jsoup.parse(readFile("src/test/java/scholae/codeforces/CodeForcesTest_getProblemStatement_994_A.txt", Charset.forName("UTF-8")));
    Elements page = document.getElementsByAttributeValue("class", "problem-statement");

    assertEquals(
            page.toString(),
            CodeForces.getProblemStatement(994, "A"));
  }
}