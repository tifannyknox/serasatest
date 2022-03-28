package io.github.tifannyknox.apiresttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
    private String descricao;
    private int inicial;
    private int termino;
}
