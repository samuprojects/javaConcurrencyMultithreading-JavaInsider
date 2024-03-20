package concurrency.concurrent;

/*
* Dado a natureza do Cache, synchronized, lock, ReentrantLock não resolvem o problema "Leitor/Escritor"
* Onde temos muitas threads para leitura e poucas para escrita.
*
* A solução é usar o ReentrantReadWriteLock que disponibiliza um par de locks, um para leitura e outro para escrita.
*
* O lock de leitura permite que múltiplas threads acessem a região crítica apenas para leitura
* O lock de escrita é exclusivo, ou seja, quando uma thread recebe esse lock nenhuma outra está lendo ou escrevendo.
*
* Ele aguarda o que está em execução terminar de ler, vai garantir não haver nenhuma thread escrevendo e aí, sim, libera o lock.
* A partir daí nenhum lock de leitura é liberado.
*
* */

@SuppressWarnings("ALL")
public class AppCache {

    public static void main(String[] args) {
        Cache cache = Cache.getInstance();

        cache.set("P1", "V1");
        cache.set("P2", "V2");
        cache.set("P3", "V3");

        String p1 = cache.get("P1");
        String p2 = cache.get("P2");
        String p3 = cache.get("P3");
    }
}
