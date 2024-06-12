package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

    List<Destino> findByNomeContaining(String nome);

    @Query("select c from Destino c where c.nome like %?1%")
    List<Destino> findByNomeLike(String nome);
}