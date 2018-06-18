package scholae.codeforces;

import org.apache.commons.cli.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        } else {
            formatter.printHelp("CodeForcesTool", options);
        }
    }

    private void createProblemsCSV(String outputFileName) throws IOException {
        Problem[] problems = CodeForces.getProblems();

        File file = new File(outputFileName);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for (Problem problem: problems) {
            writer.write(problem.name);
            writer.write(",");
            writer.write(problem.contestId+" ");
            writer.newLine();
        }
        writer.close();
    }
}
