package entities;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private Aluno aluno;
    private Semestre semestre;
    private List<Disciplina> disciplinas;

    public Matricula(Aluno aluno, Semestre semestre) {
        this.aluno = aluno;
        this.semestre = semestre;
        this.disciplinas = new ArrayList<>();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    public int contarObrigatorias() {
        return (int) disciplinas.stream().filter(Disciplina::isObrigatoria).count();
    }

    public int contarOptativas() {
        return (int) disciplinas.stream().filter(d -> !d.isObrigatoria()).count();
    }

    public void matricularEmDisciplina(Disciplina disciplina) {
        if (!semestre.isPeriodoMatriculaAberto()) {
            System.out.println("❌ Matrícula não permitida. Período de matrícula está fechado.");
            return;
        }

        if (disciplinas.contains(disciplina)) {
            System.out.println("⚠️ Já está matriculado nessa disciplina.");
            return;
        }

        disciplina.capacidadeMax();

        if (disciplina.isObrigatoria() && contarObrigatorias() >= 4) {
            System.out.println("❌ Limite de disciplinas obrigatórias atingido.");
            return;
        }

        if (!disciplina.isObrigatoria() && contarOptativas() >= 2) {
            System.out.println("❌ Limite de disciplinas optativas atingido.");
            return;
        }

        disciplina.addAluno(aluno);
        adicionarDisciplina(disciplina);
        System.out.println("✅ Matriculado com sucesso em " + disciplina.getNome());
    }

    public void cancelarMatricula(Disciplina disciplina) {
        if (!semestre.isPeriodoMatriculaAberto()) {
            System.out.println("❌ Cancelamento não permitido. Período de matrícula está fechado.");
            return;
        }

        if (!disciplinas.contains(disciplina)) {
            System.out.println("⚠️ Não está matriculado nessa disciplina.");
            return;
        }

        disciplina.removeAluno(aluno);
        removerDisciplina(disciplina);
        System.out.println("✅ Matrícula cancelada da disciplina " + disciplina.getNome());
    }
}

