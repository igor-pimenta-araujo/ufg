package com.persistencia.jpeigor.repositories;

import com.persistencia.jpeigor.models.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
}
