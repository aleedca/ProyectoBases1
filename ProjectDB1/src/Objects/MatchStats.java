/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Isaac
 */
public class MatchStats {
    
    private String teamName;
    private int goals;
    private int yellowCards;
    private int redCards;
    private int offsides;
    private int corners;
    private int saves;
    
    public MatchStats(){
    
    }
    
    public MatchStats(String pTeamName, int pGoals, int pYellowCards, int pRedCards, int pOffsides, int pCorners, int pSaves){
        this.teamName = pTeamName;
        this.goals = pGoals;
        this.corners = pCorners;
        this.yellowCards = pYellowCards;
        this.redCards = pRedCards;
        this.offsides = pOffsides;
        this.saves = pSaves;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getOffsides() {
        return offsides;
    }

    public void setOffsides(int offsides) {
        this.offsides = offsides;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }
     
}
