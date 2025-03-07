package com.TeamTech.Team.Service;

import com.TeamTech.Team.Model.Coach;
import com.TeamTech.Team.Model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    public Team createTeam(Coach coach , String name, String pass){

        return new Team(coach, name , pass);
    }

    public List<Team> joinTeam(Team team , Coach coach ){
        if(!team.getCoaches().contains(coach)){
            team.getCoaches().add(coach);
            coach.getCoachesAt().add(team);
        }else{
            System.out.println("Already in team");
        }
        return coach.getCoachesAt();
    }

    public List<Team> leaveTeam(Team team, Coach coach){
        team.getCoaches().remove(coach);
        coach.getCoachesAt().remove(team);
        return coach.getCoachesAt();
    }


}
