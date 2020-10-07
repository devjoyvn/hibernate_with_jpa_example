package entities;

import javax.persistence.*;


@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}