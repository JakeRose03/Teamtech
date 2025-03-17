package com.TeamTech.Team.Service;

import com.TeamTech.Team.Model.Athlete;
import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {


    private final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Athlete> getAthleteOnTeam(Long team_id){
        Team team = teamRepo.findById(team_id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        return team.getAthletes();

    }

    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

    public List<Team> findByName(String name){
        List<Team> teamWithName = teamRepo.findByName(name);

        if(teamWithName == null){
            throw new RuntimeException("Team not found");
        }

        return teamWithName;

    }




}
