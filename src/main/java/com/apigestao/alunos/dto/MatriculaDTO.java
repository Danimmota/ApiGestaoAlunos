package com.apigestao.alunos.dto;

import java.time.LocalDate;

public record MatriculaDTO(String codigoMatricula, String nomeCurso, LocalDate dataInicio) {
}
