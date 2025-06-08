package zave.molerodev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zave.molerodev.backend.entities.Ingreso;
import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.repository.IngresoRepository;

import java.util.List;

@Service
public class IngresoService_Impl implements IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    // Busca todos los ingresos de una cuenta
    @Override
    public List<Ingreso> findByCuenta(Cuenta cuenta) {
        return ingresoRepository.findByCuenta(cuenta);
    }
   
    // Guarda un ingreso nuevo o actualizado
    @Override
    public Ingreso save(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }
}
