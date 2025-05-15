package com.GerenciamentoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GerenciamentoVendas.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
