package com.TeamTech.Team.Repo;

import com.TeamTech.Team.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {

    // Find teams by name
    List<Team> findByName(String teamName);

    // Find all teams an athlete is part of
    @Query("SELECT t FROM Team t JOIN t.athletes a WHERE a.id = :athleteId")
    List<Team> findTeamsByAthleteId(@Param("athleteId") Long athleteId);

}
