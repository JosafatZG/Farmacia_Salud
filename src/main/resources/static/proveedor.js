let proveedor = [];
let editingIndex = -1;
function addProveedor() {
    const ProveedorId = document.getElementById("ProveedorId").value;
    const ProveedorName = document.getElementById("ProveedorName").value;
    const Direccion = document.getElementById("Direccion").value;
    const Telefono = document.getElementById("Telefono").value;
    const Celular = document.getElementById("Celular").value;
    const Email = document.getElementById("Email").value;
    const personContact = document.getElementById("personContact").value;


    if (!ProveedorId || !ProveedorName || !Direccion || !Telefono || !Celular || !Email || !personContact) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const newProveedor = {
        id: ProveedorId,
        name: ProveedorName,
        direccion: Direccion,
        telefono: parseInt(Telefono),
        celular: parseInt(Celular),
        email: Email,
        person: personContact
    };
    if (editingIndex === -1) {
        // Agregar nuevo Proveedor
        Proveedor.push(newProveedor);
    } else {
        // Actualizar Proveedoro existente
        Proveedor[editingIndex] = newProveedor;
        editingIndex = -1;
    }
    updateProveedorTable();
   clearForm();
}

function deleteProveedor(index) {
    Proveedor.splice(index, 1);
    updateProveedorTable();
}

function updateProveedorTable() {
    const ProveedorList = document.getElementById("ProveedorList");

    ProveedorList.innerHTML = "";

    Proveedors.forEach((Proveedor, index) => {
        const row = ProveedorList.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        const cell5 = row.insertCell(4);
        const cell6 = row.insertCell(5);
        const cell7 = row.insertCell(6);
        const cell8 = row.insertCell(7);

        cell1.innerHTML = Proveedor.id;
        cell2.innerHTML = Proveedor.name;
        cell3.innerHTML = Proveedor.direccion;
        cell4.innerHTML = Proveedor.telefono;
        cell5.innerHTML = Proveedor.celular;
        cell6.innerHTML = Proveedor.email;
        cell7.innerHTML = Proveedor.person;
        cell8.innerHTML =   `<button onclick="editProveedor(${index})">Editar</button>
                           <button onclick="deleteProveedor(${index})">Eliminar</button>`;
    });
}

function editProveedor(index) {
    const Proveedor = Proveedor[index];
    document.getElementById("ProveedorId").value = Proveedor.id;
    document.getElementById("ProveedorName").value = Proveedor.name;
    document.getElementById("Direccion").value = Proveedor.direccion;
    document.getElementById("Telefono").value = Proveedor.telefono;
    document.getElementById("Celular").value = Proveedor.celular;
    document.getElementById("Email").value = Proveedor.email;
    document.getElementById("personContact").value = Proveedor.person;
    const addButton = document.getElementById("addButton");
    addButton.textContent = "Actualizar Proveedor";
    editingIndex = index;
}
function clearForm() {
    document.getElementById("ProveedorForm").reset();
    document.getElementById("addButton").textContent = "Agregar Proveedor";
    editingIndex = -1;
}
function goToMainMenu() {
    window.location.href = "inicio.html";
}