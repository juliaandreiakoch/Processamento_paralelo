public class Aluno extends Thread {
  Terminal terminal;
  int tempoDeAula;

  public Aluno(String nome, Terminal terminal, int tempoDeAula) {
      super(nome);
      this.terminal = terminal;
      this.tempoDeAula = tempoDeAula;
  }

  public void run() {
      try {
          Thread.sleep(tempoDeAula);
          terminal.chegarAoPonto(this);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
