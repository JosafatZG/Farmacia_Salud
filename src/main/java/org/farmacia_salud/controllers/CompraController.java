package org.farmacia_salud.controllers;

import jakarta.validation.Valid;
import org.farmacia_salud.models.dto.CompraDTO;
import org.farmacia_salud.models.entity.Compra;
import org.farmacia_salud.models.entity.Movimiento;
import org.farmacia_salud.models.entity.Producto;
import org.farmacia_salud.models.entity.Proveedor;
import org.farmacia_salud.models.services.interfaces.ICompraService;
import org.farmacia_salud.models.services.interfaces.IMovimientoService;
import org.farmacia_salud.models.services.interfaces.IProductoService;
import org.farmacia_salud.models.services.interfaces.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CompraController {
    private final ICompraService service;
    private final IProductoService productoService;
    private final IProveedorService proveedorService;
    private final IMovimientoService movimientoService;

    public CompraController(ICompraService service, IProductoService productoService, IProveedorService proveedorService, IMovimientoService movimientoService) {
        this.service = service;
        this.productoService = productoService;
        this.proveedorService = proveedorService;
        this.movimientoService = movimientoService;
    }

    @GetMapping("/compras")
    public String tablaCompras(Model model) {
        model.addAttribute("compraAdd", new CompraDTO());
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("proveedores", proveedorService.findAll());
        model.addAttribute("compras", service.findAll());
        return "compras";
    }

    @PostMapping("/compras")
    public String agregarCompra(@ModelAttribute("compraAdd") CompraDTO compraDTO) {
        Compra compra = new Compra();
        Optional<Producto> productoOptional = productoService.findById(compraDTO.getProductoId());
        Optional<Proveedor> proveedorOptional = proveedorService.findById(compraDTO.getProveedorId());
        if (productoOptional.isPresent() && proveedorOptional.isPresent()) {
            Producto producto = productoOptional.get();
            Proveedor proveedor = proveedorOptional.get();

            Integer newStock = producto.getStock() + compraDTO.getCantidad();
            producto.setStock(newStock);

            compra.setProducto(producto);
            compra.setProveedor(proveedor);
            compra.setCantidad(compraDTO.getCantidad());
            compra.setFecha(compraDTO.getFecha());

            Movimiento movimiento = new Movimiento();
            movimiento.setProducto(producto);
            movimiento.setCantidad(compraDTO.getCantidad());
            movimiento.setFecha(compraDTO.getFecha());
            movimiento.setTipoMovimiento("Compra");

            productoService.save(producto);
            service.save(compra);
            movimientoService.save(movimiento);
        }


        return "redirect:/compras";
    }
}
