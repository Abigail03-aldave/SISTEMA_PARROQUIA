package com.parroquia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parroquia.entity.Opcion;
import com.parroquia.entity.Rol;
import com.parroquia.entity.Usuario;
import com.parroquia.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorepositorio;
	
	
	@Override
	public Usuario login(Usuario bean) {
		// TODO Auto-generated method stub
		return usuariorepositorio.login(bean);
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return usuariorepositorio.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return usuariorepositorio.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuariorepositorio.findAll();
	}

	@Override
	public Usuario insertaActualizaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		//usuario.setFech_nacimiento(new Date());
		return usuariorepositorio.save(usuario);
	}

	@Override
	public void EliminarUsuario(int id) {
		// TODO Auto-generated method stub
		 usuariorepositorio.deleteById(id);
	}

	@Override
	public Optional<Usuario> ObtenerUsuario(int id) {
		// TODO Auto-generated method stub
		return usuariorepositorio.findById(id);
	}

	@Override
	public List<Usuario> listarPorFiltro(String filtro) {
		// TODO Auto-generated method stub
		return usuariorepositorio.listaPorNombre(filtro);
	}

}
