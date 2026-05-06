package com.vollmed.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vollmed.produtos.model.Produto;
import com.vollmed.produtos.model.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    //EXIBINDO OS PRODUTOS
    //Get -> Todos os produtos que estão cadastrados, exibindo ID, nome e preço
    //Quando ocorrer um get para ProdutoController, preciso retornar a listar.html
    @GetMapping("/") //vai sobrescrever a página inicial
    public String listarProdutos(Model model){
        model.addAttribute("todosOsProdutos", repository.findAll());
        return "listar"; //é o listar.html
    }

    // CADASTRANDO O PRODUTO
    //Get -> Preciso retornar a cadastrar.html
    @GetMapping("/cadastro") //Mostrar o formulário
    public String mostrarFormulario(Model model){
        model.addAttribute("produto", new Produto()); // addAtribute("nome do model", construtor do model)
        return "cadastrar"; // é o cadastrar.html
    }

    //Post -> Cadastrar um produto com seus atributos, nome, preço. Irá ocorrer quando eu clicar no botão do formulário da página cadastrar.html
    @PostMapping("/cadastro") //acontece quando o botão for clicado
    public String cadastrarProdutos(Produto produto){
        repository.save(produto);
        return "/";
    }

}

//Model -> é uma classe/interface (Model.java, ou seja, não é o pacote) que faz parte do Spring MVC que é usada para passar dados entre o controlador e a view(templates). 
// Ele atua como um container para os dados que serão exibidos ao usuário final. 
