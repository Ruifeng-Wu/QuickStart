package com.ruifeng.subproject.service;

import com.ruifeng.subproject.entity.Team;
import com.ruifeng.subproject.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }
}
