package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.service.PartidaService;


@RestController
@RequestMapping("/Partidas")
public class PartidaController {

    private PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }


    @PostMapping
    public ResponseEntity<PartidaDTO> save(@RequestBody PartidaDTO partidasDTO)
    {
        PartidaDTO response = partidaService.save(partidasDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
