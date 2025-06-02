package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Ingreso;

public interface IngresoService {

    List<Ingreso> findByCuenta(Cuenta cuenta);
    Ingreso save(Ingreso ingreso);
}
