package com.ende.ende.controller;

import com.ende.ende.model.Genero;
import com.ende.ende.model.PerfilUsuario;
import com.ende.ende.model.Usuario;
import com.ende.ende.repository.UsuarioRepository;
import com.ende.ende.repository.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final String CDT_USUARIOS = "cdtUsuario";
    private static final String VER_USUARIOS = "verUsuario";

    @Autowired
    private UsuarioRepository repository;


    @RequestMapping
    public ModelAndView usuarios() {
        ModelAndView mv = new ModelAndView(CDT_USUARIOS);
        mv.addObject(new Usuario());
        return mv;
    }

    @RequestMapping("/listar")
    public ModelAndView pesquisar(@ModelAttribute("filtro") Filter filtro) {
//        if(isAtendente().equals(true)){
//            return new ModelAndView("PesquisaPedidos");
//        }
        String descricao = filtro.getDescricao();
        if (descricao != null) {
            List<Usuario> todosUsuarios = repository.findByNomeContaining(descricao);
            ModelAndView mv = new ModelAndView(VER_USUARIOS);
            mv.addObject("usuarios", todosUsuarios);
            return mv;
        } else {
            List<Usuario> todosUsuarios = repository.findAll();
            ModelAndView mv = new ModelAndView(VER_USUARIOS);
            mv.addObject("usuarios", todosUsuarios);
            return mv;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String novo(Usuario user, RedirectAttributes attributes) {
        try {
            repository.save(user);
            attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
            return "redirect:/usuarios/cadastrar";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/usuarios";
        }
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Usuario user) {
        ModelAndView mv = new ModelAndView(CDT_USUARIOS);
        mv.addObject(user);
        return mv;
    }

    @ModelAttribute("todosGeneros")
    public List<Genero> todosGeneros() {
        return Arrays.asList(Genero.values());
    }

    @ModelAttribute("todosPerfis")
    public List<PerfilUsuario> todosPerfis() {
        return Arrays.asList(PerfilUsuario.values());
    }

    @RequestMapping(value = "/listar/{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
            repository.deleteById(codigo);
        attributes.addFlashAttribute("mensagem", "Usuário excluido com sucesso!");
        return "redirect:/usuarios";
    }

    @RequestMapping("/cadastrar")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CDT_USUARIOS);
        mv.addObject(new Usuario());
        return mv;
    }

}
