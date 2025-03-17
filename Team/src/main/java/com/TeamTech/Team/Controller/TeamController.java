package com.TeamTech.Team.Controller;

import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/teams")
public class TeamController {


    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{team_name}")
    public List<Team> getTeamByName(@PathVariable String team_name){
        return teamService.findByName(team_name);
    }

}
