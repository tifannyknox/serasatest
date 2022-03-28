package io.github.tifannyknox.apiresttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Afinidade {
    private String regiao;
    private Estados estados;
}
