package entities;

public class Semestre {
    private String identificador; // Ex: "2025.1", "2025.2"
    private boolean periodoMatriculaAberto;

    public Semestre(String identificador) {
        this.identificador = identificador;
        this.periodoMatriculaAberto = false; 
    }

    public String getIdentificador() {
        return identificador;
    }

    public boolean isPeriodoMatriculaAberto() {
        return periodoMatriculaAberto;
    }

    public void abrirPeriodoMatricula() {
        this.periodoMatriculaAberto = true;
    }

    public void fecharPeriodoMatricula() {
        this.periodoMatriculaAberto = false;
    }
    @Override
    public String toString() {
        return identificador;
    }
}