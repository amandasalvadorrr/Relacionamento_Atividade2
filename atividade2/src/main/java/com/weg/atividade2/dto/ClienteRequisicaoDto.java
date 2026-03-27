package com.weg.atividade2.dto;

import java.util.List;

public record ClienteRequisicaoDto(
        String nome,
        List<Long> pedidosIds
){
}