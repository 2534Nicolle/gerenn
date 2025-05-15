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

import com.GerenciamentoVendas.entity.Cliente;
import com.GerenciamentoVendas.service.ClienteService;

import jakarta.validation.Valid;

@Tag(name = "erenciamento de Cliente", description = "API REST - GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@Operation(summary = "Buscar cliente por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteService.getClienteById(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Buscar cliente por ID")
	@GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente() {
        List<Cliente> cliente = clienteService.getAllClientes();
        return ResponseEntity.ok(cliente);
    }

	@Operation(summary = "Adicionar cliente por ID")
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid Cliente cliente) {
    	Cliente criada = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

	@Operation(summary = "Atualizar cliente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
    	Cliente atualizada = clienteService.updateCliente(id, cliente);
        return atualizada != null ? ResponseEntity.ok(atualizada) : ResponseEntity.notFound().build();
    }

	@Operation(summary = "Deletar cliente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        boolean deleted = clienteService.deleteCliente(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}