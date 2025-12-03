// Array que guarda todas las tareas
let tareas = [];


// Selecciones del DOM
const input = document.querySelector("#tarea");
const boton = document.querySelector("#agregar");
const lista = document.querySelector("#lista");
const listaRealizadas=document.querySelector('#listaRealizadas');
const formulario = document.querySelector('#formulario');
const botonFormulario = document.querySelector('#botonFormulario')
const listadoTareasGuardar=document.querySelector('#listadoTareas')
const listadoRealizadasGuardar=document.querySelector('#listadoRealizadas')

// Evento: Añadir una tarea
boton.addEventListener("click", () => {
  const texto = input.value.trim();
  if (texto === "") return;
  tareas.push(texto);
  input.value = "";
  render();
});

// Función que dibuja la lista completa
function render() {
  lista.innerHTML = "";
  tareas.forEach((t, i) => {
    const li = document.createElement("li");
	const spanTexto = document.createElement("span");
	spanTexto.textContent = t;
   

    const borrar = document.createElement("button");
    borrar.textContent = "❌";
    borrar.addEventListener("click", () => {
      tareas.splice(i, 1);
      render();
    });

    const realizar = document.createElement("button");
    realizar.textContent = "✅";
    realizar.addEventListener("click", () => {
      let realizadas=tareas.splice(i, 1);
      tareasRealizadas.push(realizadas[0]);
      //Tb se puede tareasRealizadas.push(t) 
      // y no sacar array "realizadas"
      render();
    });
	li.appendChild(spanTexto);
    li.appendChild(borrar);
    li.appendChild(realizar);
    lista.appendChild(li);
  });
  listaRealizadas.innerHTML = "";
  tareasRealizadas.forEach((t, i) => {
    const li = document.createElement("li");
    li.textContent = t;
    listaRealizadas.appendChild(li)
  });
}

formulario.addEventListener("submit", function (e) {
   // 1. Obtener todos los li de la lista
   const lis = document.querySelectorAll("#lista li span");
   const lisRealiz = document.querySelectorAll("#listaRealizadas li");
   // 2. Sacar el texto de cada li
   const tareas = [];
   lis.forEach(function(li) {
     tareas.push(li.innerText.trim());
   });
   const tareasRealizadas = [];
      lisRealiz.forEach(function(li) {
        tareasRealizadas.push(li.innerText.trim());
      });
   // 3. Convertir a una cadena (por ejemplo, separada por ;)

   // 4. Meterlo en el hidden
   listadoTareasGuardar.value = JSON.stringify(tareas);;
   listadoRealizadasGuardar.value=JSON.stringify(tareasRealizadas);;
   
   // A partir de aquí el formulario se envía normal a Spring
 });
 
 document.addEventListener("DOMContentLoaded", () => {
     const origen = document.querySelectorAll("#listaOriginal li");


     origen.forEach(li => {
         const realizada = li.dataset.realizada === "true";
         if (realizada) {
             tareasRealizadas.push(li.textContent)
         } else {
             tareas.push(li.textContent)
         }
     });
	 render();
 });