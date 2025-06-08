package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Gasto;
import zave.molerodev.backend.entities.Ingreso;

public interface CuentaService {
    // Busca una cuenta por su ID
    Cuenta findById(Long cuentaId);

    // Busca todas las cuentas de un usuario por su ID
    List<Cuenta> findByUserId(Long userId);

    // Obtiene todos los gastos de una cuenta
    List<Gasto> findGastosByCuenta(Cuenta cuenta);

    // Obtiene todos los ingresos de una cuenta
    List<Ingreso> findIngresosByCuenta(Cuenta cuenta);

    // Elimina una cuenta por su ID
    void deleteById(Long cuentaId);

    // Guarda una cuenta nueva o actualizada
    Cuenta save(Cuenta cuenta);
}
