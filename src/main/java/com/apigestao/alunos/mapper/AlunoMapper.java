package com.apigestao.alunos.mapper;

import com.apigestao.alunos.dto.AlunoRequest;
import com.apigestao.alunos.dto.AlunoResponse;
import com.apigestao.alunos.dto.MatriculaDTO;
import com.apigestao.alunos.model.Aluno;
import com.apigestao.alunos.model.Matricula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoMapper {

    public Aluno toEnttity(AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setTelefone(request.telefone());
        aluno.setDataNascimento(request.dataNascimento());
        List<Matricula> matriculas = request.matriculas().stream().map(m -> {

            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setDataInicio(m.dataInicio());
            matricula.setNomeCurso(m.nomeCurso());
            matricula.setAluno(aluno);
            return matricula;

        }).toList();
        aluno.setMatriculas(matriculas);

        return aluno;
    }

    public AlunoResponse toResponse(Aluno aluno){
        List<MatriculaDTO> matriculaDTOS = aluno.getMatriculas().stream().map(m ->
            new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getTelefone(), aluno.getDataNascimento(), matriculaDTOS);
    }
}
