package com.weg.atividade2.mapper;

import com.weg.atividade2.dto.PedidoRequisicaoDto;
import com.weg.atividade2.dto.PedidoRespostaDto;
import com.weg.atividade2.model.Cliente;
import com.weg.atividade2.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(PedidoRequisicaoDto dto, Cliente cliente) {
        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.descricao());
        pedido.setCliente(cliente); // já validado no service
        return pedido;
    }

    public PedidoRespostaDto toDto(Pedido pedido) {
        PedidoRespostaDto pedidoRespostaDto = new PedidoRespostaDto(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getCliente().getId(),
                pedido.getCliente().getNome()
        );
        return pedidoRespostaDto;
    }
}