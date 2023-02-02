package uia.com.api.inventario.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.mapper.ApiMapperPartida;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.Lote;
import uia.com.api.inventario.model.Partida;
import uia.com.api.inventario.model.Subpartida;
import uia.com.api.inventario.repository.ItemRepository;
import uia.com.api.inventario.repository.LoteRepository;
import uia.com.api.inventario.repository.PartidaRepository;
import uia.com.api.inventario.repository.SubpartidaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PartidaService {
    PartidaRepository repositoryPartidas;
    SubpartidaRepository repositorySubpartidas;
    LoteRepository repositoryLote;
    ItemRepository repositoryItem;

    Validator validator;

    @Autowired
    public PartidaService(PartidaRepository repositoryPartidas,
                          LoteRepository repositoryLote,
                          ItemRepository repositoryItem,
                          SubpartidaRepository repositorySubpartida,
                          Validator validator) {
        this.repositoryPartidas = repositoryPartidas;
        this.repositoryLote = repositoryLote;
        this.repositoryItem = repositoryItem;
        this.repositorySubpartidas = repositorySubpartida;
        this.validator = validator;
    }
    public PartidaDTO save(PartidaDTO partida)
    {
        return saveInformation(partida);
    }

    public PartidaDTO update(PartidaDTO partida) {
        return saveInformation(partida);
    }

    private PartidaDTO saveInformation(PartidaDTO partidasDTO)
    {
        PartidaDTO partidas_salvados = new PartidaDTO();

        if(partidasDTO.getPartidas().size() > 0)
        {
            for (int i = 0; i < partidasDTO.getPartidas().size(); i++)
            {
                String id = partidasDTO.getPartidas().get(i).getId();

                if(!this.repositoryPartidas.existsById(id))
                {
                    Partida entityPartida = ApiMapperPartida.INSTANCE.DTOToEntity(partidasDTO.getPartidas().get(i));
                    entityPartida.setId(id);
                    String idLote = entityPartida.getNameLote();

                    if (this.repositoryLote.existsById(idLote)) {
                        agregaLote(entityPartida);
                    }

                    if (!this.repositorySubpartidas.existsById(entityPartida.getNameSubpartida())) {
                        agregaSubpartida(entityPartida);
                    }

                    int numItems = Integer.parseInt(entityPartida.getCantidad());
                    for (int j = 0; j < numItems; j++) {
                        agregaItem(entityPartida, j);
                    }
                    partidas_salvados.getPartidas().add(ApiMapperPartida.INSTANCE.entityToDTO(this.agregaPartida(entityPartida)));
                }
                else
                {
                    Optional<Partida> entityPartida =  this.repositoryPartidas.findById(id);

                        if (!this.repositorySubpartidas.existsById(entityPartida.get().getNameSubpartida())) {
                            agregaSubpartida(entityPartida.get());
                        }

                    //-- se asigna el lote encontrado
                        if (!entityPartida.isEmpty()) {
                            this.agregaLote(entityPartida.get());
                        }

                        int numItems = Integer.parseInt(entityPartida.get().getCantidad());
                        for (int j = 0; j < numItems; j++)
                        {
                                agregaItem(entityPartida.get(), j);
                        }
                        partidas_salvados.getPartidas().add(ApiMapperPartida.INSTANCE.entityToDTO(this.agregaPartida(entityPartida.get())));
                    }
                }

                //embalajes.get(0).getPartidas().add(entityPartida);  //--usado para la relacion de regreso
                //this.repositoryLote.save(embalajes.get(0));   //--usado para la relacion de regreso

            }

        return partidas_salvados;

    }

    private void agregaSubpartida(Partida entityPartida)
    {
        String id = entityPartida.getNameSubpartida();

        if (!this.repositorySubpartidas.existsById(id))
        {
            Subpartida subpartida = new Subpartida(id, id, entityPartida.getIdSubpartida(), entityPartida.getEstatus(),"Subpartidas", "02-02-2023", "No definido");
            Set<ConstraintViolation<Subpartida>> violations = validator.validate(subpartida);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            repositorySubpartidas.save(subpartida);
            entityPartida.getSubpartidas().add(subpartida);
        }

    }

    private Partida agregaPartida(Partida entityPartida)
    {
        Set<ConstraintViolation<Partida>> violations2 = validator.validate(entityPartida);
        if (!violations2.isEmpty()) {
            throw new ConstraintViolationException(violations2);
        }
        Partida savedEntity = repositoryPartidas.save(entityPartida);
        return savedEntity;
    }

    public void agregaLote(Partida entityPartida)
    {
        String id = entityPartida.getNameLote();

        if (!this.repositoryLote.existsById(id))
        {
            Lote lote = new Lote(id, id, entityPartida.getDescripcion(), entityPartida.getEstatus(),"Lote", "02-02-2023", "No definido");
            Set<ConstraintViolation<Lote>> violations = validator.validate(lote);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            repositoryLote.save(lote);
        }
    }

    public void agregaItem(Partida entityPartida, int j)
    {
        String name = entityPartida.getNameLote() + "-" + entityPartida.getIdCategoria() + "-" + j;
        if (!this.repositoryItem.existsById(name))
        {
            Item item = new Item(name, name,
                    entityPartida.getIdPartida(), entityPartida.getIdSubpartida(), entityPartida.getIdCategoria(),
                    "disponible", "No definido");

            Set<ConstraintViolation<Item>> violations = validator.validate(item);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            repositoryItem.save(item);
            entityPartida.getItems().add(item);
            System.out.println("Item agregado:" + item.getName());
        }

    }

    public void agregaItemSubpartida(Partida entityPartida, Subpartida entitySubpartida, int j)
    {
        String name = entityPartida.getNameLote() + "-" + entityPartida.getIdCategoria() + "-" + j;
        if (!this.repositoryItem.existsById(name))
        {
            Item item = new Item(name, name,
                    entityPartida.getIdPartida(), entityPartida.getIdSubpartida(), entityPartida.getIdCategoria(),
                    "disponible", "No definido");

            Set<ConstraintViolation<Item>> violations = validator.validate(item);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            repositoryItem.save(item);
            entityPartida.getItems().add(item);
            System.out.println("Item agregado:" + item.getName());
            entitySubpartida.getItems().add(item);
        }
        else
        {
            Optional<Item> item =  this.repositoryItem.findById(name);
            entitySubpartida.getItems().add(item.get());
        }

    }
}
