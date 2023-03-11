package com.projetotareja1.projetotareja1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.projetotareja1.projetotareja1.entities.Clients;

@Repository
public interface ClientsRepository  extends JpaRepository<Clients, Long>  {

}
