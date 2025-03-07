package com.TeamTech.Team.Service;
import com.TeamTech.Team.Model.Athlete;

import com.TeamTech.Team.Model.Team;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class AthleteService {


    public List<Team> joinTeam(Athlete athlete, Team team ){
        if(!team.getAthletes().contains(athlete)){
            team.getAthletes().add(athlete);
            athlete.getTeams().add(team);

        }else{
            System.out.println("Already in team");
        }
        return athlete.getTeams();
    }

    public List<Team> leaveTeam(Athlete athlete,Team team){
        team.getAthletes().remove(athlete);
        athlete.getTeams().remove(team);
        return athlete.getTeams();

    }


}
