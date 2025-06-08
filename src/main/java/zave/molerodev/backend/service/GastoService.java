package zave.molerodev.backend.service;

import java.util.List;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Gasto;

public interface GastoService {
    // Busca todos los gastos de una cuenta
    List<Gasto> findByCuenta(Cuenta cuenta);

    // Guarda un gasto nuevo o actualizado
    Gasto save(Gasto gasto);
}
