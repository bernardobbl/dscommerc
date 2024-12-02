package com.devbernardob.dscommerc.consulta.domain;

import com.devbernardob.dscommerc.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;
    @Column(name = "DATA_CONSULTA")
    private Date dataConsulta;
    @Column(name = "ESPECIALIDADE")
    private String especialidade;
    @Column(name = "PROFISSIONAL")
    private String profissional;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

}