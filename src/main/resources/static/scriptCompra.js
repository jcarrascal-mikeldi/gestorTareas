// Array que guarda todas las tareas
let listaCompra = [];

// Selecciones del DOM

const boton = document.querySelector("#aniadir");
const lista = document.querySelector("#lista");
const producto = document.querySelector("#producto");
const cantidad = document.querySelector("#cantidad");
const botonFormulario = document.querySelector('#botonFormulario');
const listado=document.querySelector('#listado');
const formulario=document.querySelector('#formulario');

// Evento: Añadir un producto
boton.addEventListener("click", () => {
  const texto = producto.value.trim();
  const num = cantidad.value.trim();
  if (texto === "") return;
  listaCompra.push(texto + " - " + num);
  producto.value = "";
  cantidad.value = 0;
  render();
});

// Función que dibuja la lista completa
function render() {
  lista.innerHTML = "";
  listaCompra.forEach((t) => {
    const li = document.createElement("li");
	li.textContent =t;
    lista.appendChild(li);
});
}
  
formulario.addEventListener("submit", function (e) {
   listado.value = JSON.stringify(listaCompra);
   // A partir de aquí el formulario se envía normal a Spring
});

