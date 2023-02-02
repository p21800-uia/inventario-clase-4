package uia.com.api.inventario.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.*;


@Node("InfoItem")
public  class InfoItem {
    @Id
    public String id;
    @Property("minimoNivel")
    private int minimoNivel = -1;
    @Property("cantidadEntregada")
    private int cantidadEntrega = -1;


    public InfoItem(int cantidadEntrega, int minimoNivel)
    {
        this.minimoNivel=minimoNivel;
        this.cantidadEntrega = cantidadEntrega;
    }

    public InfoItem() {
    }


    public int getMinimoNivel() {
        return minimoNivel;
    }

    public void setMinimoNivel(int minimoNivel) {
        this.minimoNivel = minimoNivel;
    }

    public int getCantidadEntrega() {
        return cantidadEntrega;
    }

    public void setCantidadEntrega(int cantidadEntrega) {
        this.cantidadEntrega = cantidadEntrega;
    }
}
