package entities;

import javax.persistence.*;

@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Column
    private String comment;

    public Post getPost() {
        return post;
    }
}
