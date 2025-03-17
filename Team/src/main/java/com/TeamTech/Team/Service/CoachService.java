package com.TeamTech.Team.Service;

import com.TeamTech.Team.Model.Athlete;
import com.TeamTech.Team.Model.Coach;
import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Repo.AthleteRepo;
import com.TeamTech.Team.Repo.CoachRepo;
import com.TeamTech.Team.Repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    private final CoachRepo coachRepo;
    private final TeamRepo teamRepo;
    private final AthleteRepo athleteRepo;

    public CoachService(CoachRepo coachRepo, TeamRepo teamRepo, AthleteRepo athleteRepo) {
        this.coachRepo = coachRepo;
        this.teamRepo = teamRepo;
        this.athleteRepo = athleteRepo;
    }


    public Team createTeam(Coach coach ){
        Team team = new Team(coach);
        teamRepo.save(team);
        coach.getCoachesAt().add(team);
        coachRepo.save(coach);

        return team ;
    }

    public Coach joinTeam(Long coach_id, Long team_id ){
        Coach coach = coachRepo.findById(coach_id)
                .orElseThrow(() -> new RuntimeException("Athlete not Found"));
        Team team = teamRepo.findById(team_id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        if(!coach.getCoachesAt().contains(team)){
            //athlete joins team
            coach.getCoachesAt().add(team);
            //team adds athlete
            team.getAssistantCoaches().add(coach);

            //save results to the repository
            coachRepo.save(coach);
            teamRepo.save(team);
        }
        return coach;
    }

    public Coach leaveTeam(Long coach_id,Long team_id) {
        Coach coach = coachRepo.findById(coach_id)
                .orElseThrow(() -> new RuntimeException("Athlete not Found"));
        Team team = teamRepo.findById(team_id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        boolean remove = coach.getCoachesAt().remove(team);
        team.getAssistantCoaches().remove(coach);

        if(remove) {
            coachRepo.save(coach);
            teamRepo.save(team);
        }

        return coach;
    }










}
