package zave.molerodev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import zave.molerodev.backend.entities.Cuenta;
import zave.molerodev.backend.entities.Ingreso;
import zave.molerodev.backend.entities.Usuario;
import zave.molerodev.backend.entities.Gasto;
import zave.molerodev.backend.service.IngresoService;
import zave.molerodev.backend.service.UserService;
import zave.molerodev.backend.service.CuentaService;
import zave.molerodev.backend.service.GastoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/zave/cuenta")
@CrossOrigin(origins = "*")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private GastoService gastoService;

    @Autowired
    private UserService userService;

    // Obtener todos los ingresos de una cuenta específica
    @GetMapping("/ingresos/{cuentaId}")
    public ResponseEntity<List<Ingreso>> getIngresosDeCuenta(@PathVariable Long cuentaId) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        List<Ingreso> ingresos = ingresoService.findByCuenta(cuenta);
        return ResponseEntity.ok(ingresos);
    }

    // Obtener todos los gastos de una cuenta específica
    @GetMapping("/gastos/{cuentaId}")
    public ResponseEntity<List<Gasto>> getGastosDeCuenta(@PathVariable Long cuentaId) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        List<Gasto> gastos = gastoService.findByCuenta(cuenta);
        return ResponseEntity.ok(gastos);
    }

    // Obtener el saldo de una cuenta específica
    @GetMapping("/saldo/{cuentaId}")
    public ResponseEntity<BigDecimal> getSaldoDeCuenta(@PathVariable Long cuentaId) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        BigDecimal saldo = cuenta.getSaldo();
        return ResponseEntity.ok(saldo);
    }

    // Agregar un ingreso a una cuenta y actualizar el saldo
    @PostMapping("/ingresos/{cuentaId}")
    public ResponseEntity<Ingreso> agregarIngreso(
            @PathVariable Long cuentaId, @RequestBody Ingreso ingreso) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        ingreso.setCuenta(cuenta); // Asocia el ingreso a la cuenta
        cuenta.setSaldo(cuenta.getSaldo().add(ingreso.getImporte())); // Suma el importe al saldo
        cuentaService.save(cuenta); // Guarda el nuevo saldo
        Ingreso nuevoIngreso = ingresoService.save(ingreso);
        return ResponseEntity.ok(nuevoIngreso);
    }

    // Agregar un gasto a una cuenta y actualizar el saldo
    @PostMapping("/gastos/{cuentaId}")
    public ResponseEntity<Gasto> agregarGasto(
            @PathVariable Long cuentaId, @RequestBody Gasto gasto) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        gasto.setCuenta(cuenta); // Asocia el gasto a la cuenta
        cuenta.setSaldo(cuenta.getSaldo().subtract(gasto.getImporte())); // Resta el importe al saldo
        Gasto nuevoGasto = gastoService.save(gasto);
        return ResponseEntity.ok(nuevoGasto);
    }

    // Crear una nueva cuenta para un usuario
    @PostMapping("/usuario/{userId}")
    public ResponseEntity<Cuenta> crearCuenta(@PathVariable Long userId, @RequestBody Cuenta cuenta) {
        Usuario usuario = userService.findById(userId);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        cuenta.setUsuario(usuario); // Asocia la cuenta al usuario
        Cuenta nuevaCuenta = cuentaService.save(cuenta); // Guarda la cuenta
        return ResponseEntity.ok(nuevaCuenta);
    }

    // Obtener todas las cuentas de un usuario
    @GetMapping("/cuentas/{userId}")
    public ResponseEntity<List<Cuenta>> obtenerCuentasPorUsuario(@PathVariable Long userId) {
        Usuario usuario = userService.findById(userId);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        List<Cuenta> cuentas = cuentaService.findByUserId(userId);
        return ResponseEntity.ok(cuentas);
    }

    // Eliminar una cuenta por su ID
    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long cuentaId) {
        Cuenta cuenta = cuentaService.findById(cuentaId);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        cuentaService.deleteById(cuentaId);
        return ResponseEntity.noContent().build();
    }

    // Actualizar los datos de una cuenta existente
    @PutMapping("/{cuentaId}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long cuentaId, @RequestBody Cuenta cuentaActualizada) {
        Cuenta cuentaExistente = cuentaService.findById(cuentaId);
        if (cuentaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        cuentaExistente.setNombre(cuentaActualizada.getNombre());
        cuentaExistente.setTipo(cuentaActualizada.getTipo());
        cuentaExistente.setSaldo(cuentaActualizada.getSaldo());
        Cuenta cuentaGuardada = cuentaService.save(cuentaExistente);
        return ResponseEntity.ok(cuentaGuardada);
    }
}
