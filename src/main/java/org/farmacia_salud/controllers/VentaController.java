package org.farmacia_salud.controllers;

import org.farmacia_salud.models.dto.VentaDTO;
import org.farmacia_salud.models.entity.Movimiento;
import org.farmacia_salud.models.entity.Producto;
import org.farmacia_salud.models.entity.Venta;
import org.farmacia_salud.models.services.interfaces.IMovimientoService;
import org.farmacia_salud.models.services.interfaces.IProductoService;
import org.farmacia_salud.models.services.interfaces.IVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class VentaController {
    private final IVentaService service;
    private final IProductoService productoService;
    private final IMovimientoService movimientoService;

    public VentaController(IVentaService service, IProductoService productoService, IMovimientoService movimientoService) {
        this.service = service;
        this.productoService = productoService;
        this.movimientoService = movimientoService;
    }

    @GetMapping("/ventas")
    public String tablaVentas(Model model){
        model.addAttribute("ventaAdd", new VentaDTO());
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("ventas", service.findAll());
        return "ventas";
    }

    @PostMapping("/ventas")
    public String agregarVenta(@ModelAttribute("ventaAdd") VentaDTO ventaDTO){
        Venta venta = new Venta();
        Optional<Producto> productoOptional = productoService.findById(ventaDTO.getProductoId());
        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            int newStock = producto.getStock() - ventaDTO.getCantidad();
            if (newStock >= 0){
                producto.setStock(newStock);
                venta.setProducto(producto);
                venta.setCantidad(ventaDTO.getCantidad() * -1);
                venta.setFecha(ventaDTO.getFecha());

                Movimiento movimiento = new Movimiento();
                movimiento.setProducto(producto);
                movimiento.setCantidad(ventaDTO.getCantidad() * - 1);
                movimiento.setFecha(ventaDTO.getFecha());
                movimiento.setTipoMovimiento("Venta");

                productoService.save(producto);
                service.save(venta);
                movimientoService.save(movimiento);
            }
        }
        return "redirect:/ventas";
    }
}