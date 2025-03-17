package com.TeamTech.Team.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String password;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToMany
    @JoinTable(
            name = "team_athletes",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private List<Athlete> athletes;
    @ManyToMany
    @JoinTable(
            name = "team_coaches",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "coaches_id")
    )
    private List<Coach> assistantCoaches;

    public Team(Coach coach , String name, String password){
        this.coach = coach;
        this.name = name;
        this.password = password;

    }


    public Team(Coach coach) {
        this.coach = coach ;
    }
}
