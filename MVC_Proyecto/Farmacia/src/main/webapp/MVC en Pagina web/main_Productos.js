
//Definir ruta donde se consumirá el servicio
const url = "http://localhost:8080/Farmacia/api/ProController/"
const contenedor=document.querySelector('tbody')
let resultados=''
const modalProducto = new bootstrap.Modal(document.getElementById('modalProducto')) 
const formProducto = document.querySelector('form') 

//Capturar los datos de los inputs
const id_p = document.getElementById('id_p')
const nombre = document.getElementById('nombre')
const precio = document.getElementById('precio')
const marca = document.getElementById('marca')
const estado = document.getElementById('estado')

btnCrear.addEventListener('click',()=>{
    limpiarCampos()
    modalProducto.show() 
    opcion = 'crear'
})

//Función para recorrer resultados encontrados en el servicio rest
const mostrar =(productos) => {
    productos.forEach(producto => {
        resultados += `
        <tr>
        <td>${producto.id_P}</td> 
        <td>${producto.nombre}</td>
        <td>${producto.precio}</td>
        <td>${producto.marca}</td>
        <td>${producto.estado}</td>
        <td class="text-center"><a class="btnEditar btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
        <td class="text-center"><a class="btnBorrar btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
      </tr> 
        `
    })
    contenedor.innerHTML=resultados
}
// "id_P" la forma en como se envia el dato en el formato Json, debe ser igual.

//Procedimiento para mostrar resultados
fetch(url+"ProBuscarTodos")
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

function limpiarCampos(){
    id_p.value = ''
    nombre.value = ''
    precio.value = ''
    marca.value = ''
    estado.value = ''
}    
//--------------------
//Usar handler para editar y eliminar
const on = (element,event,selector,handler) =>{
    element.addEventListener(event, e => {
        if(e.target.closest(selector)){
            handler(e)
        }
    })
}
//Borrar datos
on(document, 'click','.btnBorrar',e => {
    //console.log('Eliminando...')
    const fila = e.target.parentNode.parentNode
    const id_p = fila.firstElementChild.innerHTML
    //console.log(dni)
    alertify.confirm("¿Desea eliminar registro?",
        function(){
            fetch(url+"Prodarbaja/"+id_p,{
                method: 'POST'
            })
        //.then(response => response.json())
        .then( response => location.reload())
        alertify.success('Datos Eliminados')
        },
        function(){
            alertify.error('Orden cancelada')
        }
    )
})


//Procedimiento para Crear y Editar datos
formProducto.addEventListener('submit',(e)=>{ //formProducto ------
    e.preventDefault()

    if(opcion == 'crear') {
        //console.log('Opcion crear'); 
        fetch(url + "Proregistrar/", {
            method: 'PUT',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                id_P:id_p.value,
                nombre:nombre.value,
                precio:precio.value,
                marca:marca.value,
                estado:estado.value
            })
        })
        .then(response => response.json())
        .then(data => {
            const nuevoProducto = [];
            nuevoProducto.push(data);
            alertify.success('Datos registrados');
            mostrar(nuevoProducto);
        }) //aqui iba una coma
        .catch(error => { //aqui edite
            console.error('Error en la solicitud:', error); //aqui edite
        });

    }
    if(opcion == 'editar') {
        //console.log('Opcion editar') 
        fetch(url+ "Proactualizar/", {
            method: 'POST',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                id_P:id_p.value,
                nombre:nombre.value,
                precio:precio.value,
                marca:marca.value,
                estado:estado.value
            })
        })
        .then(response => response.json())
        .then( data => { 
            location.reload();
            alertify.success('Datos actualizados');
        }) //aqui iba una coma
        .catch(error => { //aqui edite
            console.error('Error en la solicitud:', error); //aqui edite
        });
        
    }
    modalProducto.hide(); 
});

//Procedimiento para cargar datos y luego editar
let id_pForm = ''
on(document, 'click', '.btnEditar', e => {
    const fila = e.target.parentNode.parentNode
    id_pForm = fila.children[0].innerHTML //Otra forma de obtener dni
    //console.log(idForm)
    const nombreForm = fila.children[1].innerHTML
    const precioForm = fila.children[2].innerHTML
    const marcaForm = fila.children[3].innerHTML
    const estadoForm = fila.children[4].innerHTML
    
    id_p.value = id_pForm
    nombre.value = nombreForm
    precio.value = precioForm
    marca.value = marcaForm 
    estado.value = estadoForm
    opcion = 'editar'
    modalProducto.show() 
})
// seria bueno buscar una forma de ocultar el estado, o hacer que tdo producto registrado tenga 1 en estado.