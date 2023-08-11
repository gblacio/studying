package com.example.studying.Repositories;

import com.example.studying.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAO extends JpaRepository<Cliente,Long> {

}
