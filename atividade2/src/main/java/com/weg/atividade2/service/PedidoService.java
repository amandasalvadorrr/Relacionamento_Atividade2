package com.weg.atividade2.service;

import com.weg.atividade2.dto.PedidoRequisicaoDto;
import com.weg.atividade2.dto.PedidoRespostaDto;
import com.weg.atividade2.mapper.PedidoMapper;
import com.weg.atividade2.model.Cliente;
import com.weg.atividade2.model.Pedido;
import com.weg.atividade2.repository.ClienteRepository;
import com.weg.atividade2.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoRespostaDto salvar(PedidoRequisicaoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(dto, cliente);
        pedido = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public PedidoRespostaDto buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> buscarPorClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public List<PedidoRespostaDto> buscarPorNomeCliente(String nome) {
        return pedidoRepository.findByClienteNome(nome)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public PedidoRespostaDto buscarPorIdEDescricao(Long id, String descricao) {
        Pedido pedido = pedidoRepository.findByIdAndDescricao(id, descricao)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> buscarPorClienteOrdenado(Long clienteId) {
        return pedidoRepository.findByClienteIdOrderByIdAsc(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
}