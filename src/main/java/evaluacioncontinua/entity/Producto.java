package evaluacioncontinua.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 50)
	private String categoria;

	@Column(nullable = false)
	private double precio;

	@Column(name = "create_at", nullable = false)
	private LocalDate createAt;

	private String foto;

	public Producto() {
	}

	public Producto(String nombre, String categoria, double precio, String foto) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.foto = foto;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", categoria='" + categoria + '\'' +
				", precio=" + precio +
				", createAt=" + createAt +
				", foto='" + foto + '\'' +
				'}';
	}
}
