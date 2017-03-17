package se;

import java.util.List;

import se.Partner;
import se.PartnerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {
	@Autowired
	private PartnerRepository repository;
    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hell no \"}";
    }
    
    @RequestMapping("/partners")
    	public List<Partner> partners(@RequestParam(value="name", defaultValue="World") String name) {
    		PartnerDao dao = new PartnerDao();
    		dao.init();
    		return dao.getDaos();
    		}
    
    @RequestMapping(value="/partner", method = RequestMethod.POST)
    //näin luetaan suoraa JSON Liiketoimintaluokaksi jonka nimi on Partner
    public @ResponseBody Partner addPartner(@RequestBody Partner jsonPartner){
    	repository.save(jsonPartner);
    	return jsonPartner;
		}
}    

