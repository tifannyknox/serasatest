package io.github.tifannyknox.apiresttest.service;
import io.github.tifannyknox.apiresttest.model.Pessoa;
import io.github.tifannyknox.apiresttest.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public List<Pessoa> getAllPerson() {
        return pessoaRepository.findAll();
    }
}
