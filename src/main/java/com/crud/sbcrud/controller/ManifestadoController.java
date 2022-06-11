package com.crud.sbcrud.controller;

import com.crud.sbcrud.model.Manifestado;
import com.crud.sbcrud.model.Manifestante;
import com.crud.sbcrud.service.ManifestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManifestadoController {

    //#region ..:: Variáveis ::..
    @Autowired
    private ManifestadoService service;

    //#endregion ..:: Variáveis ::..

    //#region ..:: Consultas ::..
    @GetMapping("/consultar_manifestado")
    public String consultarManifestado(Model model) {
        List<Manifestado> manifestado = service.listarManifestados();
        model.addAttribute("manifestado", manifestado);

        return "consultar_manifestado";
    }

    //#endregion ..:: Consultas ::..

    //#region ..:: Cadastros ::..

    @GetMapping("/cadastrar_manifestado")
    public String cadastrarManifestado() {
        return "cadastrar_manifestado";
    }

    @PostMapping("/cadastrar_manifestado")
    public String gravarManifestado(@ModelAttribute Manifestado manifestado, HttpSession session) {
        service.gravarManifestado(manifestado);
        session.setAttribute("msg", "Manifestado inserido com sucesso!");
        return "redirect:/consultar_manifestado";
    }

    //#endregion ..:: Cadastros ::..

    //#region ..:: Atualizações ::..

    @GetMapping("/alterar_manifestado/{id}")
    public String alterarManifestado(@PathVariable int id, Model model) {
        Manifestado manifestado = service.obterManifestadoPorId(id);
        model.addAttribute("manifestado", manifestado);

        return "alterar_manifestado";
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestado_json", method=RequestMethod.GET)
    public List<Manifestado> consultarManifestadoJson(Model model) {
        List<Manifestado> manifestado = service.listarManifestados();
        model.addAttribute("manifestado", manifestado);

        return manifestado;
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestados_total_json", method = RequestMethod.GET)
    public long consultarQuantidadeManifestadosJson(Model model) {
        long totalManifestados = service.obterQuantidadeManifestados();
        model.addAttribute("totalManifestados", totalManifestados);

        return totalManifestados;
    }

    @PostMapping("/atualizar_manifestado")
    public String atualizarManifestado(@ModelAttribute Manifestado manifestado, HttpSession session) {
        service.gravarManifestado(manifestado);
        session.setAttribute("msg", "Manifestado atualizado com sucesso!");

        return "redirect:/consultar_manifestado";
    }

    //#endregion ..:: Atualizações ::..

    //#region ..:: Remoção ::..

    @GetMapping("/remover_manifestado/{id}")
    public String removerManifestado(@PathVariable int id, HttpSession session) {
        service.removerManifestadoPorId(id);
        session.setAttribute("msg", "Manifestado removido com sucesso!");

        return "redirect:/consultar_manifestado";
    }

    //#endregion ..:: Remoção ::..

}
