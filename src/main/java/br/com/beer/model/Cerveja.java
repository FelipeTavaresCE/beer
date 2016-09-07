package br.com.beer.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by felipe.tavares on 23/08/16.
 */

@Entity
@Table(name = "tb_cerveja", schema = "beer")
@AttributeOverride(name = "id", column = @Column(name = "id_cerveja"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "beer.cerveja_id_seq", allocationSize = 1)
public class Cerveja extends AbstractModel<Long> implements Serializable {


    @NotNull
    @Column(name = "cerv_nome")
    private String nome;

    @Lob
    @Column(name = "cerv_img")
    private byte[] photo;

    @NotNull
    @Column(name = "cerv_valor")

    private BigDecimal valor;

    @JsonIgnore
    @ManyToMany
    private List<Bar> bares;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoCerveja")
    private List<TipoCerveja> tipoCerveja;

    @JsonIgnore
    @OneToMany(mappedBy = "tamanhoCerveja")
    private List<TipoCerveja> tamanhoCerveja;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<TipoCerveja> getTipoCerveja() {
        return tipoCerveja;
    }

    public void setTipoCerveja(List<TipoCerveja> tipoCerveja) {
        this.tipoCerveja = tipoCerveja;
    }

    public List<TipoCerveja> getTamanhoCerveja() {
        return tamanhoCerveja;
    }

    public void setTamanhoCerveja(List<TipoCerveja> tamanhoCerveja) {
        this.tamanhoCerveja = tamanhoCerveja;
    }



}
