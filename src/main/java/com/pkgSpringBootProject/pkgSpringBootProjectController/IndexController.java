package com.pkgSpringBootProject.pkgSpringBootProjectController;


import com.pkgSpringBootProject.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "", "/home"})
    //method
    public String index(Model model) {
        model.addAttribute("Titulo", "Hellouuu Spring practician");

        return ("index");
    }

    @RequestMapping("/perfil") //si por defecto no se indica el metodo, por defecto es get
    public String perfil(Model model) {
        User usuario = new User();
        usuario.setNombre("Alison");
        usuario.setApellido("Duque");
        usuario.setEmail("nopi@hotmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("userProfile", "User Profile ");
        model.addAttribute("Titulo", "Datos del usuario: ".concat(usuario.getNombre()).concat(usuario.getApellido()));
        return "perfil";
    }

    @RequestMapping("/listar") //si por defecto no se indica el metodo, por defecto es get
    public String listar(Model model) {
        List<User> usuarios = Arrays.asList(new User("Alison","Duque", "nopi@hotmail.com"),
                new User("Sebastian","Narvaez", "nopi2@hotmail.com"));
        model.addAttribute("Titulo", "Listado de usuarios");
        model.addAttribute("usuarios",usuarios);
        return "listar";
    }
}
