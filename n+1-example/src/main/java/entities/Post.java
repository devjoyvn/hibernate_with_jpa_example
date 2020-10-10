package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new HashSet<>();

    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
