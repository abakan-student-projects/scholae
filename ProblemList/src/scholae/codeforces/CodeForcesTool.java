package scholae.codeforces;

import org.apache.commons.cli.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class CodeForcesTool {

    public static void main(String[] args) throws IOException {
        new CodeForcesTool().run(args);
    }

    private void run(String[] args) throws IOException {
        Options options = new Options();
        Option input = new Option("c", "command", true, "Command: problems - get problems and put them into CSV");
        input.setRequired(true);
        options.addOption(input);
        Option output = new Option("o", "output", true, "output file (for different commands)");
        output.setRequired(true);
        options.addOption(output);
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("CodeForcesTool", options);

            System.exit(1);
        }

        String commandName = cmd.getOptionValue("command");

        if ("problems".equals(commandName)) {
            createProblemsCSV(cmd.getOptionValue("output"));
        } else if ("tags".equals(commandName)) {
            createTagsCSV(cmd.getOptionValue("output"));
        }
        {
            formatter.printHelp("CodeForcesTool", options);
        }

    }

    final static String UrlProblem = "http://codeforces.com/problemset/problem/";

    private void createProblemsCSV(String outputFileName) throws IOException {
        Problem[] problems = CodeForces.getProblems();
        File file = new File(outputFileName);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Problem problem : problems) {
            writer.write(problem.name);
            writer.write(",");
            writer.write(UrlProblem + problem.contestId + "/" + problem.index);
            writer.newLine();
        }
        writer.close();
    }

    private void createTagsCSV(String outputFile) throws IOException {
        Problem[] problems = CodeForces.getProblems();
        HashSet<String> tags = new HashSet<>();
        File file = new File(outputFile);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Problem problem : problems) {
            int j = problem.tags.length;
            for (int i=0;i<j;i++){
                String str = problem.tags[i];
                tags.add(str);
            }
        }

       for (String item:tags){
            writer.write(item);
            writer.newLine();
       }
        writer.close();
    }
}