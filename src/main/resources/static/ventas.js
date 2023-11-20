let ventas = [];
let editingIndex = -1;
function addVentas() {
    const ventaId = document.getElementById("ventaId").value;
    const Fecha = document.getElementById("Fecha").value;
    const Cantidad = document.getElementById("Cantidad").value;
    const ventasPriceshop = document.getElementById("ventasPriceshop").value;
    const ventasPrice = document.getElementById("ventasPrice").value;

    if (!ventaId || !Fecha || !Cantidad || !ventasPriceshop || !ventasPrice) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const newVentas= {
        id: ventaId,
        fecha: Fecha,
        cant: parseInt(Cantidad),
        unitario: parseFloat(ventasPriceshop),
        total: parseFloat(ventasPrice)
    };
    if (editingIndex === -1) {
        // Agregar nuevo ventao
        ventas.push(newventa);
    } else {
        // Actualizar ventao existente
        ventas[editingIndex] = newventa;
        editingIndex = -1;
    }
    updateVentasTable();
   clearForm();
}

function deleteVentas(index) {
    ventas.splice(index, 1);
    updateventaTable();
}

function updateVentasTable() {
    const ventaList = document.getElementById("ventaList");

    ventaList.innerHTML = "";

    ventas.forEach((venta, index) => {
        const row = ventaList.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        const cell5 = row.insertCell(3);
        const cell6 = row.insertCell(3);

        cell1.innerHTML = venta.id;
        cell2.innerHTML = venta.fecha;
        cell3.innerHTML = venta.cant;
        cell4.innerHTML = `$${venta.unitario.toFixed(2)}`;
        cell5.innerHTML = `$${venta.unitario.toFixed(2)}`;
        cell6.innerHTML =   `<button onclick="editventa(${index})">Editar</button>
                           <button onclick="deleteventa(${index})">Eliminar</button>`;
    });
}

function editVentas(index) {
    const venta = ventas[index];
    document.getElementById("ventaId").value = venta.id;
    document.getElementById("Fecha").value = venta.fecha;
    document.getElementById("Cantidad").value = venta.cant;
    document.getElementById("ventasPriceshop").value = venta.unitario;
    document.getElementById("ventasPrice").value = venta.total;
    const addButton = document.getElementById("addButton");
    addButton.textContent = "Actualizar ventas";
    editingIndex = index;
}
function clearForm() {
    document.getElementById("ventaForm").reset();
    document.getElementById("addButton").textContent = "Agregar venta";
    editingIndex = -1;
}
function goToMainMenu() {
    window.location.href = "inicio.html";
}