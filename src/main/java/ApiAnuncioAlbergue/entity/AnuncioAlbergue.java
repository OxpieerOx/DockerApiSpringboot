package ApiAnuncioAlbergue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "tb_anuncios_albergue")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class AnuncioAlbergue {
    @Id
    @Column(name="idAnunciosAlbergue")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAnunciosAlbergue;

    @Column(name = "ANUN_AL_DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "ANUN_AL_DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "ANUN_AL_FECHA", nullable = false, length = 50)
    private String fecha;

    @Column(name = "ANUN_AL_TELEFONO", nullable = false, length = 50)
    private String telefono;


}