package com.TeamTech.Team.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Team {

    private int id;

    private String name;
    private String password;
    private Coach coach;


    private List<Athlete> athletes;
    private List<Coach> coaches;




}
