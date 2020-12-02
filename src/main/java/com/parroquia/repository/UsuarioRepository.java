package com.parroquia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parroquia.entity.Opcion;
import com.parroquia.entity.Rol;
import com.parroquia.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("Select x from Usuario x where x.usuario = :#{#usu.usuario} and x.contraseña = :#{#usu.contraseña}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where "
			+ " p.idOpcion = pr.opcion.idOpcion and "
			+ " pr.rol.idRol = r.idRol and "
			+ " r.idRol = u.rol.idRol and "
			+ " u.usuario.idUsuario = :var_idUsuario")
	
	
	public abstract List<Opcion> traerEnlacesDeUsuario(@Param("var_idUsuario") int idUsuario);
	@Query("Select r from Rol r, UsuarioHasRol u where "
			+ " r.idRol = u.rol.idRol and "
			+ " u.usuario.idUsuario = :var_idUsuario")
	
	
	public abstract List<Rol> traerRolesDeUsuario(@Param("var_idUsuario")int idUsuario);
	@Query("select x from Usuario x where x.nombres like :var_parm")
	public abstract List<Usuario> listaPorNombre(@Param("var_parm") String nombre);


}
