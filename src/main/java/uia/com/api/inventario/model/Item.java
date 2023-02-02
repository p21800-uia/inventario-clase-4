package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;


@Node("Item")
public class Item {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("partida")
    private String partida;
    @Property("subpartida")
    private String subpartida;
    @Property("categoria")
    private String categoria;
    @Property("estatus")
    private String estatus;
    private String nameProveedor;


    public Item(String id, String name, String partida, String subpartida, String categoria,
                String estatus, String nameProveedor)
    {
        this.id = id;
        this.name = name;
        this.estatus = categoria;
        this.partida = partida;
        this.subpartida = subpartida;
        this.categoria = categoria;
        this.nameProveedor = nameProveedor;


        //MiNeo4JDriver.neo4jClient.query();
        //this.proveedor = proveedor;

        String ubicP = String.valueOf(Integer.parseInt(partida)/100);
        char ubicS = (char) (65 + (Integer.parseInt(subpartida)/100)/10);
        String ubicC = String.valueOf((Integer.parseInt(categoria)-Integer.parseInt(subpartida)));
    }



    public Item() {
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

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getSubpartida() {
        return subpartida;
    }

    public void setSubpartida(String subpartida) {
        this.subpartida = subpartida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


    public String getNameProveedor() {
        return nameProveedor;
    }

    public void setNameProveedor(String nameProveedor) {
        this.nameProveedor = nameProveedor;
    }
}
