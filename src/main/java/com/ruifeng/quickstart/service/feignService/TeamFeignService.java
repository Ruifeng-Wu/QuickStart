package com.ruifeng.quickstart.service.feignService;

import com.ruifeng.quickstart.entity.Team;
import com.ruifeng.quickstart.feign.TeamFeign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFeignService {

    private final TeamFeign teamFeign;

    public TeamFeignService(TeamFeign teamFeign) {
        this.teamFeign = teamFeign;
    }

    public List<Team> findAllTeams(){
        return teamFeign.findAllTeams();
    }
}
