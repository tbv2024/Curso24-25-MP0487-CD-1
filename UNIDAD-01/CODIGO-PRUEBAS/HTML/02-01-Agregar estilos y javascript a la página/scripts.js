const list = document.createElement('ul');
const info = document.createElement('p');
const html = document.querySelector('html');

info.textContent = 'A continuación se muestra una lista dinámica. Haga clic en cualquier parte de la página para agregar un nuevo elemento de lista. Haga clic en un elemento de lista existente para cambiar su texto a otra cosa.';

document.body.appendChild(info);
document.body.appendChild(list);

html.onclick = function() {
  const listItem = document.createElement('li');
  const listContent = prompt('¿Qué contenido desea que tenga el elemento de la lista?');
  listItem.textContent = listContent;
  list.appendChild(listItem);

  listItem.onclick = function(e) {
    e.stopPropagation();
    const listContent = prompt('Ingrese contenido nuevo para su elemento de lista');
    this.textContent = listContent;
  }
}