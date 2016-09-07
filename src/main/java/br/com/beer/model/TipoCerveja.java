package br.com.beer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by felipe.tavares on 23/08/16.
 */

@Entity
@Table(name = "tb_tipo_cerveja", schema = "beer")
@AttributeOverride(name = "id", column = @Column(name = "id_tp_cerveja"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "beer.tp_cerveja_id_seq", allocationSize = 1)
public class TipoCerveja extends AbstractModel<Long> implements Serializable {


    @NotNull
    @Column(name = "tp_cerveja_nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
