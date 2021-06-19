import java.util.Stack;

public class StackDemo implements EstruturaDados {
    Stack<Pessoa> pilha = new Stack<>();


    @Override
    public void adicionar(Pessoa pessoa) {
        System.out.println("======================== ADICIONAR ==========================");
        pilha.push(pessoa);
        System.out.println("Pessoa adicionada com sucesso !");
    }

    @Override
    public void buscar(String nome) {
        System.out.println("============================= BUSCAR POR NOME ===============================");
        boolean pessoaEncontrada = false;
        for( Pessoa pessoa : pilha){
            if(pessoa.getNome().equals(nome)){
                System.out.println(pessoa);
                pessoaEncontrada = true;
            }
        }
        if(!pessoaEncontrada){
            System.out.println("Não existe ninguém com esse nome na pilha");
        }
    }

    @Override
    public void remover(Pessoa pessoa) {
        System.out.println("============================= REMOVER POR PESSOA =================================");
        boolean pessoaEncontrada = false;
        for (Pessoa pessoaDaPilha : pilha) {
            if (pessoaDaPilha.equals(pessoa)){
                Stack<Pessoa> pilhaTemporaria = new Stack<>();
                pilhaTemporaria.addAll(pilha);
                pilha.clear();
                for (Pessoa pessoaDaPilhaTemporaria : pilhaTemporaria){
                    if(!pessoaDaPilhaTemporaria.equals(pessoa)){
                        pilha.push(pessoaDaPilhaTemporaria);
                    }
                }
                pilha.push(pessoa);
                pessoaEncontrada = true;
                break;
            }
        }
        if(pessoaEncontrada){
            System.out.println("Pessoa excluída: " + pilha.pop());
            System.out.println("Pessoa excluída com sucesso !");
        }else{
            System.out.println("Pessoa não encontrada");
        }
    }

    @Override
    public void remover(int index) {
        System.out.println("=========================== REMOVER POR INDEX ============================");
        int cont = 1;
        boolean pessoaEncontrada = false;
        if(index > 0 && index <= pilha.size()) {
            for (Pessoa pessoa : pilha) {
                if (cont == index){
                    Stack<Pessoa> pilhaTemporaria = new Stack<>();
                    pilhaTemporaria.addAll(pilha);
                    pilha.clear();
                    for (Pessoa pessoaDaPilhaTemporaria : pilhaTemporaria){
                        if(!pessoaDaPilhaTemporaria.equals(pessoa)){
                            pilha.push(pessoaDaPilhaTemporaria);
                        }
                    }
                    pilha.push(pessoa);
                    pessoaEncontrada = true;
                    break;
                }
                cont++;
            }
            if(pessoaEncontrada){
                System.out.println("Pessoa excluída: " + pilha.pop());
                System.out.println("Pessoa excluída com sucesso !");
            }
        }else{
            System.out.println("Esse index não existe na pilha");
        }
    }

    @Override
    public void listarTodos() {
        System.out.println("================================ LISTAR TODOS ===================================");
        for (Pessoa pessoa : pilha){
            System.out.println(pessoa);
        }
    }

    @Override
    public Pessoa getPessoa(int index) {
        System.out.println("=================================== GETPESSOA =================================");
        int cont = 1;
        if (index > 0 && index <= pilha.size()) {
            for (Pessoa pessoa : pilha) {
                if(cont == index){
                    return pessoa;
                }
            }
        }else{
            System.out.println("Esse index não existe na pilha");
        }
        return null;
    }
}
