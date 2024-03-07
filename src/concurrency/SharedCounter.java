package concurrency;

@SuppressWarnings("ALL")
public class SharedCounter implements Runnable { // aplicação multithread inconsistente: contador

    private int i;

    @Override
    public void run() { // nessa versão não temos a impressão dos valores duas vezes, devido inconsistência, alguns nem aparecem
        while (i < 10){
            System.out.format("[%s] %d\n", Thread.currentThread().getName(), i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    } // esse contador apresenta um problema grave de inconsistência, sendo importante entender o que está ocorrendo
} // a IDE, por exemplo, aponta que a Thread fica dormindo e ninguém a acorda consumindo recursos desnecessariamente além de gerar a inconsistência
// Call to 'Thread.sleep()' in a loop, probably busy-waiting
