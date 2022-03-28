package io.github.tifannyknox.apiresttest.repository;

import io.github.tifannyknox.apiresttest.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
//    Optional<Pessoa> findByPhone(String telefone);
    Optional<Pessoa> findByTelefone(String telefone);

}
