package com.TeamTech.Team.Repo;

import com.TeamTech.Team.Model.Athlete;
import com.TeamTech.Team.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Long> {
    // Find coach by last name


    // Find all athletes coached by a specific coach


}
