package com.crud.sbcrud.controller;

import com.crud.sbcrud.model.Manifestado;
import com.crud.sbcrud.model.Tag;
import com.crud.sbcrud.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TagController {

    //#region ..:: Variáveis ::..
    @Autowired
    private TagService service;

    //#endregion ..:: Variáveis ::..

    //#region ..:: Consultas ::..

    @ResponseBody
    @RequestMapping(value = "/consultar_tag_json", method=RequestMethod.GET)
    public List<Tag> consultarManifestadoJson(Model model) {
        List<Tag> tag = service.listarTag();
        model.addAttribute("tag", tag);

        return tag;
    }

    @GetMapping("/consultar_tags")
    public String consultarTag(Model model) {
        List<Tag> tag = service.listarTag();
        model.addAttribute("tag", tag);

        return "consultar_tags";
    }

    //#endregion ..:: Consultas ::..

    //#region ..:: Cadastros ::..

    @GetMapping("/cadastrar_tags")
    public String cadastrarTag() {
        return "cadastrar_tags";
    }

    @PostMapping("/cadastrar_tags")
    public String gravarTag(@ModelAttribute Tag tag, HttpSession session) {
        service.gravarTag(tag);
        session.setAttribute("msg", "Tag inserida com sucesso!");
        return "redirect:/consultar_tags";
    }
    //#endregion ..:: Cadastros ::..

    //#region ..:: Atualizações ::..

    @GetMapping("/alterar_tag/{id}")
    public String alterarTag(@PathVariable int id, Model model) {
        Tag tag = service.obterTagPorId(id);
        model.addAttribute("tag", tag);

        return "alterar_tag";
    }

    @PostMapping("/atualizar_tag")
    public String atualizarTag(@ModelAttribute Tag tag, HttpSession session) {
        service.gravarTag(tag);
        session.setAttribute("msg", "Tag atualizada com sucesso!");

        return "redirect:/consultar_tags";
    }

    //#endregion ..:: Atualizações ::..

    //#region ..:: Remoção ::..

    @GetMapping("/remover_tag/{id}")
    public String removerTag(@PathVariable int id, HttpSession session) {
        service.removerTagPorId(id);
        session.setAttribute("msg", "Tag removida com sucesso!");

        return "redirect:/consultar_tags";
    }

    //#endregion ..:: Remoção ::..
}
