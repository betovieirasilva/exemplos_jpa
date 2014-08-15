package br.exemplo.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
//@Table(name = "pessoa",schema = "xxxxx")
@Table(name = "pessoa")
@NamedQueries(@NamedQuery(name = "Pessoa.all",query = "SELECT p FROM Pessoa p"))
public class Pessoa implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + '}';
    }
}
