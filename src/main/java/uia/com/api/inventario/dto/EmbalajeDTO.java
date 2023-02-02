package uia.com.api.inventario.dto;


import java.util.ArrayList;
import java.util.List;


public class EmbalajeDTO {
        private String id;
        private String name;
        private String descripcion;
        private String estatus;
        private String clase;
        //private List<Lote> lotes = new ArrayList<Lote>();

        public EmbalajeDTO() {
        }

        public EmbalajeDTO(String id, String name, String descripcion, String estatus, String clase) {
            this.id = name;
            this.name = name;
            this.descripcion = descripcion;
            this.estatus = estatus;
            this.clase = clase;
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

}
