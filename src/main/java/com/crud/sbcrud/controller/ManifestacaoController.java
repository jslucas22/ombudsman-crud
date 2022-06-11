package com.crud.sbcrud.controller;

import com.crud.sbcrud.model.ManifestacaoModel;
import com.crud.sbcrud.service.ExcelService;
import com.crud.sbcrud.service.ManifestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ManifestacaoController {

    //#region ..:: Variáveis ::..

    @Autowired
    private ManifestacaoService service;

    //#endregion ..:: Variáveis ::..

    //#region ..:: Consultas ::..

    @GetMapping("/consultar_manifestacao")
    public String consultarManifestacao(Model model) {
        List<ManifestacaoModel> manifestacaoModel = service.listarManifestacao();
        model.addAttribute("manifestacaoModel", manifestacaoModel);

        return "consultar_manifestacao";
    }

    @ResponseBody
    @RequestMapping(value = "/consultar_manifestacao_total_json", method = RequestMethod.GET)
    public long consultarQuantidadeManifestacoesJson(Model model) {
        long totalManifestacoes = service.obterQuantidadeManifestacoes();
        model.addAttribute("totalManifestacoes", totalManifestacoes);

        return totalManifestacoes;
    }

    //#endregion ..:: Consultas ::..

    //#region ..:: Cadastros ::..

    @GetMapping("/cadastrar_manifestacao")
    public String cadastrarManifestacao() {
        return "cadastrar_manifestacao";
    }

    @PostMapping("/cadastrar_manifestacao")
    public String gravarManifestacao(@ModelAttribute ManifestacaoModel manifestacaoModel, HttpSession session) {
        service.gravarManifestacao(manifestacaoModel);
        session.setAttribute("msg", "Manifestação inserido com sucesso!");
        return "redirect:/consultar_manifestacao";
    }

    //#endregion ..:: Cadastros ::..

    //#region ..:: Atualizações ::..

    @GetMapping("/alterar_manifestacao/{id}")
    public String alterarManifestacao(@PathVariable int id, Model model) {
        ManifestacaoModel manifestacaoModel = service.obterManifestacao(id);
        model.addAttribute("manifestacaoModel", manifestacaoModel);

        return "alterar_manifestacao";
    }

    @PostMapping("/atualizar_manifestacao")
    public String atualizarManifestacao(@ModelAttribute ManifestacaoModel manifestacaoModel, HttpSession session) {
        service.gravarManifestacao(manifestacaoModel);
        session.setAttribute("msg", "Manifestação atualizado com sucesso!");

        return "redirect:/consultar_manifestacao";
    }

    //#endregion ..:: Atualizações ::..

    //#region ..:: Remoção ::..

    @GetMapping("/remover_manifestacao/{id}")
    public String removerManifestacao(@PathVariable int id, HttpSession session) {
        service.removerManifestacaoPorId(id);
        session.setAttribute("msg", "Manifestação removido com sucesso!");

        return "redirect:/consultar_manifestacao";
    }

    //#endregion ..:: Remoção ::..

    //#region ..:: Serviços Auxiliares ::..

    @GetMapping("/manifestacao/exportar")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        DateFormat data = new SimpleDateFormat("dd_MM_yyyy_HH:mm:ss");
        String dataHoje = data.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=manifestacoes_" + dataHoje + ".xlsx";

        response.setHeader(headerKey, headerValue);
        List<ManifestacaoModel> manifestacoes = service.listarManifestacao();

        ExcelService excelExporter = new ExcelService(manifestacoes);
        excelExporter.exportar(response);
    }

    //#endregion
}
