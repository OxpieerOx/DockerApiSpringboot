package ApiAnuncioAlbergue.controller;

import ApiAnuncioAlbergue.dto.Dto;
import ApiAnuncioAlbergue.dto.ErroresComunes;
import ApiAnuncioAlbergue.entity.AnuncioAlbergue;
import ApiAnuncioAlbergue.service.impl.AnuncioAlbergueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anuncioalbergue")
@Api(value = "Api Anuncio Albergue", description = "Api de los Anuncios Albergue", tags = {"Api  Anuncio Albergue"})
public class AnuncioAlbergueController {

    @Autowired
    private AnuncioAlbergueService anuncioalbergueDAO;




    @GetMapping("/listar")
    @ApiOperation(value = "Listar todas los anuncios albergues de la bd", notes = "Falta validad algunas cosas", tags = {"Api Anuncio Albergue"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = AnuncioAlbergue[].class),
            @ApiResponse(code = 401, message = "Unauthorized ejem", response = ErroresComunes.class),
            @ApiResponse(code = 403, message = "Forbidden ejem", response = ErroresComunes.class),
            @ApiResponse(code = 404, message = "Not found ejm", response = ErroresComunes.class),
            @ApiResponse(code = 500, message = "Server internal error ejem", response = ErroresComunes.class)
    })
    public ResponseEntity<List<AnuncioAlbergue>> listAll() {
        return new ResponseEntity<>(this.anuncioalbergueDAO.listarAnunciosAlbergue(), HttpStatus.OK);
    }

    @ApiOperation(value = "Buscar un anuncio espeficios en los albergues de la bd", notes = "Falta validad algunas cosas", tags = {"Api Anuncio Albergue"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = AnuncioAlbergue.class),
            @ApiResponse(code = 401, message = "Unauthorized ejem", response = ErroresComunes.class),
            @ApiResponse(code = 403, message = "Forbidden ejem", response = ErroresComunes.class),
            @ApiResponse(code = 404, message = "Not found ejm", response = ErroresComunes.class),
            @ApiResponse(code = 500, message = "Server internal error ejem", response = ErroresComunes.class)
    })
    @GetMapping("buscar/{idalbergue}")
    public ResponseEntity<AnuncioAlbergue> BuscarAnuncioAlbergue(@PathVariable("idalbergue")int idalbergue){
        return new ResponseEntity<>(this.anuncioalbergueDAO.retornarAnuncioAlbergue(idalbergue),HttpStatus.OK);
    }


    @ApiOperation(value = "Insetar un anuncio especifico en los albergues de la bd", notes = "Falta validad algunas cosas", tags = {"Api Anuncio Albergue"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = AnuncioAlbergue.class),
            @ApiResponse(code = 401, message = "Unauthorized ejem", response = ErroresComunes.class),
            @ApiResponse(code = 403, message = "Forbidden ejem", response = ErroresComunes.class),
            @ApiResponse(code = 404, message = "Not found ejm", response = ErroresComunes.class),
            @ApiResponse(code = 500, message = "Server internal error ejem", response = ErroresComunes.class)
    })
    @PostMapping("insertar")
    public ResponseEntity<AnuncioAlbergue> crearAnuncioAlbergue(@RequestBody AnuncioAlbergue anuncioAlbergue) throws Exception{
        AnuncioAlbergue insertaranuncioalbergue;
        insertaranuncioalbergue = anuncioalbergueDAO.guardarAnuncioAlbergue(anuncioAlbergue);
        if( insertaranuncioalbergue==null) {
            throw new Exception("No se ha podido guardar");
        }
        return ResponseEntity.ok(insertaranuncioalbergue);
    }


    @ApiOperation(value = "Edita un anuncio especifico en los albergues de la bd", notes = "Falta validad algunas cosas", tags = {"Api Anuncio Albergue"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = AnuncioAlbergue.class),
            @ApiResponse(code = 401, message = "Unauthorized ejem", response = ErroresComunes.class),
            @ApiResponse(code = 403, message = "Forbidden ejem", response = ErroresComunes.class),
            @ApiResponse(code = 404, message = "Not found ejm", response = ErroresComunes.class),
            @ApiResponse(code = 500, message = "Server internal error ejem", response = ErroresComunes.class)
    })
    @PutMapping("editar")
    public ResponseEntity<AnuncioAlbergue> editarAnuncioAlbergue(@RequestBody AnuncioAlbergue anuncioAlbergue) throws Exception{
        AnuncioAlbergue editarAlbergue ;

        int idalbergue = anuncioAlbergue.getIdAnunciosAlbergue();

        if(anuncioalbergueDAO.validarIDAlbergue(idalbergue)<=0) {
            throw new Exception("El Usuario no existe");
        }

        else {
           editarAlbergue = anuncioalbergueDAO.editarAnuncioAlbergue(anuncioAlbergue);
           return ResponseEntity.ok(editarAlbergue);
        }
    }


    @ApiOperation(value = "Elimina un anuncio especifico en los albergues de la bd", notes = "retornamos una clase que contendra los mensajes por que como es un put no elimina nada",
            tags = {"Api Anuncio Albergue"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Esto un 200 OK", response = Dto.class),
            @ApiResponse(code = 401, message = "Unauthorized ejem", response = ErroresComunes.class),
            @ApiResponse(code = 403, message = "Forbidden ejem", response = ErroresComunes.class),
            @ApiResponse(code = 404, message = "Not found ejm", response = ErroresComunes.class),
            @ApiResponse(code = 500, message = "Server internal error ejem", response = ErroresComunes.class)
    })
    @DeleteMapping("eliminar/{idalbergue}")
    public ResponseEntity<Dto> EliminarAnuncio(@PathVariable("idalbergue")int idalbergue){

        Dto dto= new Dto();
        anuncioalbergueDAO.eliminarAnuncio(idalbergue);
        dto.setMessage("Se elimino correctamente");
        return ResponseEntity.ok(dto);
    }


}




