package br.com.beer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by felipe.tavares on 23/08/16.
 */

@Entity
@Table(name = "tb_tamanho_cerveja", schema = "beer")
@AttributeOverride(name = "id", column = @Column(name = "id_tam_cerveja"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "beer.tam_cerveja_id_seq", allocationSize = 1)
public class TamanhoCerveja extends AbstractModel<Long> implements Serializable {


    @NotNull
    @Column(name = "tam_cerveja_nome")
    private String nome;

    @Lob
    @Column(name = "tam_cerveja_qtd")
    private Double quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
