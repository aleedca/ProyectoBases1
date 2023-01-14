/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Isaac
 */
public class model_Stats {
    
    private int topNGoalScorers;
    private int topNGoalKeepers;
    private int totalMatches;
    private int matchesPlayed;
    private int totalGoalsScored;
    private int totalSaves;
    private int totalRedCards;
    private int totalYellowCards;

    public model_Stats() {
    }

    public model_Stats(int topNGoalScorers, int topNGoalKeepers, int totalMatches, int matchesPlayed, int totalGoalsScored, int totalSaves, int totalRedCards, int totalYellowCards) {
        this.topNGoalScorers = topNGoalScorers;
        this.topNGoalKeepers = topNGoalKeepers;
        this.totalMatches = totalMatches;
        this.matchesPlayed = matchesPlayed;
        this.totalGoalsScored = totalGoalsScored;
        this.totalSaves = totalSaves;
        this.totalRedCards = totalRedCards;
        this.totalYellowCards = totalYellowCards;
    }

    public int getTopNGoalScorers() {
        return topNGoalScorers;
    }

    public void setTopNGoalScorers(int topNGoalScorers) {
        this.topNGoalScorers = topNGoalScorers;
    }

    public int getTopNGoalKeepers() {
        return topNGoalKeepers;
    }

    public void setTopNGoalKeepers(int topNGoalKeepers) {
        this.topNGoalKeepers = topNGoalKeepers;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored = totalGoalsScored;
    }

    public int getTotalSaves() {
        return totalSaves;
    }

    public void setTotalSaves(int totalSaves) {
        this.totalSaves = totalSaves;
    }

    public int getTotalRedCards() {
        return totalRedCards;
    }

    public void setTotalRedCards(int totalRedCards) {
        this.totalRedCards = totalRedCards;
    }

    public int getTotalYellowCards() {
        return totalYellowCards;
    }

    public void setTotalYellowCards(int totalYellowCards) {
        this.totalYellowCards = totalYellowCards;
    }
    
    
    
}
