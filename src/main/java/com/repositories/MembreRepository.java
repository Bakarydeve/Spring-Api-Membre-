package com.repositories;

import com.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {
    @Query("SELECT COUNT(m) > 0 FROM Membre m WHERE m.nom = :nom AND m.prenom = :prenom")
    boolean CheckName(@Param("nom") String nom, @Param("prenom") String prenom);
}
