package com.crud.sbcrud.controller;

import com.crud.sbcrud.model.Manifestado;
import com.crud.sbcrud.model.TipoManifestacao;
import com.crud.sbcrud.service.TipoManifestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TipoManifestacaoController {

    //#region ..:: Variáveis ::..
    @Autowired
    private TipoManifestacaoService service;

    //#endregion ..:: Variáveis ::..

    //#region ..:: Consultas ::..
    @GetMapping("/consultar_tipo_manifestacao")
    public String consultarTipoManifestacao(Model model) {
        List<TipoManifestacao> tipoManifestacao = service.listarTipoManifestacao();
        model.addAttribute("tipoManifestacao", tipoManifestacao);

        return "consultar_tipo_manifestacao";
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_tipo_manifestacao_json", method = RequestMethod.GET)
    public List<TipoManifestacao> consultarTipoManifestacaoJson(Model model) {
        List<TipoManifestacao> tipoManifestacao = service.listarTipoManifestacao();
        model.addAttribute("tipoManifestacao", tipoManifestacao);

        return tipoManifestacao;
    }

    //#endregion ..:: Consultas ::..

    //#region ..:: Cadastros ::..

    @GetMapping("/cadastrar_tipo_manifestacao")
    public String cadastrarTipoManifestacao() {
        return "cadastrar_tipo_manifestacao";
    }

    @PostMapping("/cadastrar_tipo_manifestacao")
    public String gravarTipoManifestacao(@ModelAttribute TipoManifestacao tipoManifestacao, HttpSession session) {
        service.gravarTipoManifestacao(tipoManifestacao);
        session.setAttribute("msg", "Tipo de Manifestação inserido com sucesso!");
        return "redirect:consultar_tipo_manifestacao";
    }

    //#endregion ..:: Cadastros ::..

    //#region ..:: Atualizações ::..

    @GetMapping("/alterar_tipo_manifestacao/{id}")
    public String alterarTipoManifestacao(@PathVariable int id, Model model) {
        TipoManifestacao tipoManifestacao = service.obterTipoManifestacaoPorId(id);
        model.addAttribute("tipoManifestacao", tipoManifestacao);

        return "alterar_tipo_manifestacao";
    }

    @PostMapping("/atualizar_tipo_manifestacao")
    public String atualizarTipoManifestacao(@ModelAttribute TipoManifestacao tipoManifestacao, HttpSession session) {
        service.gravarTipoManifestacao(tipoManifestacao);
        session.setAttribute("msg", "Tipo de Manifestação atualizado com sucesso!");

        return "redirect:/consultar_tipo_manifestacao";
    }

    //#endregion ..:: Atualizações ::..

    //#region ..:: Remoção ::..

    @GetMapping("/remover_tipo_manifestacao/{id}")
    public String removerTipoManifestacao(@PathVariable int id, HttpSession session) {
        service.removerTipoManifestacaoPorId(id);
        session.setAttribute("msg", "Tipode Manifestação removido com sucesso!");

        return "redirect:/consultar_tipo_manifestacao";
    }

    //#endregion ..:: Remoção ::..
}
