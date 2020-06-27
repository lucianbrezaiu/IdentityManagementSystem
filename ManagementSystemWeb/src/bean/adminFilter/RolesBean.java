package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.RoleDAORemote;
import dto.RoleDTO;
import exception.LoginException;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RolesBean {

	@EJB
	private RoleDAORemote roleDAORemote;
	private RoleDTO roleDTO;
	private LinksBean linksBean;
	
	public RolesBean() {
		roleDTO = new RoleDTO();
		linksBean = new LinksBean();
	}

	public List<RoleDTO> getRoles(){
		return roleDAORemote.findAll();
	}
	
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public LinksBean getLinksBean() {
		return linksBean;
	}

	public void setLinksBean(LinksBean linksBean) {
		this.linksBean = linksBean;
	}

	public String addRole() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			RoleDTO role= roleDAORemote.findByName(roleDTO.getName().trim());
			if(role != null) {
				facesContext.addMessage("addRoleForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Role already exist!", null));
				return null;
			}
			roleDAORemote.create(roleDTO);
			roleDTO = new RoleDTO();
			return linksBean.getADMIN_ROLES_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addRoleForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
}
