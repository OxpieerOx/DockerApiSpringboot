package ApiAnuncioAlbergue.repository;


import ApiAnuncioAlbergue.entity.AnuncioAlbergue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AnuncioAlbergueRepository extends JpaRepository<AnuncioAlbergue,Integer> {

    @Query(nativeQuery = true,value ="SELECT COUNT(*) FROM tb_anuncios_albergue WHERE id_anuncios_albergue=:idalbergue")
    public int validarIdAlbergue(@Param("idalbergue")int idalbergue);

}