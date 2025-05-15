package com.GerenciamentoVendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciamentoVendas.entity.Venda;
import com.GerenciamentoVendas.service.VendaService;

import jakarta.validation.Valid;

@Tag(name = "Gerenciamento de vendas", description = "API REST - GERENCIAMENTO DE VENDAS")
@RestController
@RequestMapping("/venda")
public class VendaController {

	private final VendaService vendaService;

	@Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}

	@Operation(summary = "Buscar lista de vendas por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
		Venda venda = vendaService.getVendaById(id);
		return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
	}

	@Operation(summary = "Buscar lista de vendas por ID")
	@GetMapping
	public ResponseEntity<List<Venda>> getAllVenda() {
		List<Venda> venda = vendaService.getAllVenda();
		return ResponseEntity.ok(venda);
	}

	@Operation(summary = "Adiconar lista de vendas por ID")
	@PostMapping
	public ResponseEntity<Venda> criarVenda(@RequestBody @Valid Venda venda) {
		Venda criada = vendaService.salvarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(criada);
	}

	@Operation(summary = "Atualizar lista de vendas por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Venda> updateVenda(@PathVariable Long id, @RequestBody @Valid Venda venda) {
		Venda atualizada = vendaService.updateVenda(id, venda);
		return atualizada != null ? ResponseEntity.ok(atualizada) : ResponseEntity.notFound().build();
	}

	@Operation(summary = "Deletar lista de vendas por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
		boolean deleted = vendaService.deleteVenda(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
