package br.com.beer.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by felipe.tavares on 23/08/16.
 */


@Entity
@Table(name = "tb_bar", schema = "beer")
@AttributeOverride(name = "id", column = @Column(name = "id_bar"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "beer.bar_id_seq", allocationSize = 1)
public class Bar extends AbstractModel<Long> implements Serializable {


    @NotNull
    @Column(name = "bar_nome")
    private String nome;

    @NotNull
    @Column(name = "bar_localizacao")
    private String endereco;

    @JsonIgnore
    @ManyToMany(mappedBy = "bares")
    private List<Cerveja> cervejas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Cerveja> getCervejas() {
        return cervejas;
    }

    public void setCervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
    }
}
