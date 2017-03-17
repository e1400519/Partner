package se;

import java.util.List;

import se.Partner;
import se.MaterialDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    		MaterialDao dao = new MaterialDao();
    		dao.init();
    		return dao.getDaos();
    		}
}    

