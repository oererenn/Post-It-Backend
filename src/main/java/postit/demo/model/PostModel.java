package postit.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

@Entity
public class PostModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @NotBlank(message = "Post title is required")
    @Column(columnDefinition="clob")
    private String title;
    @Lob
    @NotBlank(message = "Post description is required")
    @Column(columnDefinition="clob")
    private String description;
    private Instant createdAt;
    private String image;
    private Integer voteCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserModel user;

    @ManyToOne(cascade = CascadeType.ALL)
    private CommunityModel community;

    public PostModel() {
        this.voteCount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Optional<String> getImage() {
        return Optional.ofNullable(image);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public CommunityModel getCommunity() {
        return community;
    }

    public void setCommunity(CommunityModel community) {
        this.community = community;
    }
}
