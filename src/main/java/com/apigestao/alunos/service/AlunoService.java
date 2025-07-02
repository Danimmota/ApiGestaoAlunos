package com.apigestao.alunos.service;

import com.apigestao.alunos.dto.AlunoRequest;
import com.apigestao.alunos.dto.AlunoResponse;
import com.apigestao.alunos.dto.MatriculaDTO;
import com.apigestao.alunos.mapper.AlunoMapper;
import com.apigestao.alunos.model.Aluno;
import com.apigestao.alunos.model.Matricula;
import com.apigestao.alunos.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponse salvar(AlunoRequest request) {
        Aluno aluno = alunoMapper.toEnttity(request);
        alunoRepository.save(aluno);
        return alunoMapper.toResponse(aluno);
    }

    public List<AlunoResponse> listarTodos() {
        return alunoRepository.findAll().stream().map(alunoMapper::toResponse).toList();
    }

    public List<MatriculaDTO> listarMatriculas(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado na base de dados."));
        return aluno.getMatriculas().stream().map(m -> new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
    }

    public void removerAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado pelo ID.");
        }
        alunoRepository.deleteById(id);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado na base de dados."));
        aluno.setNome(request.nome());
        aluno.setTelefone(request.telefone());
        aluno.setDataNascimento(request.dataNascimento());

        for (MatriculaDTO matriculaDTO : request.matriculas()) {
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(matriculaDTO.codigoMatricula());
            matricula.setDataInicio(matriculaDTO.dataInicio());
            matricula.setNomeCurso(matriculaDTO.nomeCurso());
            aluno.getMatriculas().add(matricula);
        }
        return alunoMapper.toResponse(alunoRepository.save(aluno));
    }

}
