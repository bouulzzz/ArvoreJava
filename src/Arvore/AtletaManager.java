package Arvore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AtletaManager {

    private ArrayList<Atleta> atletas;
    private Scanner scanner;

    public AtletaManager() {
        atletas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("╔═════════════════════════════════╗");
            System.out.println("║            MENU                 ║");
            System.out.println("║   1 - Cadastrar atleta          ║");
            System.out.println("║   2 - Listar atleta             ║");
            System.out.println("║   3 - Listar atleta por altura  ║");
            System.out.println("║   4 - Remover atleta            ║");
            System.out.println("║   5 - Pesquisar atleta          ║");
            System.out.println("║                                 ║");
            System.out.println("║   6 - Sair                      ║");
            System.out.println("╚═════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarAtleta();
                    break;
                case 2:
                    listarAtletas();
                    break;
                case 3:
                    listarAtletasPorAlturaDecrescente();
                    break;
                case 4:
                    removerAtleta();
                    break;
                case 5:
                    pesquisarPorApelido();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void cadastrarAtleta() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Posição (entrada ou saída): ");
        String posicao = scanner.nextLine();

        Atleta atleta = new Atleta(nome, apelido, altura, posicao);
        if (!atletas.contains(atleta)) {
            atletas.add(atleta);
            System.out.println("Atleta cadastrado com sucesso.");
        } else {
            System.out.println("Atleta com este apelido já está cadastrado.");
        }
    }

    private void listarAtletas() {
        if (atletas.isEmpty()) {
            System.out.println("Nenhum atleta cadastrado.");
        } else {
            for (Atleta atleta : atletas) {
                System.out.println(atleta);
            }
        }
    }

    private void listarAtletasPorAlturaDecrescente() {
        if (atletas.isEmpty()) {
            System.out.println("Nenhum atleta cadastrado.");
        } else {
            ArrayList<Atleta> listarAtletas = new ArrayList<>(atletas);
            listarAtletas.sort(Comparator.comparingDouble(Atleta::getAltura).reversed());

            for (Atleta atleta : listarAtletas) {
                System.out.println(atleta);
            }
        }
    }

    private void removerAtleta() {
        System.out.print("Apelido do atleta a ser removido: ");
        String apelido = scanner.nextLine();

        Atleta remover = null;
        for (Atleta atleta : atletas) {
            if (atleta.getApelido().equals(apelido)) {
                remover = atleta;
                break;
            }
        }

        if (remover != null) {
            atletas.remove(remover);
            System.out.println("Atleta removido com sucesso.");
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }

    private void pesquisarPorApelido() {
        System.out.print("Apelido do atleta: ");
        String apelido = scanner.nextLine();

        for (Atleta atleta : atletas) {
            if (atleta.getApelido().equals(apelido)) {
                System.out.println(atleta);
                return;
            }
        }
        System.out.println("Atleta não encontrado.");
    }
}
