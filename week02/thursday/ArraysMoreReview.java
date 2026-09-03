import org.w3c.dom.ls.LSOutput;

public class SandBox {
    public static void main(String[] args) {
        String[][] nfcTeams = {
                {"Eagles", "Cowboys", "Commanders", "Giants"},     // NFC East
                {"49ers", "Rams", "Seahawks", "Cardinals"},        // NFC West
                {"Lions", "Packers", "Vikings", "Bears"},          // NFC North
                {"Buccaneers", "Falcons", "Saints", "Panthers"}    // NFC South
        };

        System.out.println(nfcTeams.length); // <-- how many divisions in the NFC

        System.out.println(nfcTeams[1].length); // <-- how many teams in the NFC East

        String[][][] nflTeams = {
                {   // NFC
                        {"Eagles", "Cowboys", "Commanders", "Giants"},      // East
                        {"49ers", "Rams", "Seahawks", "Cardinals"},         // West
                        {"Lions", "Packers", "Vikings", "Bears"},           // North
                        {"Buccaneers", "Falcons", "Saints", "Panthers"}     // South
                },
                {   // AFC
                        {"Bills", "Dolphins", "Jets", "Patriots"},          // East
                        {"Chiefs", "Chargers", "Raiders", "Broncos"},       // West
                        {"Ravens", "Steelers", "Bengals", "Browns"},        // North
                        {"Texans", "Colts", "Jaguars", "Titans"}            // South
                }
        };

        System.out.println(nflTeams.length); // how many conferences are there in the NFL?
        System.out.println(nflTeams[0].length); // how many divisions are there in the NFC?
        System.out.println(nflTeams[1].length); // how many divisions are there in the AFC?

        System.out.println(nflTeams[0][3].length); // how many teams are there in the NFC South?
        
    }


}
