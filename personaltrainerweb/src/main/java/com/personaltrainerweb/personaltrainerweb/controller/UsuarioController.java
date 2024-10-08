package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personaltrainerweb.personaltrainerweb.model.UsuarioCadastro;
import com.personaltrainerweb.personaltrainerweb.service.UsuarioCadastroService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioCadastroService usuarioCadastroService; // Usar o serviço para lógica

    @GetMapping("/index")
    public String index() {
        return "index"; // O Spring Boot vai buscar o arquivo index.html em /src/main/resources/templates
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro"; // O Spring Boot vai buscar o arquivo result.html em /src/main/resources/templates
    }

    @GetMapping("/treino")
    public String treino() {
        return "treino"; // O Spring Boot vai buscar o arquivo result.html em /src/main/resources/templates
    }

    // Endpoint para cadastro de usuário
    @PostMapping("/api/usuarios/cadastrar")
    @ResponseBody
    public String cadastrarUsuario(@RequestBody UsuarioCadastro usuarioCadastro) {
        boolean sucesso = usuarioCadastroService.cadastrar(usuarioCadastro); // Chama o serviço
        if (sucesso) {
            return "Cadastro realizado com sucesso!";
        } else {
            return "Erro no cadastro: Usuário já existe!";
        }
    }

    // Endpoint para login de usuário
    @PostMapping("/api/usuarios/login")
    @ResponseBody
    public String loginUsuario(@RequestBody UsuarioCadastro usuarioCadastro) {
        boolean autenticado = usuarioCadastroService.autenticar(usuarioCadastro); // Chama o serviço
        if (autenticado) {
            return "Login realizado com sucesso!";
        } else {
            return "Usuário ou senha incorretos!";
        }
    }
}