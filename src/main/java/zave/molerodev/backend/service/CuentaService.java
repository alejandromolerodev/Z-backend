package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Gasto;
import zave.molerodev.backend.entities.Ingreso;

public interface CuentaService {
    Cuenta findById(Long cuentaId);
    List<Cuenta> findByUserId(Long userId);
    List<Gasto> findGastosByCuenta(Cuenta cuenta);
    List<Ingreso> findIngresosByCuenta(Cuenta cuenta);
    void deleteById(Long cuentaId);
    Cuenta save(Cuenta cuenta);
}
