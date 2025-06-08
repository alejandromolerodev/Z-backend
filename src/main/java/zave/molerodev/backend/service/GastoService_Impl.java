package zave.molerodev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zave.molerodev.backend.entities.Gasto;
import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.repository.GastoRepository;

import java.util.List;

@Service
public class GastoService_Impl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    // Busca todos los gastos de una cuenta
    @Override
    public List<Gasto> findByCuenta(Cuenta cuenta) {
        return gastoRepository.findByCuenta(cuenta);
    }
   
    // Guarda un gasto nuevo o actualizado
    @Override
    public Gasto save(Gasto gasto) {
        return gastoRepository.save(gasto);
    }
}
