package com.TeamTech.Team.Controller;

import com.TeamTech.Team.Model.Athlete;
import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/athlete")
public class AthleteController {


    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @PostMapping("/{athlete_id}/teams/{team_id}/join")
    public Athlete joinTeam(
            @PathVariable Long athlete_id,
            @PathVariable Long team_id
    ){
        return athleteService.joinTeam(athlete_id,team_id);
    }

    @PutMapping("/{athlete_id}/team/{team_id}")
    public Athlete leaveTeam(
            @PathVariable Long athlete_id,
            @PathVariable Long team_id
    ){
        return athleteService.leaveTeam(athlete_id,team_id);
    }




}
