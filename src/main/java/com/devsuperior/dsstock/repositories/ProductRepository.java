package com.devsuperior.dsstock.repositories;

import com.devsuperior.dsstock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// Repository (repositores) é uma classe responsável por acessar os dados,
// É um padrão para acessarmos os dados do banco de dados

// Como a classe entidade que criamos foi a classe Produto - logo vamos criar um componente,
// Uma classe chamada ProductReposity para acessar os dados dos produtos que estão na tabela Product
// Que criamos no banco de dados com a classe Produto

// Se a outra entidade fosse a classe Cliente - logo iriamos criar um componente, uma classe ClientReposity
// Para acessar os dados que estão na tabela Cliente no banco de dados que criamos com a classe Cliente


// Então: O Repository é basicamente a ponte entre a API Java que você ta criando e o banco de dados.
// Ele encapsula todas as operações de acesso aos dados, seguindo o padrão Repository Pattern,
// Sem que você precise escrever SQL na maioria dos casos


// Então o Repository é uma interface que guarda:

// No Spring Data JPA, um Repository normalmente é uma interface,
// Não uma classe concreta.
// Ele define os métodos para acessar e manipular os dados de uma entidade específica (nessa entidade Produto),
// E os métodos são os métodos de manipulação de dados como: (insert/update), delete, findById, findAll


// E essa interface que criamos, que é uma Repository vai extender uma interface do spring data jpa
// Que é: JpaRepository<Product, UUID>

// E para essa interface do Spring Data JPA vamos informar qual a entidade (classe/tabela) que queremos
// Pegar os dados e qual o Id dessa classe, dessa tabela

// Nesse caso é a entidade (classe) Product - que gerou a tabela tb_product
// E seu Id é UUID
public interface ProductRepository extends JpaRepository<Product, UUID> {
}

