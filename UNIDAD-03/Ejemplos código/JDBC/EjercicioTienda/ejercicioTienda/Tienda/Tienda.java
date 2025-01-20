package ejercicioTienda.Tienda;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ejercicioTienda.datos.FabricanteJDBC;
import ejercicioTienda.datos.ProductoJDBC;
import ejercicioTienda.domain.Producto;

public class Tienda {
    public static void main(String[] args) {
         
        Scanner lr = new Scanner(System.in).useDelimiter("\n");
        String opcion = "";
        boolean correcto = false, salir = false;
        List<Producto> productos;
        FabricanteJDBC fabricanteJDBC = new FabricanteJDBC();
        ProductoJDBC productoJDBC = new ProductoJDBC();
        
        // Crear base datos y cargar datos pruebas
        CrearBDTienda.crearBDTienda();
        CargarDatosBDTienda.cargarDatosBDTienda();
        
      
        try {
            do {
                System.out.println("\n*** MENU DE OPCIONES ***");
                System.out.println("*******************************************************************************\n"
                        + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                        + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                        + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                        + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                        + "e) Listar el nombre y el precio del producto más barato.\n"
                        + "f) Ingresar un producto a la base de datos.\n"
                        + "g) Ingresar un fabricante a la base de datos.\n"
                        + "h) Editar un producto con datos a elección.\n"
                        + "s) Salir.\n"
                        + "*******************************************************************************");
                opcion = lr.nextLine().toLowerCase();
                
                int codigoFabricante;
                double precio;
                int lineas;
                String cadenaCodigo;

                switch (opcion) {
                    case "a": // nombre de todos los productos que hay en la tabla producto
                        productos = productoJDBC.select();
                        System.out.println("Nombres Productos en tabla Productos: ");
                        System.out.println("===============================================");
                        for (int i = 0; i < productos.size(); i++ ) {
                        	System.out.println("Nombre producto: " + productos.get(i).getNombre() );   
                        }
                        break;
                    case "b": // los nombres y los precios de todos los productos de la tabla producto
                        productos = productoJDBC.select();
                        System.out.println("Nombres y precios Productos en tabla Productos: ");
                        System.out.println("===============================================");
                        for (int i = 0; i < productos.size(); i++ ) {
                        	System.out.println("Nombre producto: " + productos.get(i).getNombre() +
                        			           "\t\t\tPrecio: " + productos.get(i).getPrecio());   
                        }                        
                        break;
                    case "c": // productos que su precio esté entre 120 y 202
                    	productos = productoJDBC.select();
                        System.out.println("Nombres y precios Productos en tabla Productos: ");
                        System.out.println("===============================================");
                        for (int i = 0; i < productos.size(); i++ ) {
                        	precio = productos.get(i).getPrecio();
                        	if ( precio >= 120 && precio <= 202 ) {
	                        	System.out.println("Nombre producto: " + productos.get(i).getNombre() +
	                        			           "\t\t\tPrecio: " + productos.get(i).getPrecio());   
                        	}
                        }                         	                
                        break;
                    case "d": // Buscar y listar todos los Portátiles de la tabla producto
                    	productos = productoJDBC.select();
                        System.out.println("Portátiles en tabla Productos: ");
                        System.out.println("===============================================");
                        for (int i = 0; i < productos.size(); i++ ) {
                        	String nombre =productos.get(i).getNombre();
                        	if ( nombre.toLowerCase().contains("portatil") || nombre.toLowerCase().contains("portátil") ) {
	                        	System.out.println("Nombre producto: " + productos.get(i).getNombre() +
	                        			           "\t\t\tPrecio: " + productos.get(i).getPrecio());   
                        	}
                        }                      
                        break;
                    case "e": //nombre y el precio del producto más barato
                    	productos = productoJDBC.select();
                        System.out.println("Producto más barato en tabla Productos: ");
                        System.out.println("===============================================");
                        int indice = 0;
                        double barato = productos.get(0).getPrecio();
                        for (int i = 1; i < productos.size(); i++ ) {
                        	precio = productos.get(i).getPrecio();
                        	if ( precio < barato ) {
                        		indice = i;
                        		barato = precio;
                        	}
                        }         
                        System.out.println("Nombre producto: " + productos.get(indice).getNombre() +
         			           "\t\t\tPrecio: " + barato);   
                        break;
                    case "f": // Ingresar un producto a la base de datos
                        System.out.println("Ingresar producto en tabla Productos: ");
                        System.out.println("===============================================");
                        
                        System.out.print("Introduzca nombre producto: ");
                        String nombre = lr.nextLine();
                        
                        precio = -1.0;
                        do {
                            System.out.print("Introduzca precio producto: ");
                        	try {
                        		cadenaCodigo = lr.nextLine();
                        		precio = Double.valueOf(cadenaCodigo);
            		
                        		if (precio <= 0.0) {
                        			precio = -1.0;
                        		}
                        	} catch (NumberFormatException e) {
                        		precio = -1.0;
                        	}
                        } while (precio == -1.0);
                        
                        codigoFabricante = -1;
                        do {
                            System.out.print("Introduzca código fabricante producto: ");
                        	try {
                        		cadenaCodigo = lr.nextLine();
                        		codigoFabricante = Integer.valueOf(cadenaCodigo);
                        		if (codigoFabricante < 0) {
                        			codigoFabricante = -1;
                        		}
                        	} catch (NumberFormatException e) {
                        		codigoFabricante = -1;
                        	}
                        } while (codigoFabricante == -1);
                        	
                        lineas = productoJDBC.insert(nombre, precio, codigoFabricante);
                        if ( lineas == 1  ) {
                        	System.out.println("Datos insertados correctamente");
                        } else {
                        	System.out.println("ERROR: Datos no insertados");
                        }
                             	
                        break;
                    case "g": // Ingresar un fabricante a la base de datos
                        System.out.println("Ingresar fabricante en tabla Fabricantes: ");
                        System.out.println("===============================================");
                        
                        System.out.print("Introduzca nombre fabricante: ");
                        String nombreFabricante = lr.nextLine();
                                               	
                        lineas = fabricanteJDBC.insert(nombreFabricante);
                        if ( lineas == 1  ) {
                        	System.out.println("Datos insertados correctamente");
                        } else {
                        	System.out.println("ERROR: Datos no insertados");
                        }                        
                        break;
                    case "h":  // Editar un producto con datos a elección
                        System.out.println("Editar producto de tabla Productos: ");
                        System.out.println("===============================================");
                        
                        int codigoProducto = -1;
                        do {
                            System.out.print("Introduzca código producto: ");
                        	try {
                        		cadenaCodigo = lr.nextLine();
                        		codigoProducto = Integer.valueOf(cadenaCodigo);
                        		if (codigoProducto < 0) {
                        			codigoProducto = -1;
                        		}
                        	} catch (NumberFormatException | InputMismatchException e) {
                        		e.printStackTrace();
                        		System.out.println("ERROR: codigoProducto = " + codigoProducto);
                        		codigoProducto = -1;
                        	}
                        } while (codigoProducto == -1);
                        
                        Producto producto = productoJDBC.select(codigoProducto);
                        
                    	System.out.println("Nombre producto: " + producto.getNombre() +
         			           "\t\t\tPrecio: " + producto.getPrecio() +
         			          "\t\t\tCódigo Fabricante: " + producto.getCodigoFabricante());   
                    	
                        System.out.print("Introduzca datos nuevos producto: ");

                        System.out.print("--->Introduzca nombre producto: ");
                        nombre = lr.nextLine();
                        
                        precio = -1.0;
                        do {
                            System.out.print("Introduzca precio producto: ");
                        	try {
                        		cadenaCodigo = lr.nextLine();
                        		precio = Double.valueOf(cadenaCodigo);	
                        		if (precio <= 0.0) {
                        			precio = -1.0;
                        		}
                        	} catch (NumberFormatException e) {
                        		precio = -1.0;
                        	}
                        } while (precio == -1.0);
                        
                        codigoFabricante = -1;
                        do {
                            System.out.print("Introduzca código fabricante producto: ");
                        	try {
                        		cadenaCodigo = lr.nextLine();
                        		codigoFabricante = Integer.valueOf(cadenaCodigo);	
                        		if (codigoFabricante < 0) {
                        			codigoFabricante = -1;
                        		}
                        	} catch (NumberFormatException e) {
                        		codigoFabricante = -1;
                        	}
                        } while (codigoFabricante == -1);
                        	
                        lineas = productoJDBC.update(codigoProducto, nombre, precio, codigoFabricante);
                        if ( lineas == 1  ) {
                        	System.out.println("Datos actualizados correctamente");
                        } else {
                        	System.out.println("ERROR: Datos no insertados");
                        }                    	
                        
                        break;              
                    case "s":
                        salir = true;
                        System.out.println("Saliendo .....");
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (!correcto && !salir);
        } catch (Exception e) {
            System.out.println("Error en menu " + e);
        }
    }
    
}

