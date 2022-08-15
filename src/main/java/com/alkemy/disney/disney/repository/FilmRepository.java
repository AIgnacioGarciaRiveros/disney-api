package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity,Long> {
}
