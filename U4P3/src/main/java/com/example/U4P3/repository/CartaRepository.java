package com.example.U4P3.repository;

import com.example.U4P3.model.CartaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaRepository extends JpaRepository<CartaModel, Long> {

}
