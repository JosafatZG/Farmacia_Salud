let products = [];
let editingIndex = -1;
function addProduct() {
    const productName = document.getElementById("productName").value;
    const productPrice = document.getElementById("productPrice").value;
    const productCant = document.getElementById("productCant").value;

    if (!productName || !productPrice || !productCant) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const newProduct = {
        name: productName,
        price: parseFloat(productPrice),
        cant: parseInt(productCant)
    };
    if (editingIndex === -1) {
        // Agregar nuevo producto
        products.push(newProduct);
    } else {
        // Actualizar producto existente
        products[editingIndex] = newProduct;
        editingIndex = -1;
    }
    updateProductTable();
   clearForm();
}

function deleteProduct(index) {
    products.splice(index, 1);
    updateProductTable();
}

function updateProductTable() {
    const productList = document.getElementById("productList");

    productList.innerHTML = "";

    products.forEach((product, index) => {
        const row = productList.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);

        cell1.innerHTML = product.name;
        cell2.innerHTML = `$${product.price.toFixed(2)}`;
        cell3.innerHTML = product.cant;
        cell4.innerHTML =   `<button onclick="editProduct(${index})">Editar</button>
                           <button onclick="deleteProduct(${index})">Eliminar</button>`;
    });
}

function editProduct(index) {
    const product = products[index];
    document.getElementById("productName").value = product.name;
    document.getElementById("productPrice").value = product.price;
    document.getElementById("productCant").value = product.cant;
    const addButton = document.getElementById("addButton");
    addButton.textContent = "Actualizar Producto";
    editingIndex = index;
}
function clearForm() {
    document.getElementById("productForm").reset();
    document.getElementById("addButton").textContent = "Agregar Producto";
    editingIndex = -1;
}
function goToMainMenu() {
    window.location.href = "inicio.html";
}