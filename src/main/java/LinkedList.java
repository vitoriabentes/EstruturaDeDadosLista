import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class LinkedList implements EstruturaDados{
    private  Node head;
    private int qtd = 0;


    @Getter @Setter @ToString
    private class Node{
        private Pessoa dado;
        private Node next;

        public Node(Pessoa pessoa){
            this.dado = pessoa;
        }
    }

    @Override
    public void adicionar(Pessoa pessoa) {
        System.out.println("========================== ADICIONAR PESSOA =======================");
        Node node = new Node(pessoa);
        if(this.head == null){
            this.head = node;
        }else if(this.head.getNext() == null){
            this.head.setNext(node);
        }else{
            node.setNext(this.head.getNext());
            this.head.setNext(node);
        }
        qtd++;
        System.out.println("Pessoa adicionada com sucesso !");
    }

    public void adicionarInicio(Pessoa pessoa){
        Node node = new Node(pessoa);
        if(this.head == null){
            this.head = node;
        }else{
            node.setNext(this.head);
            this.head = node;
        }
        qtd++;
        //if(this.head != null){ node.setNext(this.head)} this.head = node;
    }

    public void adicionarFim(Pessoa pessoa){
        Node newNode = new Node(pessoa);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node node = this.head;
            while(node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        qtd++;
    }

    @Override
    public void buscar(String nome) {
        System.out.println("====================== BUSCAR POR NOME ========================");
        boolean pessoaEncontrada = false;
        Node node = this.head;
        while(node != null){
            if(node.getDado().getNome().equalsIgnoreCase(nome)){
                System.out.println(node.getDado());
                pessoaEncontrada = true;
            }
            node = node.getNext();
        }
        if(!pessoaEncontrada){
            System.out.println("Não existe nenhuma pessoa com esse nom na lista");
        }
    }

    @Override
    public void remover(Pessoa pessoa) {
        System.out.println("====================== REMOVER POR PESSOA ================================");
        boolean pessoaEncontrada = false;
        Node node = this.head;
        Node previsao = null;
        while(node != null){
            Pessoa pessoaDaBusca = node.getDado();
            if(pessoaDaBusca.equals(pessoa)){
                if(previsao == null){
                    this.head = node.getNext();
                }else{
                    previsao.setNext(node.getNext());
                }
                pessoaEncontrada = true;
                qtd--;
                break;
            }
            previsao = node;
            node = node.getNext();
        }
        if (pessoaEncontrada){
            System.out.println("Pessoa removida com sucesso !");
        }else{
            System.out.println("Pessoa não encontrada");
        }
    }

    @Override
    public void remover(int index) {
        System.out.println("========================== REMOVER PELO INDEX ======================");
        int cont = 1;
        if(index > 0 && index <= qtd ) {
            boolean pessoaEncontrada = false;
            Node node = this.head;
            Node previsao = null;
            while(node != null){
                if(cont == index){
                    if(previsao == null){
                        this.head = node.getNext();
                    }else{
                        previsao.setNext(node.getNext());
                    }
                    pessoaEncontrada = true;
                    qtd--;
                    break;
                }
                cont++;
                previsao = node;
                node = node.getNext();
            }
            if (pessoaEncontrada){
                System.out.println("Pessoa removida com sucesso !");
            }
        }else{
            System.out.println("Esse index não é válido");
        }
    }

    @Override
    public void listarTodos() {
        System.out.println("============================= LISTAR TODOS =============================");
        Node node = this.head;
        while(node != null){
            System.out.println(node.getDado());
            node = node.getNext();
        }
    }

    @Override
    public Pessoa getPessoa(int index) {
        System.out.println("============================= GETPESSOA PELO INDEX ======================");
        int cont = 0;
        Node node = this.head;
        while(node != null){
            if(cont == index){
                return node.getDado();
            }
            cont++;
            node = node.getNext();
        }
        System.out.println("Pessoa não encontrada");
        return null;
    }
}
