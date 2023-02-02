package uia.com.api.inventario.model;


import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;


@Node("Embalaje")
public class Embalaje extends InfoItem {
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    @Property("descripcion")
    private String descripcion;
    @Relationship(type = "pertenece_a")
    private List<Lote> lotes;

    public Embalaje(String id, String name, String descripcion, String estatus, String clase)
    {
        super(-1, -1);
        this.name = name;
        this.id = id;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
        this.lotes  = new ArrayList<Lote>();
    }

    public Embalaje() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
