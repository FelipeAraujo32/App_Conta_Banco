package banco;

public class ContaBanco {

    // Atributos ----------------------------------------------------------------------------
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    //Método Construtor ---------------------------------------------------------------------
    public ContaBanco(){
        saldo = 0;
        status = false;
    }

    //Método Personalizado ------------------------------------------------------------------
    public void estadoAtual(){
        System.out.println("----------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    //Getters e Setters ---------------------------------------------------------------------
    public void setNumConta(int Num_Conta){
        this.numConta = Num_Conta;
    }

    public int getNumConta(){
        return this.numConta;
    }

    public void setTipo(String tipo_conta){
        this.tipo = tipo_conta;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setDono(String nome_dono){
        this.dono = nome_dono;
    }

    public String getDono(){
        return this.dono;
    }

    public void setSaldo(float saldo_conta){
        this.saldo = saldo_conta;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void setStatus(boolean logico){
        this.status = logico;
    }

    public boolean getStatus(){
        return this.status;
    }


    // Métodos ------------------------------------------------------------------------------
    public void abrirConta(String tipo){
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo == "CC"){
            this.setSaldo(50);
        }
        else if (tipo == "CP"){
            this.setSaldo(150);
        }
        System.out.println("A conta foi aberta com sucesso");
    }

    public void fecharConta(){
        saldo = this.getSaldo();
        if(saldo > 0){
            System.out.println("Conta com dinheiro");
        }
        else if(saldo < 0){
            System.out.println("Conta em débito");
        }
        else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso.");
        }
    }

    public void depositar(int valor){
        if(this.getStatus() == true){
            this.setSaldo(this.getSaldo() + valor); 
        }
        else if(this.getStatus() == false){
            System.out.println("Impossível depositar");
        }
    }

    public void sacar(int valor){
        if(this.getStatus() == true){
            if(this.getSaldo() >= valor){
                this.setSaldo(this.getSaldo() - valor);
            }
            else{
            System.out.println("Saldo insuficiente");
            }
        }
        else if(this.getStatus() == false){
            System.out.println("Impossível sacar");
        }
        
    }

    public void pegarMensal(){
        int valorMensal = 0;
        if(this.getTipo() == "CC"){
            valorMensal = 12;
        }
        else if (this.getTipo() == "CP"){
            valorMensal = 20;
        }
        if(this.getStatus() == true){
            if(this.getSaldo() > valorMensal){
                this.setSaldo(this.getSaldo() - valorMensal);
            }
            else if(this.getStatus() == false){
                System.out.println("Impossível pagar");
            }
        }
    }
}
