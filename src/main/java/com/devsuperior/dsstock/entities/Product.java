package com.devsuperior.dsstock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

// Aqui criamos uma classe (a classe Produto)
// E ela representa os objetos em memória

// Agora para pegarmos um objeto em memória (um objeto do java) ele tenha uma equivalencia a uma tabela
// Do banco de dados
// Ou seja, um objeto aqui no java vire uma tabela no banco de dados

// Então para fazer isso, precisamos fazer um mapeamento-objeto-relacional
// E fazemos isso utilizando a especificação do Java JPA

// E isso no JAVA JPA é feito atraves de anotações - onde marcamos as classes e propriedades
// Com anotações indicando ao Java e ao JPA quais classes e quais propriedades devem virar tabelas no banco

// Mapeamento objeto-relacional (ORM)

// O objetivo do ORM é transformar classes Java em tabelas no banco e objetos java (dados) em linhas no BD.
// Ou seja, você programa em Java usando classes e objetos,

// E o JPA (junto com o Hibernate, que é o provedor padrão)
// faz o trabalho de transformar essas classes em tabelas e os objetos em linhas nessas tabelas



// E para informar ao JPA quais classes vão ser tabelas usamos a anotação @Entity
// E automaticamente as propriedades da classe são transformadas em colunas nas tabelas

// E você pode customizar como cada coluna vai se comportar usando anotações como:

// @Id                          → indica a chave primária
// @Column(name="nome_coluna")  → renomeia a coluna ou define propriedades (tamanho, nullable, etc.)
// @GeneratedValue              → indica que o valor da chave primária é gerado automaticamente


// Marcando essa classe para ser a tabela product no nosso banco
// E podemos customizar o nome dessa tabela Product para um nome que queremos usando @Table("nome")

// E vamos marcar a propriedade id dessa nossa classe com a anotacao @Id para informar ao JPA
// Que essa propriedade é o nosso id do banco de dados, a nossa chave primaria

@Entity
@Table(name = "tb_product")
public class Product {

    // Propriedades de Produto
    @Id
    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;


    // Métodos de Produto
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
