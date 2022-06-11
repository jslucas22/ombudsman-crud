package com.crud.sbcrud.controller;

import com.crud.sbcrud.model.Manifestante;
import com.crud.sbcrud.service.ManifestanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManifestanteController {

    //#region ..:: Variáveis ::..
    @Autowired
    private ManifestanteService service;

    //#endregion ..:: Variáveis ::..

    //#region ..:: Consultas ::..
    @GetMapping("/consultar_manifestante")
    public String consultarManifestante(Model model) {
        List<Manifestante> manifestante = service.listarManifestantes();
        model.addAttribute("manifestante", manifestante);

        return "consultar_manifestante";
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestante_json", method = RequestMethod.GET)
    public List<Manifestante> consultarManifestanteJson(Model model) {
        List<Manifestante> manifestante = service.listarManifestantes();
        model.addAttribute("manifestante", manifestante);

        return manifestante;
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestantes_total_json", method = RequestMethod.GET)
    public long consultarQuantidadeManifestadosJson(Model model) {
        long totalManifestantes = service.obterQuantidadeManifestantes();
        model.addAttribute("totalManifestantes", totalManifestantes);

        return totalManifestantes;
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestante_by_id_json/{id}", method = RequestMethod.GET)
    public Manifestante consultarManifestanteByIdJson(Model model, @PathVariable int id) {
        Manifestante manifestante = service.obterManifestantePorId(id);
        model.addAttribute("manifestante", manifestante);

        return manifestante;
    }

    //#endregion ..:: Consultas ::..

    //#region ..:: Cadastros ::..

    @GetMapping("/cadastrar_manifestante")
    public String cadastrarManifestante() {
        return "cadastrar_manifestante";
    }

    @PostMapping("/cadastrar_manifestante")
    public String gravarManifestante(@ModelAttribute Manifestante manifestante, HttpSession session) {
        service.gravarManifestante(manifestante);
        session.setAttribute("msg", "Manifestante inserido com sucesso!");
        return "redirect:/consultar_manifestante";
    }

    //#endregion ..:: Cadastros ::..

    //#region ..:: Atualizações ::..

    @GetMapping("/alterar_manifestante/{id}")
    public String alterarManifestante(@PathVariable int id, Model model) {
        Manifestante manifestante = service.obterManifestantePorId(id);
        model.addAttribute("manifestante", manifestante);

        return "alterar_manifestante";
    }

    @PostMapping("/atualizar_manifestante")
    public String atualizarManifestante(@ModelAttribute Manifestante manifestante, HttpSession session) {
        service.gravarManifestante(manifestante);
        session.setAttribute("msg", "Manifestante atualizado com sucesso!");

        return "redirect:/consultar_manifestante";
    }

    //#endregion ..:: Atualizações ::..

    //#region ..:: Remoção ::..

    @GetMapping("/remover_manifestante/{id}")
    public String removerManifestante(@PathVariable int id, HttpSession session) {
        service.removerManifestantePorId(id);
        session.setAttribute("msg", "Manifestante removido com sucesso!");

        return "redirect:/consultar_manifestante";
    }

    //#endregion ..:: Remoção ::..
}
