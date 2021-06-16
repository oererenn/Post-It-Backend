package postit.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class TopicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Topic name required")
    private String name;

    public TopicModel() {
        //Empty Constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
