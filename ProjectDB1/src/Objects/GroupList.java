/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Nahomy
 */
public class GroupList {
    String teamName;
    String matchDate;
    String stadium;
    String teamFlag; 

    public GroupList() {
    }

    public GroupList(String teamName, String matchDate, String stadium, String teamFlag) {
        this.teamName = teamName;
        this.matchDate = matchDate;
        this.stadium = stadium;
        this.teamFlag = teamFlag;
    }
    
    
    
    //setters
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setTeamFlag(String teamFlag) {
        this.teamFlag = teamFlag;
    }
    
    //getters

    public String getTeamName() {
        return teamName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getStadium() {
        return stadium;
    }

    public String getTeamFlag() {
        return teamFlag;
    }

    @Override
    public String toString() {
        return "GroupList{" + "teamName=" + teamName + ", matchDate=" + matchDate + ", stadium=" + stadium + ", teamFlag=" + teamFlag + '}';
    }
    
    
    
}
