package com.ifoodfunction.grouporder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifoodfunction.grouporder.domain.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {


}
