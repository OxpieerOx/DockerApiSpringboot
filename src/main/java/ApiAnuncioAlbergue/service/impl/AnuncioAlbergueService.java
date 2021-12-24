package ApiAnuncioAlbergue.service.impl;

import ApiAnuncioAlbergue.entity.AnuncioAlbergue;
import ApiAnuncioAlbergue.repository.AnuncioAlbergueRepository;
import ApiAnuncioAlbergue.service.lAnunciosAlbergueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioAlbergueService implements lAnunciosAlbergueService {

    @Autowired
    AnuncioAlbergueRepository anuncioalbergueDAO;

    @Override
    public List<AnuncioAlbergue> listarAnunciosAlbergue() {
        return this.anuncioalbergueDAO.findAll();
    }

    @Override
    public AnuncioAlbergue retornarAnuncioAlbergue(int idalbergue) {
        return this.anuncioalbergueDAO.getById(idalbergue);
    }

    @Override
    public AnuncioAlbergue guardarAnuncioAlbergue(AnuncioAlbergue anuncio) {
        return this.anuncioalbergueDAO.save(anuncio);
    }

    @Override
    public AnuncioAlbergue editarAnuncioAlbergue(AnuncioAlbergue anuncio) {
        return this.anuncioalbergueDAO.save(anuncio);
    }

    @Override
    public void eliminarAnuncio(int idalbergue) {
        this.anuncioalbergueDAO.deleteById(idalbergue);
    }

    @Override
    public int validarIDAlbergue(int idalbergue) {
        return this.anuncioalbergueDAO.validarIdAlbergue(idalbergue);
    }
}
