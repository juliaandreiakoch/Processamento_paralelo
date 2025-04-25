public class Main {
  public static void main(String[] args) {
      Terminal terminal = new Terminal();

      int tempoMin = 2 * 60 * 1000; 
      int tempoMax = 10 * 60 * 1000; 
      int tempoDeAula = tempoMin + (int)(Math.random() * (tempoMax - tempoMin));
  
      System.out.println("\n --- Aulas vao durar " + tempoDeAula / 60000 + " minutos ---");

      Onibus onibus = new Onibus("Bus Feevale - ", terminal);
      onibus.start();

      new Thread(() -> {
          int contador = 1;
          while (true) {
              Aluno aluno = new Aluno("Aluno-" + contador++, terminal, tempoDeAula);
              aluno.start();
              try {
                  Thread.sleep(500 + (int)(Math.random() * 1500));
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }).start();
  }
}
