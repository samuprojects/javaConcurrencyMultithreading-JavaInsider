package theory;

@SuppressWarnings("ALL")
public class SynchronizedMethod {

    /*
    *
    * Aproveitando o exemplo anterior o professor explicou que a atuação do bloco synchronized pode ser expandida para o método inteiro
    * ao invés de ficar somente no counter++ ficaria assim
    * public void run() {
            synchronized (MONITOR) {
            for (int i = 0; i < 10; i++) {
                    counter++;
                    AppSynchronizedCounter3.sleep(10);
                }
            }
        }
    *
    * fazendo com que o método run inteiro fique sincronizado por um monitor
    *
    * Apesar do resultado ser consistente a execução não é mais multithread porque todas as threads serão bloqueadas e comente uma
    * vai entrar na região crítica executar tudo e sair. Ou seja, se tornou um processo sequencial além de não ser a forma mais otimizado de se fazer.
    *
    * Quando ocorre essa situação poderíamos definir o próprio método como synchronized conforme a seguir:
    * @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                    counter++;
                    AppSynchronizedCounter3.sleep(10);
                }
        }
    *
    * ao fazer isso também dizemos para o java executar o código que está num contexto de região crítica, MAS, nesse formato o monitor será o próprio objeto.
    * E é a mesma coisa que definir um bloco synchronized utilizando this como parametro
    * @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    counter++;
                    AppSynchronizedCounter3.sleep(10);
                }
            }
        }
    *
    * O resultado nos dois casos é a volta do bug da inconsistência porque como construímos 3 objetos e eles mesmos são usados como monitor, terão acesso
    * simultaneo à região crítica, nunca vai bloquear o acesso, porque o monitor não é o mesmo, gerando o problema.
    *
    * OU seja, só pode usar um método como synchronized ou um bloco synchronized passando this se realmente deseja que o objeto seja o próprio monitor, com esse risco
    * dependendo da implementação.
    *
    * Para corrigir basta utilizar o monitor no contexto estático (pertencente à classe) para que as threads vejam apenas o mesmo monitor.
    * Por isso voltou o cenário no código que também não é o melhor (por que torna sequencial as ações, dexando de ser multithread) para demonstrar uma solução para o problema
    *
    *@Override
        public void run() {
            synchronized (MONITOR) {
                for (int i = 0; i < 10; i++) {
                    counter++;
                    AppSynchronizedCounter3.sleep(10);
                }
            }
        }
    *
    *
    *
    * */
}
