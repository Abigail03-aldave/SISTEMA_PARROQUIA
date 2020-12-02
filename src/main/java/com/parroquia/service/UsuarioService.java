package com.parroquia.service;

import java.util.List;
import java.util.Optional;

import com.parroquia.entity.Opcion;
import com.parroquia.entity.Rol;
import com.parroquia.entity.Usuario;

public interface UsuarioService {
	
	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	public abstract List<Usuario> listarUsuario();
	
	public abstract Usuario insertaActualizaUsuario(Usuario usuario);
	
	public abstract void EliminarUsuario(int id);
	
	public Optional<Usuario> ObtenerUsuario(int id);

	public abstract List<Usuario> listarPorFiltro(String filtro);
	

}
