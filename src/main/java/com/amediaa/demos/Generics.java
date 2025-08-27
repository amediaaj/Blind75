package com.amediaa.demos;

import com.amediaa.Demo;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode) {
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
public class Generics implements Demo {

    // T upperbound is Player, S no upperbound
    class Team<T extends Player, S> {
        private String teamName;
        private List<T> teamMembers = new ArrayList<>();
        private int totalWins = 0;
        private int totalLosses = 0;
        private int totalTies = 0;
        private S affiliation;

        public Team(String teamName) {
            this.teamName = teamName;
        }

        public Team(String teamName, S affiliation) {
            this.affiliation = affiliation;
            this.teamName = teamName;
        }

        public void addTeamMember(T teamMember) {
            if (!teamMembers.contains(teamMember)) {
                teamMembers.add(teamMember);
            }
        }

        public void listTeamMembers() {
            System.out.print(teamName + " Roster:");
            System.out.println(affiliation == null ? "" : " Affiliation: " + affiliation);
            for(T t : teamMembers) {
                System.out.println(t.name());
            }
        }

        public int ranking() {
            return (totalLosses * 2) + totalTies + 1;
        }

        public String setScore(int ourScore, int theirScore) {
            String message = "lost to";
            if (ourScore > theirScore) {
                totalWins++;
                message = "beat";
            } else if (ourScore == theirScore) {
                totalTies++;
                message = "tied";
            } else {
                totalLosses++;
            }

            return message;
        }

        @Override
        public String toString() {
            return teamName + " (Ranked " + ranking() + ")";
        }
    }
    interface Player {
        String name();
    };
    record BaseballPlayer(String name, String position) implements Player {}
    record FootballPlayer(String name, String position) implements Player {}

    @Override
    public void execute() {
        var philly = new Affiliation("city", "Philidelphia, PA", "US");
        // Passing Affiliation philly
        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philidelphia Phillies", philly);
        // Passing String literal "City of Houston, Texas, in US" - no upperbound
        Team<BaseballPlayer, String> astros = new Team<>("Houston Astros", "City of Houston, Texas, in US");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
        astros.listTeamMembers();
        System.out.println();

        Team<FootballPlayer, Affiliation> cowboys = new Team<>("Dallas Cowboys");
        Team<FootballPlayer, Affiliation> eagles = new Team<>("Philidelphia Eagles");
        scoreResult(cowboys, 3, eagles, 5);

        var smith = new FootballPlayer("E Smith", "Running Back");
        var sanders = new FootballPlayer("D Sanders", "Cornerback");
        // Type safety due to using generic class - can only add FootballPlayer
        cowboys.addTeamMember(smith);
        cowboys.addTeamMember(sanders);
        cowboys.listTeamMembers();
    }

    // Overloaded to take generic class Team as params instead of BaseballTeam
    public void scoreResult(Team team1, int t1_score, Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
