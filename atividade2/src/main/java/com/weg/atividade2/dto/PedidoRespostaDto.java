package com.weg.atividade2.dto;

public record PedidoRespostaDto(
        Long id,
        String descricao,
        Long clienteId,
        String clienteNome
) {
}