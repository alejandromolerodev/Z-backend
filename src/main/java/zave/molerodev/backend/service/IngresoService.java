package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Ingreso;

public interface IngresoService {

    // Busca todos los ingresos de una cuenta
    List<Ingreso> findByCuenta(Cuenta cuenta);

    // Guarda un ingreso nuevo o actualizado
    Ingreso save(Ingreso ingreso);
}
