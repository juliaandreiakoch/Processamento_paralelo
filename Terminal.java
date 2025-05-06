import java.util.ArrayList;
import java.util.List;

public class Terminal {
    int capacidadeOnibus = 50;
    int passageirosEmbarcados = 0;
    boolean embarqueIniciado = false;

    private List<Aluno> filaDeEspera = new ArrayList<>();

    public void chegarAoPonto(Aluno aluno) {
        if (embarqueIniciado) {
            System.out.println("Aluno " + aluno.getName() + " chegou durante o embarque.");
            return; 
        }

        filaDeEspera.add(aluno);
        System.out.println("\n " + aluno.getName() + " chegou ao ponto de onibus");
    }

    public synchronized void iniciarEmbarque(Onibus onibus) {
        passageirosEmbarcados = 0;

        System.out.println("\n Bus Feevale chegou ao ponto");

        if (filaDeEspera.size() == 0) {
            System.out.println("\n Bus Feevale partindo imediatamente - Nenhum passageiro");
            return;
        }

        embarqueIniciado = true;

        while (filaDeEspera.size() != 0 && passageirosEmbarcados < capacidadeOnibus) {
            Aluno aluno = filaDeEspera.remove(0);
            System.out.println("\n Embarcando no Bus Feevale " + aluno.getName());
            passageirosEmbarcados++;
        }

        embarqueIniciado = false;
        System.out.println("\n Embarque finalizado com " + passageirosEmbarcados + " passageiros. Bus Feevale partindo");
    }
}
