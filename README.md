Aplicație java enterprise cu următoarea arhitectură:
1. ManagementSystemEar
	- tip proiect: Enterprise Application Project
	- reprezintă entry-pointul aplicației
	- conține referințe către partea de client și partea de ejbClient
2. ManagementSystemEjb
	- tip proiect: EJB Project
	- este adăugat ca referință a proiectului ear
	- conține implementarea serviciilor folosite ce au interfețele în ejbClient
3. ManagementSystemEjbClient
	- este creat automat în momentul creării proiectului ejbClient
	- conține interfețele serviciilor folosite
	- proiectul este adăugat ca referință în ManagementSystemWeb pentru a putea
	accesa apela funcționalitățile
4. ManagementSystemWeb
	- tip proiect: Dynamic Web Project
	- reprezintă partea de client a aplicației
	- este adăugat ca referință a proiectului ear
	
Pași pentru a rula proiectul:
1. deschid folderul ce conține proiectele în eclipse
2. click dreapta pe proiectul ear
3. Run as -> Run on server
4. selectez serverul Glassfish care a fost anterior configurat în eclipse
5. Finish.
6. După ce serverul pornește și face deploy cu succes, aplicația este disponibilă
la adresa: http://localhost:8080/ManagementSystemWeb/index.xhtml