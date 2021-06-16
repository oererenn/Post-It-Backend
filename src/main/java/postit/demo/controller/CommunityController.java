package postit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import postit.demo.converter.CommunityConverter;
import postit.demo.dto.CommunityDto;
import postit.demo.model.CommunityModel;
import postit.demo.service.CommunityService;

import java.util.List;
import java.util.Optional;

@RestController
public class CommunityController {

    private CommunityService communityService;

    private CommunityConverter communityConverter;

    @Autowired
    public CommunityController(CommunityService communityService, CommunityConverter communityConverter) {
        this.communityService = communityService;
        this.communityConverter = communityConverter;
    }


    @GetMapping(value = "/api/communities")
    public List<CommunityModel> getCommunities(){

        return communityService.getCommunities();
    }

    @GetMapping(value = "/api/communities/{id}")
    public Optional<CommunityModel> getCommunity(@PathVariable Long id){
        return communityService.getCommunity(id);
    }

    @PostMapping( value = "/api/communities")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addCommunity(@RequestBody CommunityDto communityDto){
        communityService.addCommunity(communityConverter.dtoToEntity(communityDto));
    }

    @PutMapping( value = "/api/communities/{id}")
    public void updateCommunity(@RequestBody CommunityDto communityDto,@PathVariable Long id){
        communityService.updateCommunity(communityConverter.dtoToEntityUpdate(communityDto,id));
    }

    @DeleteMapping( value = "/api/communities/{id}")
    public void deleteCommunity(@PathVariable Long id){
        communityService.deleteCommunity(id);
    }

}
