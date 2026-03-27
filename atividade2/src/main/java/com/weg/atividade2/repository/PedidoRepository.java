package com.weg.atividade2.repository;

import com.weg.atividade2.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByClienteNome(String nome);

    Optional<Pedido> findByIdAndDescricao(Long id, String descricao);

    List<Pedido> findByClienteIdOrderByIdAsc(Long clienteId);
}