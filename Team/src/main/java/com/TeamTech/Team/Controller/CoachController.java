package com.TeamTech.Team.Controller;

import com.TeamTech.Team.Model.Coach;
import com.TeamTech.Team.Model.Team;
import com.TeamTech.Team.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/coaches")
public class CoachController {
    @Autowired
    CoachService coachService;

    @PostMapping("/createteam")
    public Team createTeam(Coach coach , String name, String pass){
        return coachService.createTeam(coach ,name, pass);
    }

    @PostMapping("/coachJoinTeam")
    public List<Team> joinTeam(Team team , Coach coach){
        return coachService.joinTeam(team, coach);
    }

    @PutMapping("/coachLeaveTeam")
    public List<Team> leaveTeam(Team team ,Coach coach){
        return coachService.leaveTeam(team, coach );

    }






}
