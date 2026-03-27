package com.weg.atividade2.service;

import com.weg.atividade2.dto.ClienteRequisicaoDto;
import com.weg.atividade2.dto.ClienteRespostaDto;
import com.weg.atividade2.mapper.ClienteMapper;
import com.weg.atividade2.model.Cliente;
import com.weg.atividade2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository,
                          ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteRespostaDto salvar(ClienteRequisicaoDto dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    public List<ClienteRespostaDto> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public ClienteRespostaDto buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return clienteMapper.toDto(cliente);
    }

    public List<ClienteRespostaDto> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome)
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}