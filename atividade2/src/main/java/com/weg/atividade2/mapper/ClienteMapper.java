package com.weg.atividade2.mapper;

import com.weg.atividade2.dto.ClienteRequisicaoDto;
import com.weg.atividade2.dto.ClienteRespostaDto;
import com.weg.atividade2.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequisicaoDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        return cliente;
    }

    public ClienteRespostaDto toDto(Cliente cliente) {
        return new ClienteRespostaDto(
                cliente.getId(),
                cliente.getNome()
        );
    }
}