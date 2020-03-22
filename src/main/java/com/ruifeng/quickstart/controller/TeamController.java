package com.ruifeng.quickstart.controller;

import com.ruifeng.quickstart.entity.Team;
import com.ruifeng.quickstart.service.feignService.TeamFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamFeignService teamFeignService;

    public TeamController(TeamFeignService teamFeignService) {
        this.teamFeignService = teamFeignService;
    }

    @GetMapping
    public ResponseEntity getTeams(){
        List<Team> teams = teamFeignService.findAllTeams();
        return ResponseEntity.ok().body(teams);
    }
}
