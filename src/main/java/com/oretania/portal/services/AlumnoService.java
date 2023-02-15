package com.oretania.portal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oretania.portal.models.Alumno;
import com.oretania.portal.models.Asignatura;
import com.oretania.portal.repositories.AlumnoRepository;

@Service
public class AlumnoService implements UserDetailsService {

    @Autowired
    AlumnoRepository repository;

    public Alumno createAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    public Alumno updateAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public Alumno getAlumno(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Alumno> findAll(){
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        
        Alumno alumno = repository.findByUserName(name);

        List<Asignatura> asignaturasUsuario = alumno.getAsignaturas();
        List<GrantedAuthority> asignaturas = new ArrayList<GrantedAuthority>();

        for(Asignatura asignatura : asignaturasUsuario) {
            asignaturas.add(new SimpleGrantedAuthority(asignatura.getDescripcion()));
        }

        UserDetails uD = org.springframework.security.core.userdetails.User.builder()
                    .username(alumno.getNombre())
                    .password(alumno.getPassword())
                    .authorities(asignaturas)
                    .build();

        return uD;
    }
}
