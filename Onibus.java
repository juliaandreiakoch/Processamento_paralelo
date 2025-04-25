public class Onibus extends Thread {
    Terminal terminal;

    public Onibus(String nome, Terminal terminal) {
        super(nome);
        this.terminal = terminal;
    }

    public void run() {
        while (true) {
            try {
                int tempoMin = 2 * 60 * 1000; 
                int tempoMax = 3 * 60 * 1000; 
                int tempoChegada = tempoMin + (int)(Math.random() * (tempoMax - tempoMin));

                Thread.sleep(tempoChegada);
                terminal.iniciarEmbarque(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
