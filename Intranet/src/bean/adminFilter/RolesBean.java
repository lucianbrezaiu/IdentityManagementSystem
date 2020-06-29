package bean.adminFilter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.RightDAORemote;
import dao.RoleDAORemote;
import dto.RightDTO;
import dto.RoleDTO;
import exception.LoginException;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RolesBean {

	@EJB
	private RoleDAORemote roleDAORemote;
	
	@EJB
	private RightDAORemote rightDAORemote;
	
	private RoleDTO roleDTO;
	private LinksBean linksBean;
	private List<Integer> selectedRightsIds;
	
	public RolesBean() {
		roleDTO = new RoleDTO();
		linksBean = new LinksBean();
		selectedRightsIds = new ArrayList<Integer>();
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
	
	public List<Integer> getSelectedRightsIds() {
		return selectedRightsIds;
	}

	public void setSelectedRightsIds(List<Integer> selectedRightsIds) {
		this.selectedRightsIds = selectedRightsIds;
	}

	public List<RightDTO> getAllRights() {
		return rightDAORemote.findAll();
	}

	public String addRole() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			RoleDTO role= roleDAORemote.findByName(roleDTO.getName().trim());
			if(role != null) {
				facesContext.addMessage("addRoleForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Role already exist!", null));
				return null;
			}
			
			List<RightDTO> dtoRights = new ArrayList<RightDTO>();
			for (Integer rightId : selectedRightsIds) {
				RightDTO rightDTO = new RightDTO();
				rightDTO.setId(rightId);
				dtoRights.add(rightDTO);
			}
			roleDTO.setDtoRights(dtoRights);
			roleDAORemote.create(roleDTO);
			roleDTO = new RoleDTO();
			selectedRightsIds = new ArrayList<Integer>();
			return linksBean.getADMIN_ROLES_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addRoleForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
	
	public String rightsToString(List<RightDTO> rightsDTO) {
		if(rightsDTO.size()==0) {
			return "";
		}
		
		String str = "";
		for (RightDTO rightDTO : rightsDTO) {
			str += String.format("%s,", rightDTO.getName());
		}
		return str.substring(0, str.length() - 1);
	}
}
