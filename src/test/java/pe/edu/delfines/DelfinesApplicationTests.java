package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Test
	void contextLoads() {
		
		try {
			
			//	TIPO
			Tipo tipo1=new Tipo();
			tipo1.setId("1");
			tipo1.setNombre("Economico");
			
			Tipo tipo2=new Tipo();
			tipo2.setId("2");
			tipo2.setNombre("Presidencial");
			
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			
			// HABITACION
			
			Habitacion h1=new Habitacion();
			//h1.setId(1);
			h1.setNumeroCamas(1);
			h1.setDescripcion("decripcion");
			h1.setPrecio(480f);
			h1.setObservacion("obs");
			
			
			Habitacion h2=new Habitacion();
			//h2.setId(2);
			h2.setNumeroCamas(2);
			h2.setDescripcion("decripcion");
			h2.setPrecio(1800f);
			h2.setObservacion("obs");
			
			h1=habitacionRepository.save(h1);
			h2=habitacionRepository.save(h2);
			
			//Vendedor
			
			Vendedor v1=new Vendedor();
			v1.setId("1");
			v1.setNombre("Lilian");
			v1.setDireccion("Nogales N° 180");
			v1.setTelefono("992356844");
			v1.setObservacion("Vendedores del mes");
			v1.setSueldo(1100f);
			
			Vendedor v2=new Vendedor();
			v2.setId("2");
			v2.setNombre("Valeria");
			v2.setDireccion("Rosales N° 180");
			v2.setTelefono("99425987");
			v2.setObservacion("ob1");
			v2.setSueldo(900f);
			
			v1= vendedorRepository.save(v1);
			v2= vendedorRepository.save(v2);
			
			// CLIENTE
			Cliente c1=new Cliente();
			//c1.setId(1);
			c1.setDocumento("78563325");
			c1.setNombre("Romeli");
			c1.setFechaNacimiento(new Date(1999, 5, 9));
			c1.setLugarNacimiento("Trujillo");
			c1.setSexo('F');
			c1.setObservacion("obser");
			
			Cliente c2=new Cliente();
			//c1.setId(1);
			c2.setDocumento("8569875");
			c2.setNombre("Robert");
			c2.setFechaNacimiento(new Date(1999, 2, 2));
			c2.setLugarNacimiento("Piura");
			c2.setSexo('M');
			c2.setObservacion("obser");
			
			c1=clienteRepository.save(c1);
			c2=clienteRepository.save(c2);
			
			// ALQUILERES
			
			Alquiler a1=new Alquiler();
			a1.setPrecio(2500);
			a1.setFechaEntrada(new Date(2019, 9, 9));
			a1.setFechaSalida(new Date(2020, 9, 9));
			a1.setEstado("Activo");
			a1.setObservacion("obser");
			
			Alquiler a2=new Alquiler();
			a2.setPrecio(2500);
			a2.setFechaEntrada(new Date(2019, 9, 9));
			a2.setFechaSalida(new Date(2020, 9, 9));
			a2.setEstado("Activo");
			a2.setObservacion("obser");
			
			a1=alquilerRepository.save(a1);
			a2=alquilerRepository.save(a2);
			
			//Relaciones tipo-Habitacion
			tipo1.addHabitacion(h1);
			tipo2.addHabitacion(h2);
			
			//Relaciones habitacion-alquiler
			h1.addAlquiler(a1);
			h2.addAlquiler(a2);
			
			// Relaciones vendedor-alquiler
			v1.addAlquileres(a1);
			v2.addAlquileres(a2);
			
			//Relaciones cliente-alquiler
			c1.addAlquiler(a1);
			c2.addAlquiler(a2);
			
			//grabar
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			habitacionRepository.save(h1);
			habitacionRepository.save(h2);
			vendedorRepository.save(v1);
			vendedorRepository.save(v2);
			clienteRepository.save(c1);
			clienteRepository.save(c2);
			alquilerRepository.save(a1);
			alquilerRepository.save(a2);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
