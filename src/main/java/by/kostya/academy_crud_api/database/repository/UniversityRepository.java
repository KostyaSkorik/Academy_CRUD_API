package by.kostya.academy_crud_api.database.repository;

import by.kostya.academy_crud_api.database.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
