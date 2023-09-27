import banco.ContaBanco;

public class app {
    
    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(1111);
        p1.setDono("Felipe");
        p1.abrirConta("CC");
        p1.depositar(100);
        p1.sacar(150);
        p1.fecharConta();

        p1.estadoAtual();
       
    }
}
