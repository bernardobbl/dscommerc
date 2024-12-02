package com.devbernardob.dscommerc.consulta.resource;

import com.devbernardob.dscommerc.consulta.domain.Consulta;
import com.devbernardob.dscommerc.consulta.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/consultas")
public class ConsultaResource {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta){
        // Jeito do professor
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);

        // Meu jeito
//        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    }


    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsulta(@RequestBody Consulta consulta){
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.ok().body(consultaService.listarConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id){
        Consulta consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Long id){
        consulta.setIdConsulta(id);
        Consulta consultaAtualiza = consultaService.atualizarConsulta(consulta);
        return ResponseEntity.ok().body(consultaAtualiza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id){
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}