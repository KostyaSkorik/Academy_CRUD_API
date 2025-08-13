package by.kostya.academy_crud_api.database.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;


    @ManyToMany(mappedBy = "students")
    @BatchSize(size = 5)
//    @Fetch(FetchMode.SUBSELECT)
    private List<Course> courses;
}
