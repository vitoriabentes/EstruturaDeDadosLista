import java.time.LocalDate;
import java.util.Arrays;


public class Aplicacao {
    public static void main(String[] args) {
        var pessoa = new Pessoa("Vitória", LocalDate.of(2003, 04, 15), "vitoriabentes@gmail.com");
        var pessoa2 = new Pessoa("Sabrina", LocalDate.of(2002, 12, 12), "sabrina@gmail.com");
        var pessoa3 = new Pessoa("Lilian", LocalDate.of(2000, 03, 23), "lilian@gmail.com");
        int[] array = {11, 12, 16, 19, 15, 18, 14, 17, 10, 13};



        /**  TESTES DO LINKED LIST */
        TestesLinkedList(pessoa,pessoa2,pessoa3);

        /**  TESTES DO QUEUE */
        TestesQueue(pessoa,pessoa2,pessoa3);

        /**  TESTES DO STACK */
        TestesStack(pessoa,pessoa2,pessoa3);

        /**  SELECTION SORT */
        selectionSort(array);

        /**  BUBBLE SORT */
        bubbleSort(array);

        /**  MERGE SORT */
        mergeSort(array.length, array);
        System.out.println(Arrays.toString(array));

    }

    public static void selectionSort(int[] selectionSort) {
        for (int i = 0; i < selectionSort.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < selectionSort.length; j++) {
                if (selectionSort[j] < selectionSort[min_index]) {
                    min_index = j;
                }
            }
            int temp = selectionSort[i];
            selectionSort[i] = selectionSort[min_index];
            selectionSort[min_index] = temp;
        }
        System.out.println(Arrays.toString(selectionSort));
    }

    public static void bubbleSort(int[] bubbleSort) {
        for (int i = 0; i < bubbleSort.length - 1; i++) {
            for (int j = 0; j < bubbleSort.length - 1 - i; j++) {
                if (bubbleSort[j] > bubbleSort[j + 1]) {
                    int temp = bubbleSort[j];
                    bubbleSort[j] = bubbleSort[j + 1];
                    bubbleSort[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(bubbleSort));
    }

    private static void mergeSort(int tamanho, int[] vetor) {

        int elementos = 1;

        int inicio, meio, fim;

        while (elementos < tamanho) {
            inicio = 0;

            while (inicio + elementos < tamanho) {
                meio = inicio + elementos;
                fim = inicio + 2 * elementos;
                fim = tamanho;
                intercala(vetor, inicio, meio, fim);
                inicio = fim;
            }
            elementos = elementos * 2;
        }
    }

    private static void intercala(int[] vetor, int inicio, int meio, int fim) {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;


        while (i < meio && m < fim) {
            if (vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }

    public static void TestesLinkedList(Pessoa pessoa, Pessoa pessoa2, Pessoa pessoa3){
        LinkedList linkedList = new LinkedList();

        //Adicionar pessoas
        linkedList.adicionar(pessoa);
        linkedList.adicionar(pessoa2);
        linkedList.adicionar(pessoa3);

        //Listar todas as pessoas
        linkedList.listarTodos();

        //Buscar por uma pessoa que existe
        linkedList.buscar("Sabrina");

        //Buscar por uma pessoa que não existe na fila
        linkedList.buscar("Rogério");

        //GetPessoa de um index válido
        System.out.println(linkedList.getPessoa(2));

        //GetPessoa de um index não válido
        System.out.println(linkedList.getPessoa(6));

        //Remover pelo index válido
        linkedList.remover(2);

        //Remover por um index não válido
        linkedList.remover(6);

        //Remover por pessoa que existe
        linkedList.remover(pessoa3);

        //Remover por pessoa que não existe na fila
        linkedList.remover(pessoa2);

        //Listar todos da fila
        linkedList.listarTodos();
    }
    public static void TestesQueue(Pessoa pessoa,Pessoa pessoa2, Pessoa pessoa3){
        QueueDemo queue = new QueueDemo();

        //Adicionar pessoas
        queue.adicionar(pessoa);
        queue.adicionar(pessoa2);
        queue.adicionar(pessoa3);

        //Listar todas as pessoas
        queue.listarTodos();

        //Buscar por uma pessoa que existe
        queue.buscar("Sabrina");

        //Buscar por uma pessoa que não existe na fila
        queue.buscar("Rogério");

        //GetPessoa de um index válido
        System.out.println(queue.getPessoa(1));

        //GetPessoa de um index não válido
        System.out.println(queue.getPessoa(6));

        //Remover pelo index válido
        queue.remover(2);

        //Remover por um index não válido
        queue.remover(6);

        //Remover por pessoa que existe
        queue.remover(pessoa3);

        //Remover por pessoa que não existe na fila
        queue.remover(pessoa2);

        //Listar todos da fila
        queue.listarTodos();
    }
    public static void TestesStack(Pessoa pessoa, Pessoa pessoa2, Pessoa pessoa3){
        StackDemo stackDemo = new StackDemo();

        //Adicionar pessoas
        stackDemo.adicionar(pessoa);
        stackDemo.adicionar(pessoa2);
        stackDemo.adicionar(pessoa3);

        //Listar todas as pessoas
        stackDemo.listarTodos();

        //Buscar por uma pessoa que existe
        stackDemo.buscar("Sabrina");

        //Buscar por uma pessoa que não existe na fila
        stackDemo.buscar("Rogério");

        //GetPessoa de um index válido
        System.out.println(stackDemo.getPessoa(1));

        //GetPessoa de um index não válido
        System.out.println(stackDemo.getPessoa(6));

        //Remover pelo index válido
        stackDemo.remover(2);

        //Remover por um index não válido
        stackDemo.remover(6);

        //Remover por pessoa que existe
        stackDemo.remover(pessoa3);

        //Remover por pessoa que não existe na fila
        stackDemo.remover(pessoa2);

        //Listar todos da fila
        stackDemo.listarTodos();
    }
}
