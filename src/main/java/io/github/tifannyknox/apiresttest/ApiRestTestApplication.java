package io.github.tifannyknox.apiresttest;

import io.github.tifannyknox.apiresttest.model.*;
import io.github.tifannyknox.apiresttest.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ApiRestTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestTestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PessoaRepository repository, MongoTemplate mongoTemplate) {

        return args -> {
            String telefone = "5561983192842";
            Pessoa pessoa = new Pessoa(
                    LocalDateTime.now(),
                    "Danubia",
                    telefone,
                    27,
                    "Brasilia",
                    Estados.SP,
                    "sudeste"
            );

            repository.findByTelefone(telefone).ifPresentOrElse(t -> {
                System.out.println("Telefone" + t + "já existe");
            }, () -> {
                System.out.println("Inserindo" + pessoa);
                repository.insert(pessoa);

            });
        };
    }

    private void usingMongoTemplateAndQuery(PessoaRepository repository, MongoTemplate mongoTemplate, String telefone, Pessoa pessoa) {
        Query query = new Query();
        query.addCriteria(Criteria.where("telefone").is(telefone));
        List<Pessoa> pessoas = mongoTemplate.find(query, Pessoa.class);
        if (pessoas.size() > 1) {
            throw new IllegalStateException("O número" + telefone + "já está cadastrado");
        }
        if (pessoas.isEmpty()) {
            System.out.println("Inserindo" + pessoa);
            repository.insert(pessoa);
        } else {
            System.out.println(pessoa + "Ja existe");
        }
    }
}
