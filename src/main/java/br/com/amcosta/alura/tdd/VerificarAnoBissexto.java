package br.com.amcosta.alura.tdd;

public class VerificarAnoBissexto {
    public boolean ehBissexto(int ano) {
        boolean bissexto = false;

        if (ano % 400 == 0) {
            bissexto = true;
        }
        else if (ano % 100 == 0) {
            bissexto = false;
        }
        else if (ano % 4 == 0) {
            bissexto = true;
        }

        return bissexto;
    }
}
