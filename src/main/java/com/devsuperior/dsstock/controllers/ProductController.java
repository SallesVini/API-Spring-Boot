package com.devsuperior.dsstock.controllers;

import com.devsuperior.dsstock.entities.Product;
import com.devsuperior.dsstock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// E agora precisamos criar um componente, uma classe que vai disponibilizar um caminho na web (um endpoint),
// Disponibilizar uma url.

// Para o usuário poder acessar na web, na url os produtos que minha API esta pegando do banco de dados
// Da tabela produto com o Repository ProductRepository

// Da mesma forma que usamos os repositories para guardar o componente que acessa o banco de dados

// Aqui criamos o Controller para especificar o local onde guardamos os componentes,
// Classes que disponibilizam os recursos disponibilizam os caminhos para o usuário
// Acessar os dados que a API pega do banco de dados e retorna (exibe)

// E como vamos criar um componente, uma classe que vai disponibilizar o caminho para o usuário acessar
// Os dados dos produtos então vamos chamar esse compiennte, essa classe de ProductController

// No Spring Boot, o Controller é a camada que expõe (exibe) os endpoints (caminhos) HTTP (URLs)
// Para o usuário ou para outros sistemas acessarem os dados que sua API pegou do banco de dados e exibiu.
// Ele vai usar os métodos do ProductRepository para acessar os dados da tabela Product


// Aqui estamos utilizando a anotação @RestController

// Para informar ao Java que essa classe é um componente, uma classe Controller que exibe o caminhos
// E os dados da API

// E estamos usando a anotação: @RequestMapping(value = "/products")
// É usada para mapear, para informar qual vai ser o caminho (a URL) que o usuário deve usar para acessar
// Os dados da entidade Product

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    // A anotação @Autowired do Spring é usada para injetar automaticamente uma instância de uma classe
    // No seu código, sem você precisar criar o objeto com new

    @Autowired
    private ProductRepository productRepository;


    // E aqui estamos criando um metodo chamado getProduct()
    // Retornando o tipo Page<Product> - é um tipo do framework spring
    // Esse tipo vai nos trazer uma lista paginada de objetos do tipo Product

    // E você coloca a anotação @GetMapping ali para mapear esse metodo a uma requisição HTTP GET

    // @GetMapping → indica que esse metodo responde a requisições GET em uma URL específica
    // No caso na URL '/products'

    // Entao temos:

    // @GetMapping → usado para buscar/ler dados (GET)
    // @PostMapping → usado para criar novos dados (POST)
    // @PutMapping → usado para atualizar dados existentes (PUT)
    // @DeleteMapping → usado para remover dados (DELETE)

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {

        // productRepository é a instância da sua interface ProductRepository, que você injetou com @Autowired

        // Nossa interface productRepository herda da interface JpaRepository<Product, UUID>
        // Logo nossa interface possui vários métodos prontos de acesso a dados

        // Que vem da interface JpaRepository<Product, UUID>

        // Aqui estamos acessando nossa interface productRepository
        // E usando o metodo findAll() que ela herda do JpaRepository
        // Para buscar todos os registros da tabela de produtos (tb_product) no banco

        return productRepository.findAll(pageable);
    }
}
