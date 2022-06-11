package com.crud.sbcrud.service;

import com.crud.sbcrud.model.ManifestacaoModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import static org.apache.poi.ss.util.CellUtil.createCell;

public class ExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ManifestacaoModel> manifestacoes;

    public ExcelService(List<ManifestacaoModel> manifestacoes) {
        this.manifestacoes = manifestacoes;
        workbook = new XSSFWorkbook();
    }

    private void criarCabecalho() {
        sheet = workbook.createSheet("Manifestações");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Manifestante", style);
        createCell(row, 1, "Manifestado", style);
        createCell(row, 2, "Tipo Manifestação", style);
        createCell(row, 3, "Tag", style);
        createCell(row, 4, "Manifestação", style);

    }

    private void criarCelulas(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);

        Cell cell = row.createCell(columnCount);
        cell.setCellValue((String) value);

        cell.setCellStyle(style);
    }

    private void escreverLinhas() {
        int linhas = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (ManifestacaoModel manifestacao : manifestacoes) {
            Row row = sheet.createRow(linhas++);
            int columnCount = 0;

            createCell(row, columnCount++, manifestacao.manifestante.getNome() + ' ' + manifestacao.manifestante.getSobrenome(), style);
            createCell(row, columnCount++, manifestacao.manifestado.getNome() + ' ' + manifestacao.manifestado.getSobrenome(), style);
            createCell(row, columnCount++, manifestacao.tipoManifestacao.tipo, style);
            createCell(row, columnCount++, manifestacao.tag.tipo, style);
            createCell(row, columnCount++, manifestacao.manifestacao, style);

        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        criarCabecalho();
        escreverLinhas();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
