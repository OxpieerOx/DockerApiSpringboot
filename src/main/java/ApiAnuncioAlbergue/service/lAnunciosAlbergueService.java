package ApiAnuncioAlbergue.service;

import ApiAnuncioAlbergue.entity.AnuncioAlbergue;

import java.util.List;

public interface lAnunciosAlbergueService {
    public List<AnuncioAlbergue> listarAnunciosAlbergue();
    public AnuncioAlbergue retornarAnuncioAlbergue(int idalbergue);
    public AnuncioAlbergue guardarAnuncioAlbergue(AnuncioAlbergue anuncio);
    public AnuncioAlbergue editarAnuncioAlbergue(AnuncioAlbergue anuncio);
    public void eliminarAnuncio(int idalbergue);
    public int validarIDAlbergue(int idalbergue);
}
