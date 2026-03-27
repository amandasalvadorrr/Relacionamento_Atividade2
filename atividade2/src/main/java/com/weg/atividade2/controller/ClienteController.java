package com.weg.atividade2.controller;

import com.weg.atividade2.dto.ClienteRequisicaoDto;
import com.weg.atividade2.dto.ClienteRespostaDto;
import com.weg.atividade2.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteRespostaDto salvar(@RequestBody ClienteRequisicaoDto dto) {
        return clienteService.salvar(dto);
    }

    @GetMapping
    public List<ClienteRespostaDto> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteRespostaDto buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/nome")
    public List<ClienteRespostaDto> buscarPorNome(@RequestParam String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}
