package com.GerenciamentoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GerenciamentoVendas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
