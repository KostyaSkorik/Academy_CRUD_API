package by.kostya.academy_crud_api.database.repository;

import by.kostya.academy_crud_api.database.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface UniversityRepository extends JpaRepository<University,Long>,
        PagingAndSortingRepository <University,Long>{

    Optional<University> findUniversityByName(String name);

}

