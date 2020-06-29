package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.RightDAORemote;
import dto.RightDTO;
import dto.RoleDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RightsBean {

	@EJB
	private RightDAORemote rightDAORemote;
	private RightDTO rightDTO;
	private LinksBean linksBean;
	
	public RightsBean() {
		rightDTO = new RightDTO();
		linksBean = new LinksBean();
	}

	public List<RightDTO> getRights(){
		return rightDAORemote.findAll();
	}
	
	public LinksBean getLinksBean() {
		return linksBean;
	}

	public void setLinksBean(LinksBean linksBean) {
		this.linksBean = linksBean;
	}

	public RightDTO getRightDTO() {
		return rightDTO;
	}

	public void setRightDTO(RightDTO rightDTO) {
		this.rightDTO = rightDTO;
	}
	
	public String addRight() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			RightDTO right= rightDAORemote.findByName(rightDTO.getName().trim());
			if(right != null) {
				facesContext.addMessage("addRightForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Right already exist!", null));
				return null;
			}
			rightDAORemote.create(rightDTO);
			rightDTO = new RightDTO();
			return linksBean.getADMIN_RIGHTS_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addRightForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
}

