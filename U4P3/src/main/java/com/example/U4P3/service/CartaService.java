
package com.example.U4P3.service;

import com.example.U4P3.model.CartaModel;
import com.example.U4P3.repository.CartaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    // Repositorio encargado de realizar las operaciones sobre la base de datos.
    private final CartaRepository repository;

    // Inyección de dependencias mediante el constructor.
    public CartaService(CartaRepository repository) {
        this.repository = repository;
    }

    // Guarda una carta en la base de datos y devuelve la entidad guardada.
    public <S extends CartaModel> S save(S carta) {
        return repository.save(carta);
    }

    // Recupera todas las cartas almacenadas en la base de datos.
    public List<CartaModel> findAll() {
        return repository.findAll();
    }
}

