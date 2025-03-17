package com.TeamTech.Team.Repo;

import com.TeamTech.Team.Model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepo extends JpaRepository<Athlete,Long> {
    List<Athlete> findByName(String name);

    // Find all athletes in a specific team
    @Query("SELECT a FROM Athlete a JOIN a.teams t WHERE t.id = :teamId")
    List<Athlete> findAthletesByTeamId(@Param("teamId") Long teamId);
}
