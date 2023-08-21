package api.service.plano;

import api.dto.plano.PlanoDto;
import api.domain.plano.Plano;
import api.repository.PlanoRepository;
import api.dto.plano.PlanoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoServiceImpl implements PlanoService {
    @Autowired
    private PlanoRepository planoRepository;

    @Override
    public Plano criar(PlanoDto planoDto) {
        return planoRepository.save(PlanoMapper.to(planoDto));
    }

    @Override
    public List<Plano> listar() {
        List<Plano> listaPlanos = planoRepository.findAll();
        if (listaPlanos.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return listaPlanos;
    }

    @Override
    public Optional<Plano> buscarPlanoPorId(Long id) {
        if (planoRepository.existsById(id)) {
            return planoRepository.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Plano com o ID %d não foi encontrado.", id));
    }

    @Override
    public Void deletar(Long id) {
        if (planoRepository.existsById(id)) {
            planoRepository.deleteById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Plano com o ID %d não foi encontrado.", id));
    }
}