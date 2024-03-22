package concurrency.other;

/*
* A operação de yield permite sinalizar que uma determinada thread deseja passar sua vez para outra thread executar
* Ele é colocado dentro da própria thread e serve como sinalizador (hint) para o escalonador que pode ou não ser acatada.
* Como não é um cenário comum em produção, o professor recomenda em casos específicos documentar bem o uso do yield.
* Além de fazer muitos testes para verificar se o sistema operacional em uso, bem como a jdk, realmente fará diferença
* no uso do yield.
* Isso porque nada é garantido no cenário de threads.
*
* */

public class AppThreadYield {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

                Thread.yield();
            }
        }).start();
    }
}
