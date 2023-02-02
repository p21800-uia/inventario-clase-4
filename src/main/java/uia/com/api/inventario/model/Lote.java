package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;


@Node("Lote")
public class Lote {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    //@Property("partida")
    //private Partida partida = new Partida();
    //@Property("subpartida")
    //private Subpartida subpartida = new Subpartida();
    //@Property("categoria")
    //private Categoria categoria= new Categoria();
    @Property("descripcion")
    private String descripcion;
    @Property("fechaIngreso")
    private String fechaIngreso;
    private String namePartida;
    private String nameSubpartida;
    private String nameCategoria;
    private String nameEmbalaje;
    @Relationship(type = "EMPACADO_CON")
    private Embalaje embalaje;

    public Lote(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameEmbalaje)
    {
        this.name = name;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.nameEmbalaje = nameEmbalaje;
        this.id = id;
    }

    public Lote() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNamePartida() {
        return namePartida;
    }

    public void setNamePartida(String namePartida) {
        this.namePartida = namePartida;
    }

    public String getNameSubpartida() {
        return nameSubpartida;
    }

    public void setNameSubpartida(String nameSubpartida) {
        this.nameSubpartida = nameSubpartida;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Embalaje getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Embalaje embalaje) {
        this.embalaje = embalaje;
    }

    public String getNameEmbalaje() {
        return nameEmbalaje;
    }

    public void setNameEmbalaje(String nameEmbalaje) {
        this.nameEmbalaje = nameEmbalaje;
    }


}
