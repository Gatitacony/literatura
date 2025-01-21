package com.gatitacony.literatura;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByDeathDateIsNull();

    List<Author> findByDeathDateAfter(LocalDate year);
}

