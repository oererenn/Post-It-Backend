package postit.demo.dto;


public class UserCommunityDto {
    private Long communityId;
    private Long userId;

    public UserCommunityDto() {
        //Empty constructor
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
