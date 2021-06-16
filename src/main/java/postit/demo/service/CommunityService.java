package postit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postit.demo.model.CommunityModel;
import postit.demo.repository.CommunityRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    private CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;

    }


    public List<CommunityModel> getCommunities()
    {
        List<CommunityModel> community = new ArrayList<>();
        communityRepository.findAll().forEach(community::add);
        return community;
    }

    public Optional<CommunityModel> getCommunity(Long id){

        return communityRepository.findById(id);
    }

    public void updateCommunity(CommunityModel community){
        communityRepository.save(community);
    }

    public void addCommunity(CommunityModel community){
        communityRepository.save(community);
    }


    public void deleteCommunity(Long id){
        communityRepository.deleteById(id);
    }
}
