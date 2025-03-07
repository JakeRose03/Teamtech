package com.TeamTech.Team.Controller;

import com.TeamTech.Team.Model.Athlete;
import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/athlete")
public class AthleteController {

    @Autowired
    AthleteService athleteService;

    @PostMapping("/joinTeam")
    public List<Team> joinTeam(Athlete athlete, Team team){
        return athleteService.joinTeam(athlete,team);
    }

    @PutMapping("/leaveTeam")
    public List<Team> leaveTeam(Athlete athlete, Team team){
        return athleteService.leaveTeam(athlete,team);
    }




}
