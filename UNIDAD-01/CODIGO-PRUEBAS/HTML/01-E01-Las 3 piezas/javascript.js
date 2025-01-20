function actualizarNombre() {
  const nombre = prompt('Dime tu nombre! ');
  para.textContent = `¡Hola!: ${nombre}`;
}

const para = document.querySelector('p');

para.addEventListener('click', actualizarNombre);
