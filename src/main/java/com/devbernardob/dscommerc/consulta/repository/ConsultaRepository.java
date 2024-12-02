package com.devbernardob.dscommerc.consulta.repository;

import com.devbernardob.dscommerc.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
