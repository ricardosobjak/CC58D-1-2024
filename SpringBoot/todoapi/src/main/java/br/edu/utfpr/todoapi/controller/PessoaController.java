package br.edu.utfpr.todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.todoapi.dto.PessoaDTO;
import br.edu.utfpr.todoapi.model.Pessoa;
import br.edu.utfpr.todoapi.service.PessoaService;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PessoaDTO dto) {
        try {
            var res = pessoaService.create(dto);

            // Seta o status para 201 (CREATED) e devolve
            // o objeto Pessoa em JSON.
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch(Exception ex) {
            // Seta o status para 400 (Bad request) e devolve
            // a mensagem da exceção lançada.
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
}
