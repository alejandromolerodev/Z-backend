package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Gasto;

public interface GastoService {
    
    List<Gasto> findByCuenta(Cuenta cuenta);

    Gasto save(Gasto gasto);

}
