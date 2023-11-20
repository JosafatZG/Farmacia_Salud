let compras = [];
let editingIndex = -1;
function addCompras() {
    const compraId = document.getElementById("compraId").value;
    const Fecha = document.getElementById("Fecha").value;
    const Cantidad = document.getElementById("Cantidad").value;
    const comprasPriceshop = document.getElementById("comprasPriceshop").value;
    const comprasPrice = document.getElementById("comprasPrice").value;

    if (!compraId || !Fecha || !Cantidad || !comprasPriceshop || !comprasPrice) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const newCompras= {
        id: compraId,
        fecha: Fecha,
        cant: parseInt(Cantidad),
        unitario: parseFloat(comprasPriceshop),
        total: parseFloat(comprasPrice)
    };
    if (editingIndex === -1) {
        // Agregar nuevo comprao
        compras.push(newcompra);
    } else {
        // Actualizar comprao existente
        compras[editingIndex] = newcompra;
        editingIndex = -1;
    }
    updateComprasTable();
   clearForm();
}

function deleteCompras(index) {
    compras.splice(index, 1);
    updatecompraTable();
}

function updateComprasTable() {
    const compraList = document.getElementById("compraList");

    compraList.innerHTML = "";

    compras.forEach((compra, index) => {
        const row = compraList.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        const cell5 = row.insertCell(3);
        const cell6 = row.insertCell(3);

        cell1.innerHTML = compra.id;
        cell2.innerHTML = compra.fecha;
        cell3.innerHTML = compra.cant;
        cell4.innerHTML = `$${compra.unitario.toFixed(2)}`;
        cell5.innerHTML = `$${compra.unitario.toFixed(2)}`;
        cell6.innerHTML =   `<button onclick="editcompra(${index})">Editar</button>
                           <button onclick="deletecompra(${index})">Eliminar</button>`;
    });
}

function editCompras(index) {
    const compra = compras[index];
    document.getElementById("compraId").value = compra.id;
    document.getElementById("Fecha").value = compra.fecha;
    document.getElementById("Cantidad").value = compra.cant;
    document.getElementById("comprasPriceshop").value = compra.unitario;
    document.getElementById("comprasPrice").value = compra.total;
    const addButton = document.getElementById("addButton");
    addButton.textContent = "Actualizar compras";
    editingIndex = index;
}
function clearForm() {
    document.getElementById("compraForm").reset();
    document.getElementById("addButton").textContent = "Agregar compra";
    editingIndex = -1;
}
function goToMainMenu() {
    window.location.href = "inicio.html";
}