package br.com.crud;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnotacaoService implements AnotacaoInterface {

    private File file;
    private Anotacao anotacao;


    // Cria um arquivo no momento da instanciação da classe
    public AnotacaoService(Anotacao anotacao) {

        this.anotacao = anotacao;

        try
        {
          this.file = new File("Z:\\anotacoes.txt");
        }

        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
    }


    // Cria um anotação
    public void criarAnotacao()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(this.file, true);

            fileWriter.write(this.anotacao.getConteudo() + System.lineSeparator());


            fileWriter.close();

        }

        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
    }


    // Ler Anotação
    public void lerAnotacao()
    {
        try
        {
            FileReader fileReader = new FileReader(this.file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null)
            {
                System.out.println(line);

                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        }

        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
    }

    // Apagar anotacao
    public void apagarAnotacao(int numeroLinha)
    {
        int linhasLidas = 1;
        List<String> minhasAnotacoes = new ArrayList<>();


        try
        {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();


            // Adiciona todos as anotaçoes do arquivo de texto dentro de uma array (menos o que o usuário deseja apagar)
            while (line != null)
            {
                if (numeroLinha != linhasLidas) {
                    minhasAnotacoes.add(line);
                }

                line = bufferedReader.readLine();

                linhasLidas += 1;
            }
            bufferedReader.close();


            // Apagando todos os dados do arquivo de texto
            FileWriter fileWriter = new FileWriter(this.file, false);
            fileWriter.append("");
            fileWriter.close();


            // Passando informações do array para o arquivo de texto
            FileWriter fw = new FileWriter(this.file, true);
            for (String l: minhasAnotacoes) {
                fw.write(l + System.lineSeparator());
            }

            fw.close();
        }

        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
    }


    // update
    public void editarAnotacao(String novaAnotacao, int linhaDaAnotacao)
    {
        int linhasLidas = 1;
        List<String> minhasAnotacoes = new ArrayList<>();


        try
        {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();


            // Adiciona todos as anotaçoes do arquivo de texto dentro de uma array (menos o que o usuário deseja apagar)
            while (line != null)
            {
                if (linhaDaAnotacao == linhasLidas) {
                    minhasAnotacoes.add(novaAnotacao);
                } else {
                    minhasAnotacoes.add(line);
                }

                line = bufferedReader.readLine();

                linhasLidas += 1;
            }
            bufferedReader.close();


            // Apagando todos os dados do arquivo de texto
            FileWriter fileWriter = new FileWriter(this.file, false);
            fileWriter.append("");
            fileWriter.close();


            // Passando informações do array para o arquivo de texto
            FileWriter fw = new FileWriter(this.file, true);
            for (String l: minhasAnotacoes) {
                fw.write(l + System.lineSeparator());
            }

            fw.close();
        }

        catch (Exception erro)
        {
            System.out.println(erro.getMessage());
        }
    }

}
