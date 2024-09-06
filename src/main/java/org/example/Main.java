package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            // Persistir una nueva entidad
            entityManager.getTransaction().begin();

            Domicilio domicilio1 = Domicilio.builder()
                    .nombreCalle("Rodriguez")
                    .numero(273)
                    .build();
            Domicilio domicilio2 = Domicilio.builder()
                    .nombreCalle("San Martin")
                    .numero(2738)
                    .build();
            Cliente cliente1 = Cliente.builder()
                    .nombre("Juan")
                    .apellido("Perez")
                    .dni(46985475)
                    .domicilio(domicilio1)
                    .build();
            Cliente cliente2 = Cliente.builder()
                    .nombre("Fernanda")
                    .apellido("Martinez")
                    .dni(46987575)
                    .domicilio(domicilio2)
                    .build();
            Categoria categoria1= Categoria.builder()
                    .denominacion("Perecederos")
                    .build();
            Categoria categoria2= Categoria.builder()
                    .denominacion("Lacteos")
                    .build();
            Categoria categoria3 = Categoria.builder()
                    .denominacion("Electrónica")
                    .build();
            Articulo articulo1= Articulo.builder()
                    .cantidad(500)
                    .denominacion("Paquete de fideos")
                    .precio(1000)
                    .build();
            articulo1.getCategorias().add(categoria1);
            Articulo articulo2= Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt de frutilla")
                    .precio(2000)
                    .build();
            articulo2.getCategorias().add(categoria2);
            Articulo articulo3= Articulo.builder()
                    .cantidad(100)
                    .denominacion("Teclado")
                    .precio(50000)
                    .build();
            articulo3.getCategorias().add(categoria3);
            DetalleFactura detalleFactura1= DetalleFactura.builder()
                    .cantidad(3)
                    .subtotal(3000)
                    .articulo(articulo1)
                    .build();
            DetalleFactura detalleFactura2= DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(4000)
                    .articulo(articulo2)
                    .build();
            DetalleFactura detalleFactura3= DetalleFactura.builder()
                    .cantidad(1)
                    .subtotal(50000)
                    .articulo(articulo3)
                    .build();
            Factura factura1= Factura.builder()
                    .numero(18447151)
                    .fecha("05/09/2024")
                    .cliente(cliente1)
                    .total(6000)
                    .build();
            factura1.getDetalleFacturas().add(detalleFactura1);
            factura1.getDetalleFacturas().add(detalleFactura2);
            Factura factura2= Factura.builder()
                    .numero(18447152)
                    .fecha("05/09/2024")
                    .cliente(cliente2)
                    .total(50000)
                    .build();
            factura2.getDetalleFacturas().add(detalleFactura3);

            entityManager.persist(factura1);
            entityManager.persist(factura2);

            entityManager.flush();

            entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
            Cliente retrievedCliente = entityManager.find(Cliente.class, cliente1.getId());
            System.out.println("Retrieved Cliente: " + retrievedCliente.getNombre());

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase");
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
