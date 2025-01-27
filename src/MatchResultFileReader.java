import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class MatchResultFileReader {

    private Scanner scan;

    public MatchResultFileReader(String fileName) throws
            FileNotFoundException {

        File file = new File(fileName);
        Scanner scan = new Scanner(file);

    }

    public List<MatchResult> readFile() {
        List<MatchResult> MatchResultList = new ArrayList<>();

        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            String[] data = line.split(";");

            if (data.length == 2) {
                String teams = data[0];
                String goalScorers = data[1];

                String[] goalScorersData = line.split(",");
                List<String> goalScorersList = new ArrayList<>();


                MatchResultList.add(new MatchResult(teams, goalScorersList));

            }


        }
        scan.close();
        System.out.println("Fil indlæst.");

        for(MatchResult data : MatchResultList)
        {
            System.out.println(data);
        }

        return MatchResultList;
    }
}