package io.github.tifannyknox.apiresttest.controller;

import io.github.tifannyknox.apiresttest.model.Pessoa;
import io.github.tifannyknox.apiresttest.repository.PessoaRepository;
import io.github.tifannyknox.apiresttest.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pessoa")
@AllArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> fetchAll() {
        return pessoaService.getAllPerson();
    }
}
