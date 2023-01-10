/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Isaac
 */
public class TeamGroupStats {
    
    private String teamName;
    private int matchesPlayed;
    private int wonMatches;
    private int drawMatches;
    private int lostMatches;
    private int goalsScored;
    private int goalsReceived;
    private int goalDiff;
    private int fairPlayPoints;
    private int points;

    public TeamGroupStats() {
        this.teamName = "Prueba";
        this.wonMatches = 0;
        this.drawMatches = 0;
        this.lostMatches = 0;
        this.matchesPlayed = this.wonMatches + this.lostMatches + this.drawMatches;
        this.goalsScored = 0;
        this.goalsReceived = 0;
        this.goalDiff = this.goalsScored - this.goalsReceived;
        this.fairPlayPoints = 0;
        this.points = (this.wonMatches * 3) + this.drawMatches;
    }
    
    

    public TeamGroupStats(String teamName, int wonMatches, int drawMatches, int lostMatches, int goalsScored, int goalsReceived, int fairPlayPoints) {
        this.teamName = teamName;
        this.wonMatches = wonMatches;
        this.drawMatches = drawMatches;
        this.lostMatches = lostMatches;
        this.matchesPlayed = this.wonMatches + this.lostMatches + this.drawMatches;
        this.goalsScored = goalsScored;
        this.goalsReceived = goalsReceived;
        this.goalDiff = this.goalsScored - this.goalsReceived;
        this.fairPlayPoints = fairPlayPoints;
        this.points = (this.wonMatches * 3) + this.drawMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }

    public int getDrawMatches() {
        return drawMatches;
    }

    public void setDrawMatches(int drawMatches) {
        this.drawMatches = drawMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public void setGoalDiff(int goalDiff) {
        this.goalDiff = goalDiff;
    }

    public int getFairPlayPoints() {
        return fairPlayPoints;
    }

    public void setFairPlayPoints(int fairPlayPoints) {
        this.fairPlayPoints = fairPlayPoints;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
}
