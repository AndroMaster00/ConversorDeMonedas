package Clases;

public class Moneda {
    private String tipo;
    private double valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
