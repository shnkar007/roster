package com.altiusdigital.roster.roster.repository;

import com.altiusdigital.roster.roster.entity.Roster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@EnableJpaRepositories
public interface IRosterRepo extends JpaRepository<Roster,Integer> {
    public Roster save(Roster roster);
    @Query(value="select r from Roster as r where r.firstName=:firstName and r.date=:date")
    public Roster fetchRosterByFirstNameAndDate(@Param("firstName") String firstName, @Param("date") String date);
}