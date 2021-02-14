package es.urjc.code.repositories;

import es.urjc.code.dtos.ComunidadesNumProvincias;
import es.urjc.code.entities.Provincia;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repositorio MongoDB Provincia.
 *
 * @author Miguel G. Sanguino
 */
public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

    @Aggregation(pipeline = {
            "{$project: {Comunidad: { $ifNull: [ \"$CA\", \"sin comunidad\" ] }}}",
            "{$group:{\"_id\":\"$Comunidad\", \"numeroProvincias\":{$sum:1}}}",
            "{$project:{comunidad:\"$_id\",numeroProvincias: 1,_id:false} }"
    })
    List<ComunidadesNumProvincias> proviciasNumPorComunidad();
}
