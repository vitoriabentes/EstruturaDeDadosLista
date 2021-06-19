import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayDeque;
import java.util.Queue;

@NoArgsConstructor
class QueueDemo implements EstruturaDados{
    private final Queue<Pessoa> fila = new ArrayDeque<>();

    @Override
    public void adicionar(Pessoa pessoa) {
        System.out.println("========================= ADICIONAR =========================");
        fila.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso !");

    }

    @Override
    public void buscar(String nome) {
        System.out.println("============================= BUSCAR POR NOME ===============================");
        boolean pessoaEncontrada = false;
        for( Pessoa pessoa : fila){
            if(pessoa.getNome().equals(nome)){
                System.out.println(pessoa);
                pessoaEncontrada = true;
            }
        }
        if(!pessoaEncontrada){
            System.out.println("Não existe ninguém com esse nome na fila");
        }
    }

    @Override
    public void remover(Pessoa pessoa) {
        System.out.println("====================== REMOVER POR PESSOA ==========================");
        boolean pessoaEncontrada = false;
        Queue<Pessoa> filaTemporaria = new ArrayDeque<>(fila);
        for (Pessoa pessoaDaFila : fila) {
            if (pessoaDaFila.equals(pessoa)) {
                fila.clear();
                fila.add(pessoa);
                for (Pessoa pessoaDaFilaTemporaria : filaTemporaria) {
                    if (!pessoaDaFilaTemporaria.equals(pessoa)) {
                        fila.add(pessoaDaFilaTemporaria);
                    }
                }
                pessoaEncontrada = true;
                break;
            }
        }
        if(pessoaEncontrada){
            System.out.println("Pessoa excluída: " + fila.poll());
            System.out.println("Pessoa excluída com sucesso !");
        }else{
            System.out.println("Pessoa não encontrada");
        }
    }

    @Override
    public void remover(int index) {
        System.out.println("============================= REMOVER POR INDEX =============================");
        boolean pessoaEncontrada = false;
        int cont = 1;
        if(index <= fila.size() && index > 0) {
            Queue<Pessoa> filaTemporaria = new ArrayDeque<>(fila);
            for (Pessoa pessoa : fila) {
                if (cont == index) {
                    fila.clear();
                    fila.add(pessoa);
                    for(Pessoa pessoaDaFilaTemporaria : filaTemporaria){
                        if(!pessoaDaFilaTemporaria.equals(pessoa)){
                            fila.add(pessoaDaFilaTemporaria);
                        }
                    }
                    pessoaEncontrada = true;
                }
                cont++;
            }
            if(pessoaEncontrada){
                System.out.println("Pessoa excluída: " + fila.poll());
                System.out.println("Pessoa excluída com sucesso !");
            }
        }else{
            System.out.println("Esse index não é válido");
        }
    }

    @Override
    public void listarTodos() {
        System.out.println("============================= LISTAR TODOS ========================");
        for(Pessoa pessoa : fila){
            System.out.println(pessoa);
        }
    }

    @Override
    public Pessoa getPessoa(int index) {
        System.out.println("=============================== GETPESSOA POR INDEX ========================");
        if(index != 0 && index <= fila.size()) {
            int cont = 1;
            for (Pessoa pessoa : fila) {
                if (cont == index) {
                    return pessoa;
                }
                cont++;
            }
        }else{
            System.out.println("Esse index não é válido");
        }
        System.out.println("Pessoa não encontrada");
        return null;
    }
}
