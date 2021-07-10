db.clientes.insert({ "_id" : 1, "nombre" : "juan", "apellido" : "perez", "direccion" : "calle de la vega 21", "cp" : "09111", "localidad" : "barcelona", "provincia" : "barcelona", "telefono" : "654896988"});

db.pedidos.insert({ "_id" : 1, "cliente_id" : 1, "tienda_id" : 1, "fecha" : "2020-05-03 15:25", "tipo" : "domicilio", "precio" : 49, "fecha_entrega" : "2020-05-03 15:55", "repartidor" : "maia",
"productos" :[{ "producto_id" : 1, "cantidad" : 1}, { "producto_id" : 2, "cantidad" : 2}]});

db.productos.insert({ "_id" : 1, "nombre" : "pizza margarita", "descripcion" : "pizza con queso y tomate", "categoria" : "pizza", "imagen" : "/imagen/pizza.svg", "precio" : 45});

db.tiendas.insert({ "_id" : 1, "direccion" : "avenida diagonal 25", "cp" : "12456", "localidad" : "barcelona", "provincia" : "barcelona", "empleados" :[{ "nombre" : "pau", "apellido" : "dertu", "NIF" : "12365478L", "tel" : "123654987", "trabajo" : "cocinero"}, { "nombre" : "maria", "apellido" : "larreta", "NIF" : "98765432W", "tel" : "654987999", "trabajo" : "repartidor"}]});