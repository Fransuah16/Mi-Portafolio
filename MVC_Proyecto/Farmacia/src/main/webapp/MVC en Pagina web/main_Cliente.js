
//Definir ruta donde se consumirá el servicio
const url = "http://localhost:8080/Farmacia/api/ClienController/"
const contenedor = document.querySelector('tbody')
let resultados = ''
const modalCliente = new bootstrap.Modal(document.getElementById('modalCliente')) 
const formCliente = document.querySelector('form') 

//Capturar los datos de los inputs
const dni = document.getElementById('dni')
const nombre = document.getElementById('nombre')
const apellido = document.getElementById('apellido')
const estado = document.getElementById('estado')
const id_venta = document.getElementById('id_venta')

btnCrear.addEventListener('click',()=>{
    limpiarCampos()
    modalCliente.show() 
    opcion = 'crear'
})

//Función para recorrer resultados encontrados en el servicio rest
const mostrar =(clientes) => {
    clientes.forEach(cliente => {
        resultados += `
        <tr>
        <td>${cliente.dni}</td> 
        <td>${cliente.nombre}</td>
        <td>${cliente.apellido}</td>
        <td>${cliente.estado}</td>
        <td>${cliente.id_Venta}</td>
        <td class="text-center"><a class="btnEditar btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
        <td class="text-center"><a class="btnBorrar btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
      </tr> 
        `
    })
    contenedor.innerHTML=resultados
}
// "id_P" la forma en como se envia el dato en el formato Json, debe ser igual.

//Procedimiento para mostrar resultados
fetch(url+"CliBuscarTodos")
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

function limpiarCampos(){
    dni.value = ''
    nombre.value = ''
    apellido.value = ''
    estado.value = ''
    id_venta.value = ''
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
    const dni = fila.firstElementChild.innerHTML
    //console.log(dni)
    alertify.confirm("¿Desea eliminar registro?",
        function(){
            fetch(url+"Clidarbaja/"+dni,{
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
formCliente.addEventListener('submit',(e)=>{ 
    e.preventDefault()

    if(opcion == 'crear') {
        //console.log('Opcion crear'); 
        fetch(url + "Cliregistrar/", {
            method: 'PUT',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                dni:dni.value,
                nombre:nombre.value,
                apellido:apellido.value,
                estado:estado.value,
                id_Venta:id_venta.value
            })
        })
        .then(response => response.json())
        .then(data => {
            const nuevoCliente = [];
            nuevoCliente.push(data);
            alertify.success('Datos registrados');
            mostrar(nuevoCliente);
        }) //aqui iba una coma
        .catch(error => { //aqui edite
            console.error('Error en la solicitud:', error); //aqui edite
        });

    }
    if(opcion == 'editar') {
        //console.log('Opcion editar') 
        fetch(url+ "Cliactualizar/", {
            method: 'POST',
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify({
                dni:dni.value,
                nombre:nombre.value,
                apellido:apellido.value,
                estado:estado.value,
                id_Venta:id_venta.value
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
let dniForm = ''
on(document, 'click', '.btnEditar', e => {
    const fila = e.target.parentNode.parentNode
    dniForm = fila.children[0].innerHTML //Otra forma de obtener dni
    //console.log(idForm)
    const nombreForm = fila.children[1].innerHTML
    const apellidoForm = fila.children[2].innerHTML
    const estadoForm = fila.children[3].innerHTML
    const id_ventaForm = fila.children[4].innerHTML
    
    dni.value = dniForm
    nombre.value = nombreForm
    apellido.value = apellidoForm
    estado.value = estadoForm 
    id_venta.value = id_ventaForm
    opcion = 'editar'
    modalCliente.show() 
})
// seria bueno buscar una forma de ocultar el estado, o hacer que tdo producto registrado tenga 1 en estado.