package com.ruifeng.subproject.controller;

import com.ruifeng.subproject.entity.Team;
import com.ruifeng.subproject.service.TeamServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamServiceImpl teamService;

    public TeamController(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    public ResponseEntity getAllTeams() {
        List<Team> teams = teamService.findAllTeams();
        return ResponseEntity.ok().body(teams);
    }
}
