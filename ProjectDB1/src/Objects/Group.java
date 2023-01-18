/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Isaac
 */
public class Group {
    
    private TeamGroupStats Team1;
    private TeamGroupStats Team2;
    private TeamGroupStats Team3;
    private TeamGroupStats Team4;
    
    private int idGroup;
    private String descriptionGroup;

    public Group() {
    }

    public Group(TeamGroupStats Team1, TeamGroupStats Team2, TeamGroupStats Team3, TeamGroupStats Team4) {
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.Team3 = Team3;
        this.Team4 = Team4;
    }

    public TeamGroupStats getTeam1() {
        return Team1;
    }

    public void setTeam1(TeamGroupStats Team1) {
        this.Team1 = Team1;
    }

    public TeamGroupStats getTeam2() {
        return Team2;
    }

    public void setTeam2(TeamGroupStats Team2) {
        this.Team2 = Team2;
    }

    public TeamGroupStats getTeam3() {
        return Team3;
    }

    public void setTeam3(TeamGroupStats Team3) {
        this.Team3 = Team3;
    }

    public TeamGroupStats getTeam4() {
        return Team4;
    }

    public void setTeam4(TeamGroupStats Team4) {
        this.Team4 = Team4;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getDescriptionGroup() {
        return descriptionGroup;
    }

    public void setDescriptionGroup(String descriptionGroup) {
        this.descriptionGroup = descriptionGroup;
    }
    
    
    
    
}
