package GUI;

import java.util.Locale;
import java.util.Scanner;

import main.java.aplication.Metricas;
import main.java.business.IMetricas;
import main.java.business.NegociacaoMedia;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        IMetricas repoMetricas = new Metricas();

        Scanner sc = new Scanner(System.in);
        String codigo = sc.nextLine();
        NegociacaoMedia negociacaoMedia = repoMetricas.negociacaoMedia(codigo);
        System.out.printf("Ativo: %s \nValor relativo: %.2f", negociacaoMedia.getCodigoDeNegociacao(),
                negociacaoMedia.getPrecoNegociado());

        sc.close();
    }
    // FIXME organização do repositorio;
    // FIXME Testes;
    // FIXME Interface gráfica;
}