package com.parroquia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parroquia.entity.Opcion;
import com.parroquia.entity.Rol;
import com.parroquia.entity.Usuario;
import com.parroquia.service.UsuarioService;

@Controller
public class LoginController {

	
	@Autowired
	private UsuarioService servicio;

//LOGIN PAG INICIAL 
	@RequestMapping("/verLogin")
	public String verLogin() { return "login"; }
	
	
	@RequestMapping("/verIntranetHome")
	public String verHome() { return "intranetHome"; }
	
	//--------------PESTAÑA MANTENIMIENTO (CRUD)-----------------------
	
	@RequestMapping("/crudBautiso")
	public String crudBautiso() { return "crudBautiso"; }
	
	@RequestMapping("/crudConfirmacion")
	public String crudConfirmacion() { return "crudConfirmacion"; }
	
	@RequestMapping("/crudMatrimonio")
	public String crudMatrimonio() { return "crudMatrimonio"; }
	
	
	//-------------------PESTAÑA REGISTRO ---------------------------
	
	@RequestMapping("/registraSolicitudCertificado")
	public String registraSolicitudCertificado() { return "intranetRegistraSolicitudCertificado"; }

	@RequestMapping("/registraAlquilerSalones")
	public String registraAlquilerSalones() { return "intranetRegistraAlquilerSalones"; }
	
	@RequestMapping("/registraUsuario")
	public String registraUsuario() { return "intranetRegistraUsuario"; }

	@RequestMapping("/registraDonaciones")
	public String registraDonaciones() { return "intranetRegistraDonaciones";}
	
	@RequestMapping("/registraMisas")
	public String registraMisas() { return "intranetRegistraMisas";
	}

	//-------------------PESTAÑA CONSULTA  ---------------------------

	@RequestMapping("/enlaceConsultaMisa")
	public String enlaceConsultaCurso() { return "intranetConsultaAutor"; }
	
	@RequestMapping("/enlaceConsultaBautisos")
	public String enlaceConsultaAutor() { return "intranetConsultaCurso"; }

	
	@RequestMapping("/enlaceConsultaCertificados")
	public String enlaceConsultaLibro() { return "intranetConsultaLibro"; }

	
	@RequestMapping("/enlaceConsultaDisponibilidad")
	public String enlaceConsultaDisponibilidad() { return "intranetConsultaDisponibilidad"; }

	
	@RequestMapping("/login")
	public String login(Usuario usu, HttpSession  session, HttpServletRequest request) {
		
		Usuario objUsu = servicio.login(usu);
		if(objUsu == null) {
			request.setAttribute("mensaje", "El usuario no existe");
			return "login";
		}else {
			List<Rol> roles = servicio.traerRolesDeUsuario(objUsu.getIdUsuario());
			List<Opcion> menus = servicio.traerEnlacesDeUsuario(objUsu.getIdUsuario());
			
			session.setAttribute("objUsuario", objUsu);
			session.setAttribute("objRoles", roles);
			session.setAttribute("objMenus", menus);
			return "redirect:home";
		}
	}
	
	@RequestMapping("/home")
	public String salida() {
		return "intranetHome";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		//Destruir todos los objetos de la sesion mediante programación
		session.invalidate();

		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "login";

	}
	
	
	
	
	
	
	
	
	
	
	
}
