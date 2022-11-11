package com.github.daniel.resumob3.io;

import com.github.daniel.resumob3.domain.Negociacao;
import com.github.daniel.resumob3.domain.Resumo;
import com.github.daniel.resumob3.domain.ResumoRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;

public class CSVResumoRepository implements ResumoRepository {
    // Formatação dos valores monetátios para o padrão nacional.
    DecimalFormat df = new DecimalFormat("#,##0.00");

    @Override
    public void save(Resumo resumo, OutputStream output) {
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo de Movimentação");
        sb.append(";");
        sb.append("Ativo");
        sb.append(";");
        sb.append("Preço Médio");
        sb.append(";");
        sb.append("Quantidade Negociada");
        sb.append(";");
        sb.append("Valor Total Negociado");
        sb.append("\n");

        for (Negociacao resumoNegociacoes : resumo.getResumoNegociacoes()) {
            sb.append(resumoNegociacoes.getTipoDeMovimentacao()
                    .getTipoDeMovimentacao());
            sb.append(";");
            sb.append(resumoNegociacoes.getAtivo());
            sb.append(";");
            sb.append("R$ " + df.format(resumoNegociacoes.getPrecoNegociado()));
            sb.append(";");
            sb.append(resumoNegociacoes.getQuantidadeNegociada());
            sb.append(";");
            sb.append("R$ " + df.format(resumoNegociacoes.getValorTotalNegociado()));
            sb.append("\n");
        }

        byte[] arquivoCSVByte = sb.toString().getBytes();
        try {
            output.write(arquivoCSVByte);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}