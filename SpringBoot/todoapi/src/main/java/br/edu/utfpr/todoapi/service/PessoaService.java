package br.edu.utfpr.todoapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.todoapi.dto.PessoaDTO;
import br.edu.utfpr.todoapi.model.Pessoa;
import br.edu.utfpr.todoapi.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    /**
     * Inserir uma pessoa no DB.
     * @return
     */
    public Pessoa create(PessoaDTO dto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);

        // Persistir no Banco de dados
        return pessoaRepository.save(pessoa);
    }
}
