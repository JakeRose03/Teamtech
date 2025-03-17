package com.TeamTech.Team.Service;
import com.TeamTech.Team.Model.Athlete;

import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Repo.AthleteRepo;
import com.TeamTech.Team.Repo.TeamRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepo athleteRepo;
    private final TeamRepo teamRepo;

    public AthleteService(AthleteRepo athleteRepo, TeamRepo teamRepo) {
        this.athleteRepo = athleteRepo;
        this.teamRepo = teamRepo;
    }


    @Transactional
    public Athlete joinTeam(Long athlete_id, Long team_id ){
        Athlete athlete = athleteRepo.findById(athlete_id)
                .orElseThrow(() -> new RuntimeException("Athlete not Found"));
        Team team = teamRepo.findById(team_id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        if(!athlete.getTeams().contains(team)){
            athlete.getTeams().add(team);
            team.getAthletes().add(athlete);
        }
        return athlete;
    }

    @Transactional
    public Athlete leaveTeam(Long athlete_id,Long team_id) {
        Athlete athlete = athleteRepo.findById(athlete_id)
                .orElseThrow(() -> new RuntimeException("Athlete not Found"));
        Team team = teamRepo.findById(team_id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        athlete.getTeams().remove(team);
        team.getAthletes().remove(athlete);

        return athlete;
    }

}
