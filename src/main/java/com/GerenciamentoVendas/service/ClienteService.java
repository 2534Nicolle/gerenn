package com.GerenciamentoVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciamentoVendas.entity.Cliente;
import com.GerenciamentoVendas.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElse(null);
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Long id, Cliente updatedCliente) {
		Optional<Cliente> existingCliente = clienteRepository.findById(id);
		if (existingCliente.isPresent()) {
			updatedCliente.setId(id);
			return clienteRepository.save(updatedCliente);
		}
		return null;
	}

	public boolean deleteCliente(Long id) {
		Optional<Cliente> existingCliente = clienteRepository.findById(id);
		if (existingCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
