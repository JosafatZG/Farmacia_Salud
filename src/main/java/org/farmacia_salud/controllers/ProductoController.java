package org.farmacia_salud.controllers;

import org.farmacia_salud.models.entity.Movimiento;
import org.farmacia_salud.models.entity.Producto;
import org.farmacia_salud.models.services.interfaces.IMovimientoService;
import org.farmacia_salud.models.services.interfaces.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ProductoController {

    private final IProductoService service;
    private final IMovimientoService movimientoService;

    public ProductoController(IProductoService service, IMovimientoService movimientoService) {
        this.service = service;
        this.movimientoService = movimientoService;
    }

    @GetMapping("/productos")
    public String tablaProductos(Model model){
        model.addAttribute("productoAdd", new Producto());
        model.addAttribute("productos", service.findAll());
        return "productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarEditarProducto(@PathVariable Long id, Model model){
        Optional<Producto> productoOptional = service.findById(id);
        if (productoOptional.isPresent()){
            model.addAttribute("producto", productoOptional.get());
            return "editar_producto";
        }
        else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos")
    public String agregarProducto(@ModelAttribute("productoAdd") Producto producto){
        producto.setStock(0);
        service.save(producto);
        return "redirect:/productos";
    }

    @PostMapping("/productos/{id}")
    public String editarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto){
        Optional<Producto> productoOptional = service.findById(id);
        if (productoOptional.isPresent()){
            Producto productoExistente = productoOptional.get();
            System.out.println(producto.getStock());
            System.out.println(productoExistente.getStock());
            Integer diferencia = producto.getStock() - productoExistente.getStock();
            System.out.println(diferencia);

            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecioDeCompra(producto.getPrecioDeCompra());
            productoExistente.setPrecioDeVenta(producto.getPrecioDeVenta());
            productoExistente.setStock(producto.getStock());

            service.save(productoExistente);
            if (diferencia != 0){

                Movimiento movimiento = new Movimiento();
                movimiento.setProducto(productoExistente);
                movimiento.setCantidad(diferencia);
                movimiento.setFecha(LocalDate.now());
                movimiento.setTipoMovimiento("Ajuste");

                movimientoService.save(movimiento);
            }
        }
        return "redirect:/productos";
    }
}
