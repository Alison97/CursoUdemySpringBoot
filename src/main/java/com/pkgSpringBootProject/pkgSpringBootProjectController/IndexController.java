package com.pkgSpringBootProject.pkgSpringBootProjectController;


import com.pkgSpringBootProject.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private  String textoIndex;

    @Value("${texto.indexcontroller.poblarUsuario.titulo}")
    private  String textoPoblarUsuario;

    @Value("${texto.indexcontroller.listar.titulo}")
    private  String textoListar;

    @GetMapping({"/index", "/", "", "/home"})
    //method
    public String index(Model model) {
        model.addAttribute("Titulo", textoIndex);

        return ("index");
    }

    @RequestMapping("/perfil") //si por defecto no se indica el metodo, por defecto es get
    public String perfil(Model model) {

        model.addAttribute("userProfile", "User Profile "); //nombramiento navegador

        return "perfil";
    }

    @ModelAttribute("usuario")
    public User poblarUsuario (Model model) {
        User usuario = new User();
        usuario.setNombre("Alison");
        usuario.setApellido("Duque");
        usuario.setEmail("nopi@hotmail.com");

        model.addAttribute("usuario", usuario); //expone mi objeto User creado
        model.addAttribute("Titulo", textoPoblarUsuario.concat(usuario.getNombre()).concat(usuario.getApellido()));
        return usuario;
    }

    @RequestMapping("/listar") //si por defecto no se indica el metodo, por defecto es get
    public String listar(Model model) {
        model.addAttribute("Titulo", textoListar);
        return "listar";
    }

    @ModelAttribute("usuarios") //usuarios es el nombre que recibe en el template listar para mostrar en pantalla al llamar el return listar anterior se ejecuta todo
    public List<User> poblarUsuarios (){
        List<User> usuarios = Arrays.asList(new User("Alison","Duque", "nopi@hotmail.com"),
                new User("Sebastian","Narvaez", "nopi2@hotmail.com"));

        return usuarios;
    }
}
