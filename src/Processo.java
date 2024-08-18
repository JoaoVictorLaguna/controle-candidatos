import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Processo {

    public static void main(String[] args) {
        selecaoCandidato();
    }

    public static void selecaoCandidato() {
        String[] candidatos = {"Felipe", "João", "Julia", "Paulo", "Augusto", "Daniele", "Mara", "Mirella", "Jose"};
        ArrayList<String> candidatosSelecionados = new ArrayList<>();
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados.size() < 5) {
            if (candidatoAtual >= candidatos.length) {
                candidatoAtual = 0;
            }

            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados.add(candidato);
            } else {
                System.out.println("Negociando com o candidato " + candidato);
                candidatosSelecionados.add(candidato);
            }

            candidatoAtual++;
        }

        for (String candidato : candidatosSelecionados) {
            tentarContato(candidato);
        }

        System.out.println("\nCandidatos selecionados:");
        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void tentarContato(String candidato) {
        System.out.println("\nTentando contato com " + candidato + "...");
        boolean contatoRealizado = false;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Realizando " + i + "ª tentativa de contato com " + candidato + "...");
            boolean atendeu = ThreadLocalRandom.current().nextBoolean();

            if (atendeu) {
                System.out.println("Tentativa " + i + ": Contato realizado com sucesso com " + candidato);
                contatoRealizado = true;
                break;
            } else {
                System.out.println("Tentativa " + i + ": O candidato " + candidato + " não atendeu.");
            }
        }

        if (!contatoRealizado) {
            System.out.println("Não conseguimos contato com o candidato " + candidato + " após 3 tentativas.");
        }
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}