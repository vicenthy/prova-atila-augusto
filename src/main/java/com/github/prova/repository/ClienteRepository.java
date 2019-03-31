package com.github.prova.repository;

import com.github.prova.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {


    public List<Cliente> findByNomeContaining(String nome);
    public List<Cliente> findByCpfEquals(String cpf);
}
