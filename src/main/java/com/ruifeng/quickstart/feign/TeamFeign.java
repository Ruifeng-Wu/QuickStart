package com.ruifeng.quickstart.feign;

import com.ruifeng.quickstart.entity.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "team-service", url = "${feign.team-service}", configuration = {KeepErrMsgConfiguration.class})
@Service
public interface TeamFeign {

    @GetMapping("/teams/")
    List<Team> findAllTeams();
}
