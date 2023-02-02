package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;


@Node("Subpartida")
public class Subpartida {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    @Property("descripcion")
    private String descripcion;
    //@Relationship(type = "CONTIENE")
    //private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    @Relationship(type = "AGREGADO")
    private ArrayList<Item> items = new ArrayList<Item>();

    public Subpartida(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameEmbalaje)
    {
        this.id = id;
        this.name = name;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
    }

    public Subpartida() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /*
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

     */

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
