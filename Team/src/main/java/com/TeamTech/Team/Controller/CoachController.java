package com.TeamTech.Team.Controller;

import com.TeamTech.Team.Model.Coach;
import com.TeamTech.Team.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping("/{coach_id}/teams/{team_id}/join")
    public Coach joinTeam(
            @PathVariable Long coach_id,
            @PathVariable Long team_id
    ) {
        return coachService.joinTeam(coach_id, team_id);
    }

    @PutMapping("/{coach_id}/team/{team_id}")
    public Coach leaveTeam(
            @PathVariable Long coach_id,
            @PathVariable Long team_id
    ) {
        return coachService.leaveTeam(coach_id, team_id);
    }


}




