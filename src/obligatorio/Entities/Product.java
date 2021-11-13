/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.Entities;

/**
 *
 * @author ADRO
 */
public class Product {
    private String IdProducto;
    private String name;

    public Product(String IdProducto, String name) {
        this.IdProducto = IdProducto;
        this.name = name;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public String getName() {
        return name;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
