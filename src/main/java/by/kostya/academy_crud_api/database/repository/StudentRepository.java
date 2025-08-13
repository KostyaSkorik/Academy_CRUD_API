package by.kostya.academy_crud_api.database.repository;

import by.kostya.academy_crud_api.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends JpaRepository<Student,Long>,
        PagingAndSortingRepository<Student,Long> {
}
