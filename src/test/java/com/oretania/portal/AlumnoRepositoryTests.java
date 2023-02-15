package com.oretania.portal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oretania.portal.models.Alumno;
import com.oretania.portal.models.Asignatura;
import com.oretania.portal.repositories.AlumnoRepository;
import com.oretania.portal.repositories.AsignaturaRepository;

import java.util.*;

@SpringBootTest
class AlumnoRepositoryTests {

	@Autowired
	AlumnoRepository repoAlumno; 
	
	@Autowired
	AsignaturaRepository repoAsignatura; 

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearalumnosTest() {

		Alumno u1 = new Alumno();
		u1.setCodigo(1);
		u1.setUsername("alumno1");
		u1.setPassword(encoder.encode("1234"));

        Alumno u2 = new Alumno();
		u2.setCodigo(2);
		u2.setUsername("alumno2");
		u2.setPassword(encoder.encode("1234"));

        Alumno u3 = new Alumno();
		u3.setCodigo(3);
		u3.setUsername("alumno3");
		u3.setPassword(encoder.encode("1234"));

		Alumno director = new Alumno();
		director.setCodigo(4);
		director.setUsername("director");
		director.setPassword(encoder.encode("director1234"));

		Asignatura a1 = new Asignatura();
		a1.setCodigo("MAT");
		a1.setDescripcion("Matemáticas");
		repoAsignatura.save(a1);

		Asignatura a2 = new Asignatura();
		a2.setCodigo("LEN");
		a2.setDescripcion("Lengua");
		repoAsignatura.save(a2);

		Asignatura a3 = new Asignatura();
		a3.setCodigo("ING");
		a3.setDescripcion("Inglés");
		repoAsignatura.save(a3);

		Asignatura a4 = new Asignatura();
		a4.setCodigo("REL");
		a4.setDescripcion("Religión");
		repoAsignatura.save(a4);

		Asignatura a5 = new Asignatura();
		a5.setCodigo("FIS");
		a5.setDescripcion("Física");
		repoAsignatura.save(a5);

		Asignatura a6 = new Asignatura();
		a6.setCodigo("QUI");
		a6.setDescripcion("Química");
		repoAsignatura.save(a6);

		List<Asignatura> asignaturasAlumno1 = new ArrayList<Asignatura>();
		asignaturasAlumno1.add(a1);
		asignaturasAlumno1.add(a2);
		asignaturasAlumno1.add(a5);

		List<Asignatura> asignaturasAlumno2 = new ArrayList<Asignatura>();
		asignaturasAlumno2.add(a1);
		asignaturasAlumno2.add(a3);
		asignaturasAlumno2.add(a4);

		List<Asignatura> asignaturasDirector = new ArrayList<Asignatura>();
		asignaturasDirector.add(a1);
		asignaturasDirector.add(a2);
		asignaturasDirector.add(a3);
		asignaturasDirector.add(a4);
		asignaturasDirector.add(a5);
		asignaturasDirector.add(a6);

		u1.setAsignaturas(asignaturasAlumno1);
		u2.setAsignaturas(asignaturasAlumno2);
		director.setAsignaturas(asignaturasDirector);

		repoAlumno.save(u1);
		repoAlumno.save(u2);
		repoAlumno.save(u3);
        repoAlumno.save(director);

		Alumno u1OK = repoAlumno.save(u1);

		assertTrue(u1.getPassword().equalsIgnoreCase(u1OK.getPassword()));
	}

}
